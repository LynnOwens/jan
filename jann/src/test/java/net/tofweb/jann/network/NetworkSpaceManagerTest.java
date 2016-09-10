package net.tofweb.jann.network;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.googlecode.ipv6.IPv6Address;

public class NetworkSpaceManagerTest {

	private NetworkSpaceManager nsm = new NetworkSpaceManager();

	@Test
	public void test() {
		// Low 439294508 -- the last four words converted from bin to dec
		// High 2306139569127227413 -- the first four words converted from bin to dec
		// Big Int 42540766429944781121676641069932943916 -- probably all words converted from bin to dec
		// Byte array [32, 1, 13, -72, 60, 77, 0, 21, 0, 0, 0, 0, 26, 47, 26,
		// 44]
		
		/*
		 * Byte array breaks the address into 16 two digit bytes
		 * 32, 1
		 * 13, -72
		 * 60, 77
		 * 0, 21
		 * 0, 0
		 * 0, 0
		 * 26, 47
		 * 26, 44
		 * 
		 * byte = 8-bit signed two's complement integer
		 * address is eight 16 bit words
		 * therefore a 16 bit word needs 2 bytes
		 * looks like each word is a short
		 * 
		 * The low bits turned into a byte array:
		 * [0, 0, 0, 0, 26, 47, 26, 44] -- we only care about the last 6
		 */
		IPv6Address a = IPv6Address.fromString("2001:db8:3c4d:0015:0000:0000:1a2f:1a2c");

		// Low 439294507
		// High 2306139569127227413
		// Big Int 42540766429944781121676641069932943915
		// Byte array [32, 1, 13, -72, 60, 77, 0, 21, 0, 0, 0, 0, 26, 47, 26,
		// 43]
		IPv6Address b = IPv6Address.fromString("2001:db8:3c4d:0015:0000:0000:1a2f:1a2b");
		
		// Basically, if the high bits are different then it's off
		// then 

		Long diff = nsm.calcDifferenceBetween(a, b);

		assertNotNull(diff);
	}

}
