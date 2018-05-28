
package com.swipejobs.match.engine.workermatch.matchengine.model;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "title",
    "dayIndex"
})
public class Availability {

    @JsonProperty("title")
    private String title;
    @JsonProperty("dayIndex")
    private Integer dayIndex;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public Availability withTitle(String title) {
        this.title = title;
        return this;
    }

    @JsonProperty("dayIndex")
    public Integer getDayIndex() {
        return dayIndex;
    }

    @JsonProperty("dayIndex")
    public void setDayIndex(Integer dayIndex) {
        this.dayIndex = dayIndex;
    }

    public Availability withDayIndex(Integer dayIndex) {
        this.dayIndex = dayIndex;
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

    public Availability withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(title).append(dayIndex).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Availability) == false) {
            return false;
        }
        Availability rhs = ((Availability) other);
        return new EqualsBuilder().append(title, rhs.title).append(dayIndex, rhs.dayIndex).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
