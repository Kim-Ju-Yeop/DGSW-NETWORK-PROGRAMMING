package class05_12.ex2;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SocketChannel;

public class InetTest {
    public static void main(String[] args) {
        try{
            InetAddress address = InetAddress.getLocalHost();
            InetAddress address2 = InetAddress.getByName("google.com");

            println("Address : " + address);
            println("Host Address : " + address.getHostAddress());
            println("Host Name : " + address.getHostName());

            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress(address2, 80));

            while(!socketChannel.finishConnect()){

            }
            println("connect success");

            String sendData = "GET / HTTP/1.1\n";
			ByteBuffer sendBuff = ByteBuffer.allocate(1024);

			sendBuff.put(sendData.getBytes());
			sendData = "Host: google.com\n";
			sendBuff.put(sendData.getBytes());
			sendData = "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.101 Safari/537.36\n";
			sendBuff.put(sendData.getBytes());

			socketChannel.write(sendBuff);
			sendBuff.clear();

            URL url = new URL("http://google.com");
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            ReadableByteChannel readableByteChannel = Channels.newChannel(inputStream);

            ByteBuffer buffer = ByteBuffer.allocate(1280);
            System.out.println("buffer : "+buffer);
            int readSize = readableByteChannel.read(buffer);
            System.out.println("read data : "+readSize);
            if(readSize >0 ) {
                String str = new String(buffer.array());
                System.out.println(str);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void println(String data){
        System.out.println(data);
    }
}
