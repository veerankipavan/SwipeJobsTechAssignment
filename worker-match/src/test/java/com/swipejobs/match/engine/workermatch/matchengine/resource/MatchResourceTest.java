package com.swipejobs.match.engine.workermatch.matchengine.resource;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasSize;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MatchResourceTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void test_matchWorkersById_should_return_matching_jobswithcount() throws Exception {
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/matches/workerId/14"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.*", hasSize(2)));
        result.andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void test_matchWorkersById_should_return_matching_jobs() throws Exception {
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/matches/workerId/14").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().json("[{\"driverLicenseRequired\":true,\"requiredCertificates\":[\"Healthy Living Promoter\"],\"location\":{\"longitude\":\"13.59357\",\"latitude\":\"50.015609\"},\"billRate\":\"$17.80\",\"workersRequired\":5,\"startDate\":\"2015-10-31T13:59:33.122Z\",\"about\":\"Aliqua dolor sunt aliquip ad esse Lorem duis irure reprehenderit nisi in consequat excepteur esse. Elit nulla elit eiusmod incididunt consectetur aute. Magna culpa magna enim irure duis in cupidatat minim. Dolore magna dolore ullamco ex duis non aliquip ullamco amet dolore ea esse qui. Occaecat aliquip ipsum voluptate culpa excepteur adipisicing.\",\"jobTitle\":\"Creator of opportunities\",\"company\":\"Kyagoro\",\"guid\":\"562f66aab8e4c3f2a1594c93\",\"jobId\":21},{\"driverLicenseRequired\":true,\"requiredCertificates\":[\"Excellence in Organization\"],\"location\":{\"longitude\":\"13.821311\",\"latitude\":\"50.08989\"},\"billRate\":\"$17.30\",\"workersRequired\":1,\"startDate\":\"2015-11-01T04:36:23.085Z\",\"about\":\"Eiusmod nisi ullamco qui commodo dolor est nulla tempor. Esse consectetur adipisicing consequat id id consectetur officia minim reprehenderit eu. Ullamco proident ullamco consequat aliquip sunt irure Lorem tempor labore esse. Sint ea deserunt excepteur minim ut magna dolore eu elit do cillum exercitation cillum.\",\"jobTitle\":\"Crayon Evangelist\",\"company\":\"Cinaster\",\"guid\":\"562f66aaf32d24f06dbfb3a2\",\"jobId\":30}]"));

        result.andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void test_matchWorkersById_should_not_retrurn_jobs_for_invalid_id() throws Exception {
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/matches/workerId/51"))
                .andExpect(MockMvcResultMatchers.status().is(200)).
                        andExpect(MockMvcResultMatchers.jsonPath("$.*").isEmpty());
        result.andDo(MockMvcResultHandlers.print());

    }


}
