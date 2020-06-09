package class06_02;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class NIC_Exam {

    public static void main(String[] args) {
        NIC_Exam exam = new NIC_Exam();
        exam.printNetworkInfo();
    }

    public void printNetworkInfo() {
        try {
            NetworkInterface nic = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
            showNIC(nic);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showNIC(NetworkInterface nic) {
        System.out.println();
        System.out.println(nic.getDisplayName());
        System.out.println(nic.getName());

        Enumeration<InetAddress> iNets = nic.getInetAddresses();
        ArrayList<InetAddress> list = Collections.list(iNets);

        for(InetAddress item : list) {
            System.out.println(item);
        }

        try {
            byte[] macs = nic.getHardwareAddress();
            for (byte item : macs) {
                System.out.println(item);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
