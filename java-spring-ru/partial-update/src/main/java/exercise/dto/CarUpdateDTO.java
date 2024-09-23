package exercise.dto;

import jdk.security.jarsigner.JarSigner;
import org.openapitools.jackson.nullable.JsonNullable;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

// BEGIN
@Getter
@Setter
public class CarUpdateDTO {
    @NotNull
    private JsonNullable<String> model;
    @NotNull
    private JsonNullable<String> manufacturer;
    @NotNull
    private JsonNullable<Integer> enginePower;
}
// END
