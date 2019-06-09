import org.junit.Test;

public class testSingleton {
    class TestThread extends Thread {
        private String threadName;

        TestThread(int i) {
            threadName = String.valueOf(i);
        }

        @Override
        public void run() {
//            Singleton.getInstance().a++;
//            System.out.println(threadName + ":" + Singleton.getInstance().a);
            System.out.println(threadName + ":" + Singleton.getInstance().hashCode());
        }
    }

    @Test
    public void test() {

        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new TestThread(i);
            threads[i].start();
        }

    }

}
