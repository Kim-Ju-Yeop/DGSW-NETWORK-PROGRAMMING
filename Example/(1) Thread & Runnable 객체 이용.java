package class04_28.ex1;

public class ThreadRunnableTest {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();

        MyRunnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable);
        thread2.start();

        System.out.println("MyTest exit");
    }
}

class MyRunnable extends Object implements Runnable {

    @Override
    public void run() {
        try{
            Thread.sleep(1000);
        } catch(Exception e){
            e.printStackTrace();
        } System.out.println("MyRunnable run");
    }
}

class MyThread extends Thread{

    @Override
    public void run() {
        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } System.out.println("MyThread run");
    }
}

