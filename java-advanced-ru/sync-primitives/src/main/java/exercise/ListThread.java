package exercise;

// BEGIN
public class ListThread extends Thread {
    private SafetyList list;

    public ListThread(SafetyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (var i = 0; i < 1000; i += 1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.getMessage();
            }
            list.add(i);
        }
    }
}
// END
