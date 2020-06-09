package class05_26;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientToServer {

    private static final int PORT = 1200;
    private InputStream inputStream;

    public void start() throws IOException {
        System.out.println("포트 번호 : " + PORT + " 서버를 지금부터 구동합니다.");

        ServerSocket serverSocket = new ServerSocket(PORT);
        WaitClient2 waitClient2 = new WaitClient2(serverSocket, this);
        new Thread(waitClient2).start();
    }

    public void connected(Socket socket) throws IOException{
        inputStream = socket.getInputStream();

        ProcessMessage processMessage = new ProcessMessage(inputStream, this);
        new Thread(processMessage).start();
    }

    public void getMessage(String message){
        System.out.println("클라이언트가 서버로 부터 전송한 데이터 : " + message);
    }

    public static void main(String[] args) throws IOException {
        ClientToServer clientToServer = new ClientToServer();
        clientToServer.start();
    }
}

class WaitClient2 implements Runnable{

    ServerSocket serverSocket;
    ClientToServer clientToServer;

    public WaitClient2(ServerSocket serverSocket, ClientToServer clientToServer){
        this.serverSocket = serverSocket;
        this.clientToServer = clientToServer;
    }

    @Override
    public void run() {
        try {
            Socket socket = serverSocket.accept();
            if(clientToServer != null) clientToServer.connected(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ProcessMessage implements Runnable{

    InputStream inputStream;
    ClientToServer clientToServer;

    public ProcessMessage(InputStream inputStream, ClientToServer clientToServer){
        this.inputStream = inputStream;
        this.clientToServer = clientToServer;
    }

    @Override
    public void run() {
        byte[] buffer = new byte[1024];
        int length;
        String message;

        try{
            while(true){
                length = inputStream.read(buffer);

                if(length < 0) break;
                message = new String(buffer, 0, length);

                if(clientToServer != null) clientToServer.getMessage(message);
            }
        }catch (Exception e){ e.printStackTrace(); }
    }
}
