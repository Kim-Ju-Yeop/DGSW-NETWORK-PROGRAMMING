package class04_28.ex2;

public class RepeatThreadTest {
    public static void main(String[] args) {
        RepeatThread repeatThread = new RepeatThread();
        RepeatThread2 repeatThread2 = new RepeatThread2();

        // setPriority 속성을 통해 각 쓰레드의 우선 순위를 스케줄링할 수 있다.
        repeatThread.setPriority(10);
        repeatThread2.setPriority(1);

        // setDaemon 속성은 메인 쓰레드가 종료된다면 함께 종료되도록 설정한다.
        repeatThread.setDaemon(true);
        repeatThread2.setDaemon(true);

        // start 속성은 비동기식 처리를 가동하게한다. (아래의 코드들이 함께 동시에 진행된다.)
        // run 속성은 동기식 처리를 가동하게한다. (아래의 코드들이 절차적으로 순차적으로 진행된다.)
        repeatThread.start();
        repeatThread2.start();

        System.out.println("RepeatTest exit");
    }
}

class RepeatThread extends Thread {

    @Override
    public void run() {
        for(int i = 0; i < 300; i++){
            System.out.print("- ");
        }
    }
}

class RepeatThread2 extends Thread {

    @Override
    public void run() {
        for(int i = 0; i < 300; i++){
            System.out.print("| ");
        }
    }
}

