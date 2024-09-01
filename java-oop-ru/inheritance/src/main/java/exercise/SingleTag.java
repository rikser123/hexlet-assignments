package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    SingleTag(String tagName, Map<String, String> attributes) {
        super(tagName, attributes);
    }

    @Override()
    public String toString() {
        return "<" + this.tagName + this.renderAttributes() + ">";
    }
}
// END
