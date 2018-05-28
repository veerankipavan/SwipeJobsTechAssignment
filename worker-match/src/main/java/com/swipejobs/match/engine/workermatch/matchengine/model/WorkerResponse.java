
package com.swipejobs.match.engine.workermatch.matchengine.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "workerDetails",
    "jobDetails"
})
public class WorkerResponse {

    @JsonProperty("workerDetails")
    private WorkerDetails workerDetails;
    @JsonProperty("jobDetails")
    private List<JobDetails> jobDetails = new ArrayList<JobDetails>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("workerDetails")
    public WorkerDetails getWorkerDetails() {
        return workerDetails;
    }

    @JsonProperty("workerDetails")
    public void setWorkerDetails(WorkerDetails workerDetails) {
        this.workerDetails = workerDetails;
    }

    public WorkerResponse withWorkerDetails(WorkerDetails workerDetails) {
        this.workerDetails = workerDetails;
        return this;
    }

    @JsonProperty("jobDetails")
    public List<JobDetails> getJobDetails() {
        return jobDetails;
    }

    @JsonProperty("jobDetails")
    public void setJobDetails(List<JobDetails> jobDetails) {
        this.jobDetails = jobDetails;
    }

    public WorkerResponse withJobDetails(List<JobDetails> jobDetails) {
        this.jobDetails = jobDetails;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public WorkerResponse withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(workerDetails).append(jobDetails).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof WorkerResponse) == false) {
            return false;
        }
        WorkerResponse rhs = ((WorkerResponse) other);
        return new EqualsBuilder().append(workerDetails, rhs.workerDetails).append(jobDetails, rhs.jobDetails).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
