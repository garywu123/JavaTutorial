package inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.attribute.AclEntryPermission;

/**
 * @author ：Gary Wu
 * @date ：Created in 14:39 2020/2/23
 * @description：
 * @version: $
 */

public class IdentifyHostNameIP {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            try {
                InetAddress address = InetAddress.getByName(args[i]);
                System.out.println("Host name: " + address.getHostName() + " ");
                System.out.println("IP address: " + address.getHostAddress());

            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
    }


}
