
package aiss.model.edamam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "sane",
    "to",
    "diet",
    "q",
    "ingr",
    "app_id",
    "app_key"
})
public class Params {

    @JsonProperty("sane")
    private List<Object> sane = null;
    @JsonProperty("to")
    private List<String> to = null;
    @JsonProperty("diet")
    private List<String> diet = null;
    @JsonProperty("q")
    private List<String> q = null;
    @JsonProperty("ingr")
    private List<String> ingr = null;
    @JsonProperty("app_id")
    private List<String> appId = null;
    @JsonProperty("app_key")
    private List<String> appKey = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("sane")
    public List<Object> getSane() {
        return sane;
    }

    @JsonProperty("sane")
    public void setSane(List<Object> sane) {
        this.sane = sane;
    }

    @JsonProperty("to")
    public List<String> getTo() {
        return to;
    }

    @JsonProperty("to")
    public void setTo(List<String> to) {
        this.to = to;
    }

    @JsonProperty("diet")
    public List<String> getDiet() {
        return diet;
    }

    @JsonProperty("diet")
    public void setDiet(List<String> diet) {
        this.diet = diet;
    }

    @JsonProperty("q")
    public List<String> getQ() {
        return q;
    }

    @JsonProperty("q")
    public void setQ(List<String> q) {
        this.q = q;
    }

    @JsonProperty("ingr")
    public List<String> getIngr() {
        return ingr;
    }

    @JsonProperty("ingr")
    public void setIngr(List<String> ingr) {
        this.ingr = ingr;
    }

    @JsonProperty("app_id")
    public List<String> getAppId() {
        return appId;
    }

    @JsonProperty("app_id")
    public void setAppId(List<String> appId) {
        this.appId = appId;
    }

    @JsonProperty("app_key")
    public List<String> getAppKey() {
        return appKey;
    }

    @JsonProperty("app_key")
    public void setAppKey(List<String> appKey) {
        this.appKey = appKey;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
