package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        var storageMap = storage.toMap();
        var entries = storageMap.entrySet();

        for (var entry : entries) {
            var key = entry.getKey();
            var value = entry.getValue();
            storage.unset(key);
            storage.set(value, key);
        }
    }
}
// END
