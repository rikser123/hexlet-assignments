package exercise;

// BEGIN
public class MaxThread extends Thread {
    private int[] nums;
    private int maxNumber;

    public MaxThread(int[] nums) {
        super();
        this.nums = nums;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public void run() {
        for (var num : nums) {
            if (maxNumber < num) {
                System.out.println(num);
                maxNumber = num;
            }
        }
    }
}
// END
