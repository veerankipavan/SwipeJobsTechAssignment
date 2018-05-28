package com.swipejobs.match.engine.workermatch.matchengine.model;

import java.util.ArrayList;
import java.util.List;

public class WorkerCriteria {

    private List<String> certificates;

    private List<String> skills;

    private Boolean hasDriversLicense;

    private JobSearchAddress jobSearchAddress;


    public WorkerCriteria(List<String> certificates, List<String> skills, Boolean hasDriversLicense,JobSearchAddress jobSearchAddress  ){
        super();
        this.certificates=certificates;
        this.skills=skills;
        this.hasDriversLicense=hasDriversLicense;
        this.jobSearchAddress=jobSearchAddress;
    }


    public List<String> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<String> certificates) {
        this.certificates = certificates;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Boolean getHasDriversLicense() {
        return hasDriversLicense;
    }

    public void setHasDriversLicense(Boolean hasDriversLicense) {
        this.hasDriversLicense = hasDriversLicense;
    }

    public JobSearchAddress getJobSearchAddress() {
        return jobSearchAddress;
    }

    public void setJobSearchAddress(JobSearchAddress jobSearchAddress) {
        this.jobSearchAddress = jobSearchAddress;
    }
}
