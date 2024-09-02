package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path path, Car car) {
        var absolutePath = path.toAbsolutePath().normalize();

        try {
            var carJson = car.serialize();
            Files.write(absolutePath, carJson.getBytes());
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static Car extract(Path path) {
        var absolutePath = path.toAbsolutePath().normalize();
        Car car = null;

        try {
            var content = Files.readString(absolutePath);
            car = Car.deserialize(content);
        } catch (Exception e) {
        e.getStackTrace();
      }

        return car;
    }
}
// END
