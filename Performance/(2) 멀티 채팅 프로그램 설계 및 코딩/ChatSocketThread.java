package class06_30;

import java.io.*;
import java.net.Socket;

public class ChatSocketThread extends Thread{

    Socket socket;
    String id;
    DataOutputStream dataOs;

    public ChatSocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        String temp;

        try{
            InputStream is = socket.getInputStream();
            DataInputStream dataIs = new DataInputStream(is);

            OutputStream os = socket.getOutputStream();
            dataOs = new DataOutputStream(os);

            id = dataIs.readUTF();
            System.out.println("접속한 클라이언트의 ID : " + id);

            while(true){
                try{
                    temp = dataIs.readUTF();

                    for(ChatSocketThread thread : ChatServer.clientList){
                        String msg = id + " : " + temp;
                        System.out.println(msg);
                        thread.dataOs.writeUTF(msg);
                    }
                }catch (EOFException e){
                   socket.close();
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
