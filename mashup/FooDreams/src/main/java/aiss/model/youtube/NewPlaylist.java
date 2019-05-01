package aiss.model.youtube;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "snippet",
    "status",
    "id"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class NewPlaylist {
    @JsonProperty("snippet")
    private Snippet_ snippet;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("snippet")
    public Snippet_ getSnippet() {
        return snippet;
    }

    @JsonProperty("snippet")
    public void setSnippet(Snippet_ snippet) {
        this.snippet = snippet;
    }
    
    @JsonProperty("status")
    public Status getStatus() {
    	return status;
    }
    
    @JsonProperty("status")
    public void setStatus(Status status) {
    	this.status = status;
    }
    
    @JsonProperty("id")
    public String getId() {
    	return id;
    }
    
    @JsonProperty("id")
    public void setId(String id) {
    	this.id = id;
    }
}
