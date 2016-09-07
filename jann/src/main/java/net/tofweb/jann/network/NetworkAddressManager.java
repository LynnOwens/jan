package net.tofweb.jann.network;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.googlecode.ipv6.IPv6Address;

import net.tofweb.jann.Configuration;
import net.tofweb.jann.measurement.MicroMeter;

public class NetworkAddressManager {
	private static final Logger log = Logger.getLogger(NetworkAddressManager.class);

	public static LinkedList<Coordinate> buildCoordinates(Coordinate last, MicroMeter length) {
		LinkedList<Coordinate> newCoordinates = new LinkedList<Coordinate>();
		for (int i = 0; i <= length.getMicroMeters().intValue(); i++) {
			newCoordinates.add(buildCoordinate(last));
		}

		return newCoordinates;
	}

	private static Coordinate buildCoordinate(Coordinate last) {
		Coordinate potentialCoordinate;

		if (last.getAddress() == null) {
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
		StringBuilder addressStringBuilder = new StringBuilder();
		addressStringBuilder.append(Configuration.getUlaPrefix()); // Prefix
		addressStringBuilder.append(Configuration.getGlobalId()); // Prefix
		addressStringBuilder.append(":");
		addressStringBuilder.append(buildRandomHextet()); // Subnet
		addressStringBuilder.append(":");
		addressStringBuilder.append(buildRandomHextet()); // Unused
		addressStringBuilder.append(":");
		addressStringBuilder.append(buildRandomHextet()); // X
		addressStringBuilder.append(":");
		addressStringBuilder.append(buildRandomHextet()); // Y
		addressStringBuilder.append(":");
		addressStringBuilder.append(buildRandomHextet()); // Z

		Integer x = ThreadLocalRandom.current().nextInt(0, 65535);
		Integer y = ThreadLocalRandom.current().nextInt(0, 65535);
		Integer z = ThreadLocalRandom.current().nextInt(0, 65535);

		IPv6Address randomAddress = IPv6Address.fromString(addressStringBuilder.toString());

		return new Coordinate(randomAddress, x, y, z);
	}

	private static Coordinate buildSequentialCoordinate(Coordinate last) {
		Integer x = last.getX();
		Integer y = last.getY();
		Integer z = last.getZ();

		Integer randDirection = randomizeDirection();

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

	private static String buildRandomHextet() {
		Integer randomInt = ThreadLocalRandom.current().nextInt(0, 65535);
		return StringUtils.leftPad(Integer.toHexString(randomInt), 4, "0");
	}

	private static Integer randomizeDirection() {
		return ThreadLocalRandom.current().nextInt(1, 7);
	}

}
