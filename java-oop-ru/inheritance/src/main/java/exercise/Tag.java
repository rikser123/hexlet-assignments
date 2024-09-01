package exercise;

import java.util.Map;

// BEGIN
public class Tag {
    protected String tagName;
    private Map<String, String> attributes;

    public Tag(String tagName, Map<String, String> attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
    }

    protected String renderAttributes() {
        if (attributes.isEmpty()) {
            return "";
        }

        var entries = attributes.entrySet();
        var result = new StringBuilder();

        for (var entry : entries) {
            var key = entry.getKey();
            var value = entry.getValue();

            result.append(key + "=\"" + value +"\" ");
        }

        return " " + result.toString().trim();
    }
}
// END
