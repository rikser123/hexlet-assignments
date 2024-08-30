package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
// BEGIN
import static org.assertj.core.api.Assertions.assertThat;
// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // BEGIN
    @Test()
    public void testFileKv() {
        var map = new HashMap<String, String>();
        map.put("sys", "burna");

        var fileKvStorage = new FileKV(FileKVTest.filepath.toString(), map);
        assertThat(fileKvStorage.get("sys", "")).isEqualTo("burna");

        fileKvStorage.set("sys2", "burna2");
        assertThat(fileKvStorage.get("sys2", "")).isEqualTo("burna2");

        fileKvStorage.unset("sys2");
        assertThat(fileKvStorage.get("sys2", "burna2")).isEqualTo("burna2");

    }
    // END
}
