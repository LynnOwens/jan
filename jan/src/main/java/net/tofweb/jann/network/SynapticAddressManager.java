package net.tofweb.jann.network;

import java.net.Inet6Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.log4j.Logger;

import net.tofweb.jann.Configuration;
import net.tofweb.jann.Main;

public class SynapticAddressManager {

	private static final Logger log = Logger.getLogger(Main.class);
	private static Map<Integer, List<Integer>> usedAddressMap = new HashMap<Integer, List<Integer>>();

	/**
	 * Returns the first address on a new subnet
	 * 
	 * @return
	 */
	public static Inet6Address getNewAddress() {
		StringBuilder addressStringBuilder = new StringBuilder();
		addressStringBuilder.append(Configuration.getUlaPrefix());
		addressStringBuilder.append(Configuration.getGlobalId());
		addressStringBuilder.append(findNewSubnet());
		addressStringBuilder.append("::::1");
		String addressString = addressStringBuilder.toString();
		byte[] addressByteArray = addressString.getBytes();

		Inet6Address address = null;
		try {
			address = Inet6Address.getByAddress(addressString, addressByteArray, 12);
		} catch (UnknownHostException e) {
			log.error(e.getMessage(), e);
		}

		return address;
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
