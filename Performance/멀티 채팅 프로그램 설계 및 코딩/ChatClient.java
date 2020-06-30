package class06_30;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

    public static final String IP = "10.80.161.125";
    public static final int PORT = 1200;
    public static final Scanner scanner = new Scanner(System.in);

    public static Socket socket;

    public static void main(String[] args) throws Exception{
        socket = new Socket(IP, PORT);
        System.out.println("서버에 정상적으로 접근하였습니다. 서버 주소 : " + IP);

        InputStream is = socket.getInputStream();
        DataInputStream dataIs = new DataInputStream(is);

        OutputStream os = socket.getOutputStream();
        DataOutputStream dataOs = new DataOutputStream(os);

        read(dataIs);
        write(dataOs);
    }

    public static void read(DataInputStream dataIs){
        Thread readThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try{
                        String msg = dataIs.readUTF();
                        System.out.println(msg);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        readThread.start();
    }

    public static void write(DataOutputStream dataOs){
        Thread writeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("ID를 입력해주세요 : ");
                String id = scanner.nextLine();

                try{ dataOs.writeUTF(id); }
                catch (IOException e){
                    e.printStackTrace();
                }

                while(true){
                    System.out.print("메세지를 입력해주세요 : ");
                    String msg = scanner.nextLine();

                    try{
                        dataOs.writeUTF(msg);
                        Thread.sleep(500);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
        writeThread.start();
    }
}
