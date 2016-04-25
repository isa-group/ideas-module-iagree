package es.us.isa.ideas.iagree.common.portalConfig;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "renderMode",
    "content"
})
public class Plan {

    @JsonProperty("renderMode")
    private String renderMode;
    @JsonProperty("content")
    private List<Content> content = new ArrayList<>();

    /**
     *
     * @return The renderMode
     */
    @JsonProperty("renderMode")
    public String getRenderMode() {
        return renderMode;
    }

    /**
     *
     * @param renderMode The renderMode
     */
    @JsonProperty("renderMode")
    public void setRenderMode(String renderMode) {
        this.renderMode = renderMode;
    }

    /**
     *
     * @return The content
     */
    @JsonProperty("content")
    public List<Content> getContent() {
        return content;
    }

    /**
     *
     * @param content The content
     */
    @JsonProperty("content")
    public void setContent(List<Content> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
