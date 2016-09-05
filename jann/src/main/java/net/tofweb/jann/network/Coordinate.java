package net.tofweb.jann.network;

import org.apache.commons.lang3.StringUtils;

import com.googlecode.ipv6.IPv6Address;

public class Coordinate {

	private IPv6Address address;
	private Integer x;
	private Integer y;
	private Integer z;

	public Coordinate() {
		super();
	}

	public Coordinate(IPv6Address address) {
		super();
		this.address = address;
		calcCoords(address);
	}

	public Coordinate(IPv6Address addressTemplate, Integer x, Integer y, Integer z) {
		super();

		this.address = calcAddress(addressTemplate, x, y, z);
		this.x = x;
		this.y = y;
		this.z = z;
	}

	// Preserves subnet and unused hextet
	private IPv6Address calcAddress(IPv6Address addressTemplate, Integer x2, Integer y2, Integer z2) {
		String templateAddress = addressTemplate.toLongString();
		String sixthHextet = StringUtils.leftPad(Integer.toHexString(x), 4, "0");
		String seventhHextet = StringUtils.leftPad(Integer.toHexString(y), 4, "0");
		String eighthHextet = StringUtils.leftPad(Integer.toHexString(z), 4, "0");

		StringBuilder newAddress = new StringBuilder(
				templateAddress.substring(0, StringUtils.ordinalIndexOf(templateAddress, ":", 5)));

		newAddress.append(":");
		newAddress.append(sixthHextet);
		newAddress.append(":");
		newAddress.append(seventhHextet);
		newAddress.append(":");
		newAddress.append(eighthHextet);

		byte[] addressByteArray = newAddress.toString().getBytes();
		return IPv6Address.fromByteArray(addressByteArray);
	}

	private void calcCoords(IPv6Address address) {
		String textualRepresentation = address.toLongString();

		String sixthHextet = textualRepresentation.substring(
				StringUtils.ordinalIndexOf(textualRepresentation, ":", 5) + 1,
				StringUtils.ordinalIndexOf(textualRepresentation, ":", 6));
		String seventhHextet = textualRepresentation.substring(
				StringUtils.ordinalIndexOf(textualRepresentation, ":", 6) + 1,
				StringUtils.ordinalIndexOf(textualRepresentation, ":", 7));
		String eighthHextet = textualRepresentation
				.substring(StringUtils.ordinalIndexOf(textualRepresentation, ":", 7) + 1);

		x = Integer.parseInt(sixthHextet, 16);
		y = Integer.parseInt(seventhHextet, 16);
		z = Integer.parseInt(eighthHextet, 16);
	}

	public IPv6Address getAddress() {
		return address;
	}

	public void setAddress(IPv6Address address) {
		this.address = address;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Integer getZ() {
		return z;
	}

	public void setZ(Integer z) {
		this.z = z;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Coordinate [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

}
