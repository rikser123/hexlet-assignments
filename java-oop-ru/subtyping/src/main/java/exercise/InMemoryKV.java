package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private Map<String, String > storage;

    public InMemoryKV(Map<String, String> initialStorage) {
        this.storage = new HashMap<String, String>();
       this.storage.putAll(initialStorage);
    }

    public String get(String key, String defaultValue) {
        return storage.getOrDefault(key, defaultValue);
    }

    public void unset(String key) {
        this.storage.remove(key);
    }

    public void set(String key, String value) {
        this.storage.put(key, value);
    }

    public Map<String, String> toMap() {
        var map = new HashMap<String, String>();
        map.putAll(storage);
        return map;
    }
}
// END
