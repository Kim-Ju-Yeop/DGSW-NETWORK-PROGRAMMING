package class05_26;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerToClient {

    private static final int PORT = 1200;
    private OutputStream outputStream;

    public void start() throws IOException{
        System.out.println("포트 번호 : " + PORT + " 서버를 지금부터 구동합니다.");

        ServerSocket serverSocket = new ServerSocket(PORT);
        WaitClient waitClient = new WaitClient(serverSocket, this);
        new Thread(waitClient).start();
    }

    public void connected(Socket socket) throws IOException{
        byte[] bytes = "hi".getBytes();

        outputStream = socket.getOutputStream();
        outputStream.write(bytes);
    }

    public static void main(String[] args) throws IOException {
        ServerToClient serverToClient = new ServerToClient();
        serverToClient.start();
    }
}

class WaitClient implements Runnable{

    ServerSocket serverSocket;
    ServerToClient serverToClient;

    public WaitClient(ServerSocket serverSocket, ServerToClient serverToClient){
        this.serverSocket = serverSocket;
        this.serverToClient = serverToClient;
    }

    @Override
    public void run() {
        try {
            Socket socket = serverSocket.accept();
            if(serverToClient != null) serverToClient.connected(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
