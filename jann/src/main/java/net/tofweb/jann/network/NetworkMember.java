package net.tofweb.jann.network;

import com.googlecode.ipv6.IPv6Address;
import com.googlecode.ipv6.IPv6AddressRange;

public class NetworkMember {

	/*
	 * 1111:2222:3333:4444
	 * 
	 * 444 - synapses on one segment
	 * 
	 * xxx4:33 - segments on one arbor
	 * 
	 * xx3 - arbors on one AN
	 * 
	 * 3:222 - ANs in one subregion
	 * 
	 * 2:1 - subregions in one region
	 * 
	 * x11 - regions in one lobe
	 * 
	 * xxx1 - lobes in one brain
	 * 
	 * subnet - brains in one community
	 * 
	 * synapse, segment, arbor, AN, network, region, lobe, brain
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
