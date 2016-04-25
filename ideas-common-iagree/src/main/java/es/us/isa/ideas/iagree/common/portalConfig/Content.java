
package es.us.isa.ideas.iagree.common.portalConfig;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "modelURL",
    "viewURL",
    "ctlURL",
    "customizable"
})
public class Content {

    @JsonProperty("modelURL")
    private String modelURL;
    @JsonProperty("viewURL")
    private String viewURL;
    @JsonProperty("ctlURL")
    private String ctlURL;
    @JsonProperty("customizable")
    private Boolean customizable;

    /**
     * 
     * @return
     *     The modelURL
     */
    @JsonProperty("modelURL")
    public String getModelURL() {
        return modelURL;
    }

    /**
     * 
     * @param modelURL
     *     The modelURL
     */
    @JsonProperty("modelURL")
    public void setModelURL(String modelURL) {
        this.modelURL = modelURL;
    }

    /**
     * 
     * @return
     *     The viewURL
     */
    @JsonProperty("viewURL")
    public String getViewURL() {
        return viewURL;
    }

    /**
     * 
     * @param viewURL
     *     The viewURL
     */
    @JsonProperty("viewURL")
    public void setViewURL(String viewURL) {
        this.viewURL = viewURL;
    }

    /**
     * 
     * @return
     *     The ctlURL
     */
    @JsonProperty("ctlURL")
    public String getCtlURL() {
        return ctlURL;
    }

    /**
     * 
     * @param ctlURL
     *     The ctlURL
     */
    @JsonProperty("ctlURL")
    public void setCtlURL(String ctlURL) {
        this.ctlURL = ctlURL;
    }

    /**
     * 
     * @return
     *     The customizable
     */
    @JsonProperty("customizable")
    public Boolean getCustomizable() {
        return customizable;
    }

    /**
     * 
     * @param customizable
     *     The customizable
     */
    @JsonProperty("customizable")
    public void setCustomizable(Boolean customizable) {
        this.customizable = customizable;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
