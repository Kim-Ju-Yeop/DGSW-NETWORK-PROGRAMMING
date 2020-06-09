package class06_09;

import java.net.URI;
import java.net.URL;

public class URITest {
    public static void main(String[] args) throws Exception{
        URI uri = new URI("https://" +
                "search.naver.com:80" +
                "/search.naver?" +
                "sm=tab_hty.top&where=nexearch&query=대구소프트웨어고등학교&oquery=대구소프트웨어고등학교&tqi=UWJPmwp0YiRssLkwytCssssssnl-512361");
        showURIInfo(uri);

        System.out.println();

        URL url = new URL("https://" +
                "search.naver.com:80" +
                "/search.naver?" +
                "sm=tab_hty.top&where=nexearch&query=대구소프트웨어고등학교&oquery=대구소프트웨어고등학교&tqi=UWJA%2Bsp0J1Zss6uqBtRssssssCC-065341");
        showURLINfo(url);
    }

    public static void showURIInfo(URI uri){
        System.out.println("URI info");
        System.out.println("uri scheme : " + uri.getScheme());
        System.out.println("uri host : " + uri.getHost());
        System.out.println("uri path : " + uri.getPath());
        System.out.println("uri fragment : " + uri.getFragment());
        System.out.println("uri port : " + uri.getPort());
        System.out.println("uri query : " + uri.getQuery());
        System.out.println("uri auth : " + uri.getAuthority());
        System.out.println("uri userInfo : " + uri.getUserInfo() );
    }

    public static void showURLINfo(URL url){
        System.out.println("URL info");
        System.out.println("url scheme : " + url.getProtocol());
        System.out.println("url host : " + url.getHost());
        System.out.println("url path : " + url.getPath());
        System.out.println("url port : " + url.getPort());
        System.out.println("url query : " + url.getQuery());
        System.out.println("url auth : " + url.getAuthority());
        System.out.println("url userInfo : " + url.getUserInfo() );
    }
}
