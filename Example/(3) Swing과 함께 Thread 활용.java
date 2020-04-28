package class04_28.ex3;

import javax.swing.*;

public class PaneMain {
    public static void main(String[] args) {
        InputThread inputThread = new InputThread();
        inputThread.start();

        String input = JOptionPane.showInputDialog("input Number");
        System.out.println("input : " + input);
        System.out.println("System out");
    }
}

class InputThread extends Thread {
    @Override
    public void run() {
        for(int i = 10; i > 0; i--){
            System.out.println(i);
            try{
                Thread.sleep(1000);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
