package es.us.isa.ideas.iagree.common.portalConfig;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "authority"
})
public class Authority {

    @JsonProperty("authority")
    private String authority;

    /**
     *
     * @return The authority
     */
    @JsonProperty("authority")
    public String getAuthority() {
        return authority;
    }

    /**
     *
     * @param authority The authority
     */
    @JsonProperty("authority")
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(authority).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Authority) == false) {
            return false;
        }
        Authority rhs = ((Authority) other);
        return new EqualsBuilder().append(authority, rhs.authority).isEquals();
    }

}
