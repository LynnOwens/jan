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
		BigDecimal twoTimesPiTimesRadiusTimesHeight = twoTimesPi.multiply(radius.getMicroMeters())
				.multiply(length.getMicroMeters());
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

}
