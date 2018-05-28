package com.swipejobs.match.engine.workermatch.matchengine.resource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swipejobs.match.engine.workermatch.matchengine.model.JobDetails;
import com.swipejobs.match.engine.workermatch.matchengine.model.WorkerCriteria;
import com.swipejobs.match.engine.workermatch.matchengine.model.WorkerDetails;
import com.swipejobs.match.engine.workermatch.matchengine.model.WorkerResponse;
import com.swipejobs.match.engine.workermatch.matchengine.service.MatchService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/matches")
public class MatchResource {
    @Autowired
    RestTemplate restTemplate;

    @Value("${swipejobs.workers.url}")
    private String workerResourceUrl;
    @Value("${swipejobs.jobs.url}")
    private String jobResourceUrl;


    @Autowired
    private MappingJackson2HttpMessageConverter springMvcJacksonConverter;
    @Autowired
    private MatchService matchService;

    @ApiOperation(value = "Return matching jobs with the supplied worker")
    @ApiResponses(value={@ApiResponse(code =200 ,message= "Jobs found for the worker"),
            @ApiResponse(code =404 ,message= "No Jobs found for the worker"),
            @ApiResponse(code =500 ,message= "Apologies for the inconvenience caused, please try again later"),
            @ApiResponse(code =401 ,message= "Search Operation is Unauthorized"),
            @ApiResponse(code =403 ,message= "Search Operation is Forbidden")
    })
    @GetMapping(value = "/workerId/{id}")
    public List<JobDetails> matchWorkersById(@PathVariable String id){

        HttpHeaders headers= new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity requestEntity= new HttpEntity(headers);
        ResponseEntity<String> response=null;
        List<JobDetails> jobDetails=null;

        WorkerResponse workerResponse = new WorkerResponse();
        try {

                //Rest Call to get the Worker Details
                response = restTemplate.exchange(
                        workerResourceUrl ,
                        HttpMethod.GET,
                        requestEntity,
                        String.class);

                ObjectMapper objectMapper = springMvcJacksonConverter.getObjectMapper();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,true);
                List<WorkerDetails> workerDetails = objectMapper.readValue(response.getBody(), new TypeReference<List<WorkerDetails>>() {});
                //Filter the Workerdetails objects by ID
                WorkerDetails workerDetail = workerDetails.stream().filter(e -> e.getUserId().equals(Integer.parseInt(id))).findFirst().orElse(null);
                jobDetails = getAllJobs();
                final WorkerCriteria workerCriteria = matchService.getWorkerCriteria(workerDetail);
                // Get the possible matching jobs for the worker
                jobDetails = matchingJobsforWorker(workerCriteria,jobDetails);

            } catch (Exception e) {
           System.out.println(e.getMessage());
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
            jobDetails=new ArrayList<JobDetails>();

        }

        return  jobDetails;
    }

    private List<JobDetails> getAllJobs(){
        HttpHeaders headers= new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity requestEntity= new HttpEntity(headers);
        ResponseEntity<String> response=null;
        List<JobDetails> jobDetails=null;

        try {
                ObjectMapper objectMapper = springMvcJacksonConverter.getObjectMapper();
                //Rest Call to get the Job Details
                response = restTemplate.exchange(
                        jobResourceUrl,
                        HttpMethod.GET,
                        requestEntity,
                        String.class);
                jobDetails = objectMapper.readValue(response.getBody(), new TypeReference<List<JobDetails>>() {   });

        }  catch (Exception e) {
        System.out.println(e.getMessage());
    }
        return jobDetails;
    }

    private List<JobDetails> matchingJobsforWorker(WorkerCriteria workerCriteria,List<JobDetails> jobDetails){

        jobDetails = jobDetails.parallelStream()
                .filter(e -> workerCriteria.getHasDriversLicense().equals(e.getDriverLicenseRequired()))
                .filter(e -> workerCriteria.getSkills().contains(e.getJobTitle()))
                .filter(e -> workerCriteria.getCertificates().containsAll(e.getRequiredCertificates()))
                .filter(e -> distance(
                            Double.parseDouble(e.getLocation().getLatitude()),
                            Double.parseDouble(e.getLocation().getLongitude()),
                            Double.parseDouble(workerCriteria.getJobSearchAddress().getLatitude()),
                            Double.parseDouble(workerCriteria.getJobSearchAddress().getLongitude()))
                            < workerCriteria.getJobSearchAddress().getMaxJobDistance()).limit(3)
                .collect(Collectors.toList());

        return jobDetails;
    }


    private static double distance(double lat1, double lon1, double lat2, double lon2) {
            double theta = lon1 - lon2;
            double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
            dist = Math.acos(dist);
            dist = rad2deg(dist);
            dist = dist * 60 * 1.1515 * 1.609344;
            return dist;
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }
}
