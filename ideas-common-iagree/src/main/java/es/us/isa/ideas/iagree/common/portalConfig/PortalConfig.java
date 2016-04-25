package es.us.isa.ideas.iagree.common.portalConfig;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "type",
    "plan",
    "datastore",
    "paypal"
})
public class PortalConfig {

    @JsonProperty("type")
    private String type;
    @JsonProperty("plan")
    private Plan plan;
    @JsonProperty("datastore")
    private String datastore;
    @JsonProperty("paypal")
    private Paypal paypal;

    /**
     *
     * @return The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     *
     * @param type The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return The plan
     */
    @JsonProperty("plan")
    public Plan getPlan() {
        return plan;
    }

    /**
     *
     * @param plan The plan
     */
    @JsonProperty("plan")
    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    /**
     *
     * @return The datastore
     */
    @JsonProperty("datastore")
    public String getDatastore() {
        return datastore;
    }

    /**
     *
     * @param datastore The datastore
     */
    @JsonProperty("datastore")
    public void setDatastore(String datastore) {
        this.datastore = datastore;
    }

    /**
     *
     * @return The paypal
     */
    @JsonProperty("paypal")
    public Paypal getPaypal() {
        return paypal;
    }

    /**
     *
     * @param paypal The paypal
     */
    @JsonProperty("paypal")
    public void setPaypal(Paypal paypal) {
        this.paypal = paypal;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
