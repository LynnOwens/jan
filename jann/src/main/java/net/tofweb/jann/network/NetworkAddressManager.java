package net.tofweb.jann.network;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.log4j.Logger;

import com.googlecode.ipv6.IPv6Address;

import net.tofweb.jann.Configuration;
import net.tofweb.jann.measurement.MicroMeter;

public class NetworkAddressManager {
	private static final Logger log = Logger.getLogger(NetworkAddressManager.class);
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

	public static LinkedList<Coordinate> buildCoordinates(Coordinate last, MicroMeter length) {
		LinkedList<Coordinate> newCoordinates = new LinkedList<Coordinate>();
		for (int i = 0; i <= length.getMicroMeters().intValue(); i++) {
			newCoordinates.add(buildCoordinate(last));
		}

		return newCoordinates;
	}

	private static Coordinate buildCoordinate(Coordinate last) {
		Coordinate potentialCoordinate;

		if (last == null) {
			potentialCoordinate = buildRandomCoordinate();
		} else {
			potentialCoordinate = buildSequentialCoordinate(last);
		}

		boolean isCoordinateExisting = testCoordinateExistence(potentialCoordinate);

		if (isCoordinateExisting) {
			return buildCoordinate(last);
		}

		return potentialCoordinate;
	}

	private static Coordinate buildRandomCoordinate() {
		Integer x = ThreadLocalRandom.current().nextInt(0, 65535);
		Integer y = ThreadLocalRandom.current().nextInt(0, 65535);
		Integer z = ThreadLocalRandom.current().nextInt(0, 65535);
	}

	private static Coordinate buildSequentialCoordinate(Coordinate last) {
		Integer x = last.getX();
		Integer y = last.getY();
		Integer z = last.getZ();

		Integer randDirection = getRandomDirection();

		switch (randDirection) {
		case 1:
			x--;
			break;
		case 2:
			y--;
			break;
		case 3:
			z--;
			break;
		case 4:
			z++;
			break;
		case 5:
			y++;
			break;
		case 6:
			x++;
			break;
		default:
			log.error("Impossible situation");
		}

		return new Coordinate(last.getAddress(), x, y, z);
	}

	private static boolean testCoordinateExistence(Coordinate potentialCoordinate) {
		// TODO Auto-generated method stub
		return false;
	}

	private static Integer getRandomDirection() {
		return ThreadLocalRandom.current().nextInt(1, 7);
	}

}
