package com.swipejobs.match.engine.workermatch.matchengine.service;

import com.swipejobs.match.engine.workermatch.matchengine.model.WorkerCriteria;
import com.swipejobs.match.engine.workermatch.matchengine.model.WorkerDetails;

public interface MatchService {

    public WorkerCriteria getWorkerCriteria(WorkerDetails workerDetails);
}
