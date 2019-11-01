package lockTest;

import java.util.concurrent.CountDownLatch;

public class MyRunnable implements Runnable {

    private final CountDownLatch countDown;
    private final CountDownLatch await;

    public MyRunnable(CountDownLatch countDown, CountDownLatch await) {
        this.countDown = countDown;
        this.await = await;
    }

    public void run() {
        try {
            countDown.await();//等待主线程执行完毕，获得开始执行信号...
            System.out.println("处于等待的线程开始自己预期工作......");
            await.countDown();//完成预期工作，发出完成信号...
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}