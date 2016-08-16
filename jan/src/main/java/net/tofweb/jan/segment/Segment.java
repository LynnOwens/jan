package net.tofweb.jan.segment;

import java.math.BigDecimal;

import net.tofweb.jan.measurement.KilohmPerCentimeterSquared;
import net.tofweb.jan.measurement.MicroFaradPerCentimeterSquared;
import net.tofweb.jan.measurement.MicroMeter;
import net.tofweb.jan.measurement.MicroMeterSquared;
import net.tofweb.jan.neuron.ArtificialNeuron;
import net.tofweb.jan.potential.Potential;

public abstract class Segment {

	private MicroMeter length;
	private MicroMeter radius;
	private MicroFaradPerCentimeterSquared membraneCapacitance;
	private KilohmPerCentimeterSquared membraneResistance;
	private KilohmPerCentimeterSquared intracellularResistance;
	private Potential restingPotential;
	private ArtificialNeuron parentNeuron;
	private BigDecimal pi = new BigDecimal("3.14159265359");
	private BigDecimal two = new BigDecimal("2");

	public Segment(ArtificialNeuron parentNeuron) {
		super();
		this.parentNeuron = parentNeuron;
	}

	public MicroMeterSquared getSurfaceArea() {
		MicroMeterSquared radiusSquared = getRadius().square();
		BigDecimal twoTimesPi = two.multiply(pi);
		BigDecimal twoTimesPiTimesRadiusTimesHeight = twoTimesPi.multiply(radius.getMicroMeters()).multiply(length.getMicroMeters());
		BigDecimal twoTimesPiTimesRadiusSquared = twoTimesPi.multiply(radiusSquared.getMicroMeters());
		BigDecimal surfaceArea = twoTimesPiTimesRadiusTimesHeight.add(twoTimesPiTimesRadiusSquared);
		return new MicroMeterSquared(surfaceArea);
	}

	public MicroMeter getLength() {
		return length;
	}

	public void setLength(MicroMeter length) {
		this.length = length;
	}

	public MicroMeter getRadius() {
		return radius;
	}

	public void setRadius(MicroMeter radius) {
		this.radius = radius;
	}

	public MicroFaradPerCentimeterSquared getMembraneCapacitance() {
		return membraneCapacitance;
	}

	public void setMembraneCapacitance(MicroFaradPerCentimeterSquared membraneCapacitance) {
		this.membraneCapacitance = membraneCapacitance;
	}

	public KilohmPerCentimeterSquared getMembraneResistance() {
		return membraneResistance;
	}

	public void setMembraneResistance(KilohmPerCentimeterSquared membraneResistance) {
		this.membraneResistance = membraneResistance;
	}

	public KilohmPerCentimeterSquared getIntracellularResistance() {
		return intracellularResistance;
	}

	public void setIntracellularResistance(KilohmPerCentimeterSquared intracellularResistance) {
		this.intracellularResistance = intracellularResistance;
	}

	public Potential getRestingPotential() {
		return restingPotential;
	}

	public void setRestingPotential(Potential restingPotential) {
		this.restingPotential = restingPotential;
	}

	public ArtificialNeuron getParentNeuron() {
		return parentNeuron;
	}

	public void setParentNeuron(ArtificialNeuron parentNeuron) {
		this.parentNeuron = parentNeuron;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((intracellularResistance == null) ? 0 : intracellularResistance.hashCode());
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		result = prime * result + ((membraneCapacitance == null) ? 0 : membraneCapacitance.hashCode());
		result = prime * result + ((membraneResistance == null) ? 0 : membraneResistance.hashCode());
		result = prime * result + ((parentNeuron == null) ? 0 : parentNeuron.hashCode());
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
		if (parentNeuron == null) {
			if (other.parentNeuron != null)
				return false;
		} else if (!parentNeuron.equals(other.parentNeuron))
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
