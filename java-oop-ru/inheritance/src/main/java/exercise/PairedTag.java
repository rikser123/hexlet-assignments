package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String value;
    private List<Tag> children;

    PairedTag(String tagName, Map<String, String> attributes, String value, List<Tag> children) {
        super(tagName, attributes);

        this.value = value;
        this.children = children;
    }

    @Override()
    public String toString() {
        var start = "<" + this.tagName  + this.renderAttributes() + ">";
        var end = "</" + this.tagName + ">";
        var childrenStr = children.stream().map(Tag::toString).collect(Collectors.joining(""));

        return start + value + childrenStr + end;
    }


}
// END
