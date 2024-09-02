package exercise;

import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

// BEGIN
@Value()
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() throws Exception {
        var mapper = new ObjectMapper();

        return mapper.writeValueAsString(this);
    }

    public static Car deserialize(String json) throws Exception {
        var mapper = new ObjectMapper();
        var car = mapper.readValue(json, Car.class);

        return car;
    }
    // END
}
