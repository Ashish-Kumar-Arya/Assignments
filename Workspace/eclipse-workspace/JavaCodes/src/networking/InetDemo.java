package networking;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetDemo {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress addr=InetAddress.getLocalHost();
		System.out.println(addr);
		addr=InetAddress.getByName("www.simplilearn.com");
		System.out.println();
	}
}
