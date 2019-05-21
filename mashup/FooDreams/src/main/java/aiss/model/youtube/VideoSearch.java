
package aiss.model.youtube;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kind",
    "etag",
    "nextPageToken",
    "regionCode",
    "pageInfo",
    "items"
})
public class VideoSearch {

    @JsonProperty("kind")
    private String kind;
    @JsonProperty("etag")
    private String etag;
    @JsonProperty("nextPageToken")
    private String nextPageToken;
    @JsonProperty("regionCode")
    private String regionCode;
    @JsonProperty("items")
    private List<Item> items = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("etag")
    public String getEtag() {
        return etag;
    }

    @JsonProperty("etag")
    public void setEtag(String etag) {
        this.etag = etag;
    }

    @JsonProperty("nextPageToken")
    public String getNextPageToken() {
        return nextPageToken;
    }

    @JsonProperty("nextPageToken")
    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    @JsonProperty("regionCode")
    public String getRegionCode() {
        return regionCode;
    }

    @JsonProperty("regionCode")
    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
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
