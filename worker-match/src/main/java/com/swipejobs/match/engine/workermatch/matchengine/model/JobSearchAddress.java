
package com.swipejobs.match.engine.workermatch.matchengine.model;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "unit",
    "maxJobDistance",
    "longitude",
    "latitude"
})
public class JobSearchAddress {

    @JsonProperty("unit")
    private String unit;
    @JsonProperty("maxJobDistance")
    private Integer maxJobDistance;
    @JsonProperty("longitude")
    private String longitude;
    @JsonProperty("latitude")
    private String latitude;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("unit")
    public String getUnit() {
        return unit;
    }

    @JsonProperty("unit")
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public JobSearchAddress withUnit(String unit) {
        this.unit = unit;
        return this;
    }

    @JsonProperty("maxJobDistance")
    public Integer getMaxJobDistance() {
        return maxJobDistance;
    }

    @JsonProperty("maxJobDistance")
    public void setMaxJobDistance(Integer maxJobDistance) {
        this.maxJobDistance = maxJobDistance;
    }

    public JobSearchAddress withMaxJobDistance(Integer maxJobDistance) {
        this.maxJobDistance = maxJobDistance;
        return this;
    }

    @JsonProperty("longitude")
    public String getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public JobSearchAddress withLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    @JsonProperty("latitude")
    public String getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public JobSearchAddress withLatitude(String latitude) {
        this.latitude = latitude;
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

    public JobSearchAddress withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(unit).append(maxJobDistance).append(longitude).append(latitude).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof JobSearchAddress) == false) {
            return false;
        }
        JobSearchAddress rhs = ((JobSearchAddress) other);
        return new EqualsBuilder().append(unit, rhs.unit).append(maxJobDistance, rhs.maxJobDistance).append(longitude, rhs.longitude).append(latitude, rhs.latitude).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
