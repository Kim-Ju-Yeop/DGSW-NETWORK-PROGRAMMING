package class04_28.ex4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkMain {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://blog.naver.com/kjy13299");
            System.out.println("host : " + url.getHost());
            System.out.println("protocol : " + url.getProtocol());
            System.out.println("port : " + url.getPort());
            System.out.println("file : " + url.getFile());
            System.out.println("path : " + url.getPath());

            InputStream input = url.openStream();
            InputStreamReader inReader = new InputStreamReader(input);
            BufferedReader in = new BufferedReader(inReader);

            String line = "";
            while((line = in.readLine()) != null){
                System.out.println("data : " + line);
            } in.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
