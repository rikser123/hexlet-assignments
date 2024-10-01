package exercise;

import java.util.ArrayList;
import java.util.List;

class SafetyList {
    // BEGIN
    private List<Integer> list = new ArrayList<>();

    public SafetyList() {}

    public synchronized boolean add(int number) {
        list.add(number);
        return true;
    }

    public Integer get(int index) {
        return list.get(index);
    }

    public Integer getSize() {
        return list.size();
    }
    // END
}
