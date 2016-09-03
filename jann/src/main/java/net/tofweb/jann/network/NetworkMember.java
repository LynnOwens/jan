package net.tofweb.jann.network;

import com.googlecode.ipv6.IPv6Address;
import com.googlecode.ipv6.IPv6AddressRange;

public class NetworkMember {

	/*
	 * 1111:2222:3333:4444
	 * 
	 * sum(2222) = x sum(3333) = y sum(4444) = z
	 * 
	 * 1 um = 1 point 2 synapses that are <=1 pt away from each other can talk
	 */

	private IPv6AddressRange range;
	private IPv6Address address;

	public NetworkMember() {
		super();
	}

	public NetworkMember(IPv6AddressRange range, IPv6Address address) {
		super();
		this.range = range;
		this.address = address;
	}

	public IPv6AddressRange getRange() {
		return range;
	}

	public void setRange(IPv6AddressRange range) {
		this.range = range;
	}

	public IPv6Address getAddress() {
		return address;
	}

	public void setAddress(IPv6Address address) {
		this.address = address;
	}

}
