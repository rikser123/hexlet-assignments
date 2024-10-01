package exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] nums) {
        var minThread = new MinThread(nums);
        var maxThread = new MaxThread(nums);

        maxThread.start();
        minThread.start();

        var threads = new ArrayList<Thread>();
        threads.add(minThread);
        threads.add(maxThread);

        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }

        var result = new HashMap<String, Integer>();
        result.put("min", minThread.getMinNumber());
        result.put("max", maxThread.getMaxNumber());
        return result;
    }
    // END
}
