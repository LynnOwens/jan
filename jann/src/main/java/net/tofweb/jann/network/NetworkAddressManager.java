package net.tofweb.jann.network;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import com.googlecode.ipv6.IPv6Address;

import net.tofweb.jann.Configuration;

public class NetworkAddressManager {

	private static Map<Integer, List<Integer>> usedAddressMap = new HashMap<Integer, List<Integer>>();

	/**
	 * Returns the first address on a new subnet
	 * 
	 * @return
	 */
	public static IPv6Address getNewAddress() {
		StringBuilder addressStringBuilder = new StringBuilder();
		addressStringBuilder.append(Configuration.getUlaPrefix());
		addressStringBuilder.append(Configuration.getGlobalId());
		addressStringBuilder.append(findNewSubnet());
		addressStringBuilder.append("::::1");
		String addressString = addressStringBuilder.toString();
		byte[] addressByteArray = addressString.getBytes();

		return IPv6Address.fromByteArray(addressByteArray);
	}

	private static String findNewSubnet() {
		Integer random = ThreadLocalRandom.current().nextInt(1, 65535);

		if (!usedAddressMap.keySet().contains(random)) {
			usedAddressMap.put(random, new ArrayList<Integer>());
			return Integer.toHexString(random);
		} else {
			return findNewSubnet();
		}
	}

}
