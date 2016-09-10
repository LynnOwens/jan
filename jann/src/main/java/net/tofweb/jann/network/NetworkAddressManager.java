package net.tofweb.jann.network;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.log4j.Logger;

import com.googlecode.ipv6.IPv6Address;

import net.tofweb.jann.Configuration;
import net.tofweb.jann.measurement.MicroMeter;

public class NetworkAddressManager {
	private static final Logger log = Logger.getLogger(NetworkAddressManager.class);

	public static LinkedList<Coordinate> buildCoordinates(Coordinate last, MicroMeter length) {
		LinkedList<Coordinate> newCoordinates = new LinkedList<Coordinate>();
		for (int i = 0; i <= length.getMicroMeters().intValue(); i++) {
			Coordinate nextCoordinate = buildCoordinate(last);
			newCoordinates.add(nextCoordinate);
			last = nextCoordinate;
		}

		return newCoordinates;
	}

	private static Coordinate buildCoordinate(Coordinate last) {
		Coordinate potentialCoordinate;

		if (last.getAddress() == null) {
			potentialCoordinate = buildInitialCoordinate();
		} else {
			potentialCoordinate = buildNextCoordinate(last);
		}

		boolean isCoordinateExisting = testCoordinateExistence(potentialCoordinate);

		if (isCoordinateExisting) {
			return buildCoordinate(last);
		}

		return potentialCoordinate;
	}

	private static Coordinate buildInitialCoordinate() {
		StringBuilder addressStringBuilder = new StringBuilder();
		addressStringBuilder.append(Configuration.getUlaPrefix()); // Prefix
		addressStringBuilder.append(Configuration.getGlobalId()); // Prefix
		addressStringBuilder.append(":");
		// TODO: Determine subnet
		addressStringBuilder.append("0001"); // Subnet
		addressStringBuilder.append(":");
		// TODO: Determine how to use this block
		addressStringBuilder.append("0000"); // Unused
		addressStringBuilder.append(":");
		addressStringBuilder.append("8888"); // X
		addressStringBuilder.append(":");
		addressStringBuilder.append("8888"); // Y
		addressStringBuilder.append(":");
		addressStringBuilder.append("8888"); // Z

		IPv6Address initialAddress = IPv6Address.fromString(addressStringBuilder.toString());

		return new Coordinate(initialAddress);
	}

	private static Coordinate buildNextCoordinate(Coordinate last) {
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

		// FIXME: If we wrap then increment the next higher scale?
		// How do we handle wrap?

		return new Coordinate(last.getAddress(), x, y, z);
	}

	private static boolean testCoordinateExistence(Coordinate potentialCoordinate) {
		// TODO Auto-generated method stub
		return false;
	}

	private static Integer randomizeDirection() {
		return ThreadLocalRandom.current().nextInt(1, 7);
	}

}
