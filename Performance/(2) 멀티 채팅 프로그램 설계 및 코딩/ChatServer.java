package class06_30;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {

    public static final int PORT = 1200;
    public static int CNT = 0;
    public static ArrayList<ChatSocketThread> clientList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("서버가 정상적으로 가동되었습니다. 포트 번호 : " + PORT);

        while(true){
            Socket socket = server.accept(); CNT++;

            if(CNT > 10){
                System.out.println("동시 접속자 인원 수 (10명)을 초과하였습니다.");
                socket.close();
            }else{
                System.out.println("현재 접속 인원 : " + CNT);
                ChatSocketThread thread = new ChatSocketThread(socket);
                clientList.add(thread);
                thread.start();
            }
        }
    }
}
