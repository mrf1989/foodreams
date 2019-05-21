
package aiss.model.edamam;

import java.util.HashMap;
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
    "ENERC_KCAL",
    "FAT",
    "FASAT",
    "FATRN",
    "FAMS",
    "FAPU",
    "CHOCDF",
    "FIBTG",
    "SUGAR",
    "PROCNT",
    "CHOLE",
    "NA",
    "CA",
    "MG",
    "K",
    "FE",
    "ZN",
    "P",
    "VITA_RAE",
    "VITC",
    "THIA",
    "RIBF",
    "NIA",
    "VITB6A",
    "FOL",
    "VITB12",
    "VITD",
    "TOCPHA",
    "VITK1"
})
public class TotalNutrients {

    @JsonProperty("ENERC_KCAL")
    private ENERCKCAL eNERCKCAL;
    @JsonProperty("FAT")
    private FAT fAT;
    @JsonProperty("CHOCDF")
    private CHOCDF cHOCDF;
    @JsonProperty("FIBTG")
    private FIBTG fIBTG;
    @JsonProperty("SUGAR")
    private SUGAR sUGAR;
    @JsonProperty("PROCNT")
    private PROCNT pROCNT;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ENERC_KCAL")
    public ENERCKCAL getENERCKCAL() {
        return eNERCKCAL;
    }

    @JsonProperty("ENERC_KCAL")
    public void setENERCKCAL(ENERCKCAL eNERCKCAL) {
        this.eNERCKCAL = eNERCKCAL;
    }

    @JsonProperty("FAT")
    public FAT getFAT() {
        return fAT;
    }

    @JsonProperty("FAT")
    public void setFAT(FAT fAT) {
        this.fAT = fAT;
    }

    @JsonProperty("CHOCDF")
    public CHOCDF getCHOCDF() {
        return cHOCDF;
    }

    @JsonProperty("CHOCDF")
    public void setCHOCDF(CHOCDF cHOCDF) {
        this.cHOCDF = cHOCDF;
    }

    @JsonProperty("FIBTG")
    public FIBTG getFIBTG() {
        return fIBTG;
    }

    @JsonProperty("FIBTG")
    public void setFIBTG(FIBTG fIBTG) {
        this.fIBTG = fIBTG;
    }

    @JsonProperty("SUGAR")
    public SUGAR getSUGAR() {
        return sUGAR;
    }

    @JsonProperty("SUGAR")
    public void setSUGAR(SUGAR sUGAR) {
        this.sUGAR = sUGAR;
    }

    @JsonProperty("PROCNT")
    public PROCNT getPROCNT() {
        return pROCNT;
    }

    @JsonProperty("PROCNT")
    public void setPROCNT(PROCNT pROCNT) {
        this.pROCNT = pROCNT;
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
