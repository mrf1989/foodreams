package aiss.model.youtube;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kind",
    "videoId"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class ResourceId {
	@JsonProperty("kind")
	private String kind;
	@JsonProperty("videoId")
	private String videoId;
	
	@JsonProperty("kind")
	public String getKind() {
		return kind;
	}
	
	@JsonProperty("kind")
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	@JsonProperty("videoId")
	public String getVideoId() {
		return videoId;
	}
	
	@JsonProperty("videoId")
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
}
