package net.tofweb.jann.network;

import java.nio.ByteBuffer;

import com.googlecode.ipv6.IPv6Address;

public class NetworkSpaceManager {

	public Long calcDifferenceBetween(IPv6Address a, IPv6Address b) {

		Long aLow = a.getLowBits();
		Long bLow = b.getLowBits();

		ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
	    buffer.putLong(aLow);
	    buffer.array();

		return aLow - bLow;
	}
}
