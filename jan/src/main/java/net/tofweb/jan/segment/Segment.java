package net.tofweb.jan.segment;

import java.math.BigDecimal;

import net.tofweb.jan.potential.Potential;

public abstract class Segment {

	private BigDecimal length;
	private BigDecimal radius;
	private BigDecimal membraneCapacitance;
	private BigDecimal membraneResistance;
	private BigDecimal intracellularResistance;
	private Potential restingPotential;
	
	public BigDecimal getLength() {
		return length;
	}
	
	public BigDecimal getRadius() {
		return radius;
	}
	
	public BigDecimal getMembraneCapacitance() {
		return membraneCapacitance;
	}
	
	public BigDecimal getMembraneResistance() {
		return membraneResistance;
	}
	
	public BigDecimal getIntracellularResistance() {
		return intracellularResistance;
	}
	
	public Potential getRestingPotential() {
		return restingPotential;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((intracellularResistance == null) ? 0 : intracellularResistance.hashCode());
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		result = prime * result + ((membraneCapacitance == null) ? 0 : membraneCapacitance.hashCode());
		result = prime * result + ((membraneResistance == null) ? 0 : membraneResistance.hashCode());
		result = prime * result + ((radius == null) ? 0 : radius.hashCode());
		result = prime * result + ((restingPotential == null) ? 0 : restingPotential.hashCode());
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
		Segment other = (Segment) obj;
		if (intracellularResistance == null) {
			if (other.intracellularResistance != null)
				return false;
		} else if (!intracellularResistance.equals(other.intracellularResistance))
			return false;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.length))
			return false;
		if (membraneCapacitance == null) {
			if (other.membraneCapacitance != null)
				return false;
		} else if (!membraneCapacitance.equals(other.membraneCapacitance))
			return false;
		if (membraneResistance == null) {
			if (other.membraneResistance != null)
				return false;
		} else if (!membraneResistance.equals(other.membraneResistance))
			return false;
		if (radius == null) {
			if (other.radius != null)
				return false;
		} else if (!radius.equals(other.radius))
			return false;
		if (restingPotential == null) {
			if (other.restingPotential != null)
				return false;
		} else if (!restingPotential.equals(other.restingPotential))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Segment [length=" + length + ", radius=" + radius + ", membraneCapacitance=" + membraneCapacitance
				+ ", membraneResistance=" + membraneResistance + ", intracellularResistance=" + intracellularResistance
				+ ", restingPotential=" + restingPotential + "]";
	}
	
}
