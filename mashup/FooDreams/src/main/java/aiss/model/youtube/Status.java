package aiss.model.youtube;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "privacyStatus"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class Status {
    @JsonProperty("privacyStatus")
    private String privacyStatus;
    
    @JsonProperty("privacyStatus")
    public String getPrivacyStatus() {
        return privacyStatus;
    }

    @JsonProperty("privacyStatus")
    public void setPrivacyStatus(String privacyStatus) {
        this.privacyStatus = privacyStatus;
    }
}
