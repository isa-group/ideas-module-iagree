
package es.us.isa.ideas.iagree.common.portalConfig;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "account",
    "clientID",
    "secret"
})
public class Paypal {

    @JsonProperty("account")
    private String account;
    @JsonProperty("clientID")
    private String clientID;
    @JsonProperty("secret")
    private String secret;

    /**
     * 
     * @return
     *     The account
     */
    @JsonProperty("account")
    public String getAccount() {
        return account;
    }

    /**
     * 
     * @param account
     *     The account
     */
    @JsonProperty("account")
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 
     * @return
     *     The clientID
     */
    @JsonProperty("clientID")
    public String getClientID() {
        return clientID;
    }

    /**
     * 
     * @param clientID
     *     The clientID
     */
    @JsonProperty("clientID")
    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    /**
     * 
     * @return
     *     The secret
     */
    @JsonProperty("secret")
    public String getSecret() {
        return secret;
    }

    /**
     * 
     * @param secret
     *     The secret
     */
    @JsonProperty("secret")
    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
