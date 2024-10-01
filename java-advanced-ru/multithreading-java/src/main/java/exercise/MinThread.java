package exercise;

// BEGIN
public class MinThread extends Thread {
    private int[] numbers;
    private int minNumber;

    public MinThread(int[] numbers) {
        super();
        this.numbers = numbers;
    }

    public int getMinNumber() {
        return minNumber;
    }

    @Override
    public void run() {
        for (var num : numbers) {
            if (num < minNumber) {
                minNumber = num;
            }
        }
    }
}
// END
