package aiss.model.youtube;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "snippet",
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class PlaylistItem {
	@JsonProperty("snippet")
	private Snippet_ snippet;
	
	public Snippet_ getSnippet() {
		return snippet;
	}
	
	public void setSnippet(Snippet_ snippet) {
		this.snippet = snippet;
	}
}
