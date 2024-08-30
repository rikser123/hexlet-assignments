package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int apartmentsCount) {
        return apartments.stream().sorted((a, b) -> Double.compare(a.getArea(), b.getArea())).limit(apartmentsCount).map(item -> item.toString()).toList();
    }
}
// END
