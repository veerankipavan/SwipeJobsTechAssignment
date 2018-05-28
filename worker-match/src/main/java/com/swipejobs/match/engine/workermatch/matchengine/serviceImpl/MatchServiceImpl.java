package com.swipejobs.match.engine.workermatch.matchengine.serviceImpl;

import com.swipejobs.match.engine.workermatch.matchengine.model.WorkerCriteria;
import com.swipejobs.match.engine.workermatch.matchengine.model.WorkerDetails;
import com.swipejobs.match.engine.workermatch.matchengine.service.MatchService;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService {


    @Override
    public WorkerCriteria getWorkerCriteria(WorkerDetails workerDetails) {
                 return new WorkerCriteria(workerDetails.getCertificates(),workerDetails.getSkills(),workerDetails.getHasDriversLicense(),workerDetails.getJobSearchAddress());
    }
}
