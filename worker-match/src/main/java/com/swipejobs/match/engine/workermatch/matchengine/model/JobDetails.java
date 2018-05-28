
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
    "driverLicenseRequired",
    "requiredCertificates",
    "location",
    "billRate",
    "workersRequired",
    "startDate",
    "about",
    "jobTitle",
    "company",
    "guid",
    "jobId"
})
public class JobDetails {

    @JsonProperty("driverLicenseRequired")
    private Boolean driverLicenseRequired;
    @JsonProperty("requiredCertificates")
    private List<String> requiredCertificates = new ArrayList<String>();
    @JsonProperty("location")
    private Location location;
    @JsonProperty("billRate")
    private String billRate;
    @JsonProperty("workersRequired")
    private Integer workersRequired;
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("about")
    private String about;
    @JsonProperty("jobTitle")
    private String jobTitle;
    @JsonProperty("company")
    private String company;
    @JsonProperty("guid")
    private String guid;
    @JsonProperty("jobId")
    private Integer jobId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("driverLicenseRequired")
    public Boolean getDriverLicenseRequired() {
        return driverLicenseRequired;
    }

    @JsonProperty("driverLicenseRequired")
    public void setDriverLicenseRequired(Boolean driverLicenseRequired) {
        this.driverLicenseRequired = driverLicenseRequired;
    }

    public JobDetails withDriverLicenseRequired(Boolean driverLicenseRequired) {
        this.driverLicenseRequired = driverLicenseRequired;
        return this;
    }

    @JsonProperty("requiredCertificates")
    public List<String> getRequiredCertificates() {
        return requiredCertificates;
    }

    @JsonProperty("requiredCertificates")
    public void setRequiredCertificates(List<String> requiredCertificates) {
        this.requiredCertificates = requiredCertificates;
    }

    public JobDetails withRequiredCertificates(List<String> requiredCertificates) {
        this.requiredCertificates = requiredCertificates;
        return this;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    public JobDetails withLocation(Location location) {
        this.location = location;
        return this;
    }

    @JsonProperty("billRate")
    public String getBillRate() {
        return billRate;
    }

    @JsonProperty("billRate")
    public void setBillRate(String billRate) {
        this.billRate = billRate;
    }

    public JobDetails withBillRate(String billRate) {
        this.billRate = billRate;
        return this;
    }

    @JsonProperty("workersRequired")
    public Integer getWorkersRequired() {
        return workersRequired;
    }

    @JsonProperty("workersRequired")
    public void setWorkersRequired(Integer workersRequired) {
        this.workersRequired = workersRequired;
    }

    public JobDetails withWorkersRequired(Integer workersRequired) {
        this.workersRequired = workersRequired;
        return this;
    }

    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("startDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public JobDetails withStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    @JsonProperty("about")
    public String getAbout() {
        return about;
    }

    @JsonProperty("about")
    public void setAbout(String about) {
        this.about = about;
    }

    public JobDetails withAbout(String about) {
        this.about = about;
        return this;
    }

    @JsonProperty("jobTitle")
    public String getJobTitle() {
        return jobTitle;
    }

    @JsonProperty("jobTitle")
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public JobDetails withJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    @JsonProperty("company")
    public String getCompany() {
        return company;
    }

    @JsonProperty("company")
    public void setCompany(String company) {
        this.company = company;
    }

    public JobDetails withCompany(String company) {
        this.company = company;
        return this;
    }

    @JsonProperty("guid")
    public String getGuid() {
        return guid;
    }

    @JsonProperty("guid")
    public void setGuid(String guid) {
        this.guid = guid;
    }

    public JobDetails withGuid(String guid) {
        this.guid = guid;
        return this;
    }

    @JsonProperty("jobId")
    public Integer getJobId() {
        return jobId;
    }

    @JsonProperty("jobId")
    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public JobDetails withJobId(Integer jobId) {
        this.jobId = jobId;
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

    public JobDetails withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(driverLicenseRequired).append(requiredCertificates).append(location).append(billRate).append(workersRequired).append(startDate).append(about).append(jobTitle).append(company).append(guid).append(jobId).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof JobDetails) == false) {
            return false;
        }
        JobDetails rhs = ((JobDetails) other);
        return new EqualsBuilder().append(driverLicenseRequired, rhs.driverLicenseRequired).append(requiredCertificates, rhs.requiredCertificates).append(location, rhs.location).append(billRate, rhs.billRate).append(workersRequired, rhs.workersRequired).append(startDate, rhs.startDate).append(about, rhs.about).append(jobTitle, rhs.jobTitle).append(company, rhs.company).append(guid, rhs.guid).append(jobId, rhs.jobId).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
