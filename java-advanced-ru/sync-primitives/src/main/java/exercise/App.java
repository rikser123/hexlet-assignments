package exercise;

class App {

    public static void main(String[] args) {
        // BEGIN
        var list = new SafetyList();
        var firstThread = new ListThread(list);
        var secondThread = new ListThread(list);

        firstThread.start();
        secondThread.start();

        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            e.getMessage();
        }

        System.out.println(list.getSize())  ;
        // END
    }
}

