package class06_09;

import java.io.IOException;
import java.net.InetAddress;

public class IPChecker {
    public static void main(String[] args) throws Exception{
        InetAddress inet = InetAddress.getByName("localhost");
        checkIP(inet);
    }

    public static void checkIP(InetAddress inet) throws IOException {
        System.out.println(inet);
        System.out.println("isReachable : " + inet.isReachable(1000));
        System.out.println("isAnyLocalAddress : " + inet.isAnyLocalAddress());
        System.out.println("isLoopbackAddress : " + inet.isLoopbackAddress());
        System.out.println("isLinkLOcalAddress : " + inet.isLinkLocalAddress());
        System.out.println("isSiteLocalAddress : " + inet.isSiteLocalAddress());
        System.out.println("isMulticastAddress : " + inet.isMulticastAddress());
        System.out.println("isMCGlobal : " + inet.isMCGlobal());
        System.out.println("isMCLinkLocal : " + inet.isMCLinkLocal());
        System.out.println("isMCNodeLocal : " + inet.isMCNodeLocal());
        System.out.println("isMCOrgLocal : " + inet.isMCOrgLocal());
    }
}
