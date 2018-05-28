
package com.swipejobs.match.engine.workermatch.matchengine.model;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "rating",
    "isActive",
    "certificates",
    "skills",
    "jobSearchAddress",
    "transportation",
    "hasDriversLicense",
    "availability",
    "phone",
    "email",
    "name",
    "age",
    "guid",
    "userId"
})
public class WorkerDetails {

    @JsonProperty("rating")
    private Integer rating;
    @JsonProperty("isActive")
    private Boolean isActive;
    @JsonProperty("certificates")
    private List<String> certificates = new ArrayList<String>();
    @JsonProperty("skills")
    private List<String> skills = new ArrayList<String>();
    @JsonProperty("jobSearchAddress")
    private JobSearchAddress jobSearchAddress;
    @JsonProperty("transportation")
    private String transportation;
    @JsonProperty("hasDriversLicense")
    private Boolean hasDriversLicense;
    @JsonProperty("availability")
    private List<Availability> availability = new ArrayList<Availability>();
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("email")
    private String email;
    @JsonProperty("name")
    private Name name;
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("guid")
    private String guid;
    @JsonProperty("userId")
    private Integer userId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("rating")
    public Integer getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public WorkerDetails withRating(Integer rating) {
        this.rating = rating;
        return this;
    }

    @JsonProperty("isActive")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public WorkerDetails withIsActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    @JsonProperty("certificates")
    public List<String> getCertificates() {
        return certificates;
    }

    @JsonProperty("certificates")
    public void setCertificates(List<String> certificates) {
        this.certificates = certificates;
    }

    public WorkerDetails withCertificates(List<String> certificates) {
        this.certificates = certificates;
        return this;
    }

    @JsonProperty("skills")
    public List<String> getSkills() {
        return skills;
    }

    @JsonProperty("skills")
    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public WorkerDetails withSkills(List<String> skills) {
        this.skills = skills;
        return this;
    }

    @JsonProperty("jobSearchAddress")
    public JobSearchAddress getJobSearchAddress() {
        return jobSearchAddress;
    }

    @JsonProperty("jobSearchAddress")
    public void setJobSearchAddress(JobSearchAddress jobSearchAddress) {
        this.jobSearchAddress = jobSearchAddress;
    }

    public WorkerDetails withJobSearchAddress(JobSearchAddress jobSearchAddress) {
        this.jobSearchAddress = jobSearchAddress;
        return this;
    }

    @JsonProperty("transportation")
    public String getTransportation() {
        return transportation;
    }

    @JsonProperty("transportation")
    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    public WorkerDetails withTransportation(String transportation) {
        this.transportation = transportation;
        return this;
    }

    @JsonProperty("hasDriversLicense")
    public Boolean getHasDriversLicense() {
        return hasDriversLicense;
    }

    @JsonProperty("hasDriversLicense")
    public void setHasDriversLicense(Boolean hasDriversLicense) {
        this.hasDriversLicense = hasDriversLicense;
    }

    public WorkerDetails withHasDriversLicense(Boolean hasDriversLicense) {
        this.hasDriversLicense = hasDriversLicense;
        return this;
    }

    @JsonProperty("availability")
    public List<Availability> getAvailability() {
        return availability;
    }

    @JsonProperty("availability")
    public void setAvailability(List<Availability> availability) {
        this.availability = availability;
    }

    public WorkerDetails withAvailability(List<Availability> availability) {
        this.availability = availability;
        return this;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public WorkerDetails withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    public WorkerDetails withEmail(String email) {
        this.email = email;
        return this;
    }

    @JsonProperty("name")
    public Name getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(Name name) {
        this.name = name;
    }

    public WorkerDetails withName(Name name) {
        this.name = name;
        return this;
    }

    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(Integer age) {
        this.age = age;
    }

    public WorkerDetails withAge(Integer age) {
        this.age = age;
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

    public WorkerDetails withGuid(String guid) {
        this.guid = guid;
        return this;
    }

    @JsonProperty("userId")
    public Integer getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public WorkerDetails withUserId(Integer userId) {
        this.userId = userId;
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

    public WorkerDetails withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(rating).append(isActive).append(certificates).append(skills).append(jobSearchAddress).append(transportation).append(hasDriversLicense).append(availability).append(phone).append(email).append(name).append(age).append(guid).append(userId).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof WorkerDetails) == false) {
            return false;
        }
        WorkerDetails rhs = ((WorkerDetails) other);
        return new EqualsBuilder().append(rating, rhs.rating).append(isActive, rhs.isActive).append(certificates, rhs.certificates).append(skills, rhs.skills).append(jobSearchAddress, rhs.jobSearchAddress).append(transportation, rhs.transportation).append(hasDriversLicense, rhs.hasDriversLicense).append(availability, rhs.availability).append(phone, rhs.phone).append(email, rhs.email).append(name, rhs.name).append(age, rhs.age).append(guid, rhs.guid).append(userId, rhs.userId).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
