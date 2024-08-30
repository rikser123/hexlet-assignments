package exercise;

// BEGIN
import java.util.HashMap;
import java.util.Map;

public class FileKV implements KeyValueStorage {
    private String filePath;

    public FileKV(String filePath, Map<String, String> initialStorage) {
        this.filePath = filePath;
        this.writeFileData(initialStorage);
    }

    private Map<String, String> getFileData() {
        var fileContent = Utils.readFile(this.filePath);
       return Utils.deserialize(fileContent);
    }

    private void writeFileData(Map<String, String> data) {
        var dataStr = Utils.serialize(data);
        Utils.writeFile(this.filePath, dataStr);
    }

    public String get(String key, String defaultValue) {
        var data = getFileData();
        return data.getOrDefault(key, defaultValue);
    }

    public void unset(String key) {
        var data = getFileData();
        data.remove(key);
        writeFileData(data);
    }

    public void set(String key, String value) {
        var data = getFileData();
        data.put(key, value);
        writeFileData(data);
    }

    public Map<String, String> toMap() {
        var data = getFileData();
        var map = new HashMap<String, String>();
        map.putAll(data);
        return map;
    }
}
// END
