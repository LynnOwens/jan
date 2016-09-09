package net.tofweb.jann.segment;

import java.math.BigDecimal;
import java.util.LinkedList;

import org.apache.commons.collections4.CollectionUtils;

import net.tofweb.jann.measurement.KilohmPerCentimeterSquared;
import net.tofweb.jann.measurement.MicroFaradPerCentimeterSquared;
import net.tofweb.jann.measurement.MicroMeter;
import net.tofweb.jann.measurement.MicroMeterSquared;
import net.tofweb.jann.network.Coordinate;
import net.tofweb.jann.network.NetworkAddressManager;
import net.tofweb.jann.network.NetworkMember;
import net.tofweb.jann.neuron.ArtificialNeuron;
import net.tofweb.jann.potential.Potential;

public abstract class Segment extends NetworkMember {

	private MicroMeter length = new MicroMeter(0);
	private MicroMeter radius = new MicroMeter(0);
	private MicroFaradPerCentimeterSquared membraneCapacitance = new MicroFaradPerCentimeterSquared(0);
	private KilohmPerCentimeterSquared membraneResistance = new KilohmPerCentimeterSquared(0);
	private KilohmPerCentimeterSquared intracellularResistance = new KilohmPerCentimeterSquared(0);
	private Potential restingPotential;
	private ArtificialNeuron parentNeuron;
	private BigDecimal pi = new BigDecimal("3.14159265359");
	private BigDecimal two = new BigDecimal("2");
	private Segment parentSegment;
	private LinkedList<Coordinate> coordinates = new LinkedList<Coordinate>();

	public Segment(ArtificialNeuron parentNeuron) {
		super();
		this.parentNeuron = parentNeuron;
	}

	public Segment(Segment parentSegment) {
		super();
		this.parentSegment = parentSegment;
		populateCoordinates(parentSegment);
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

	public void populateCoordinates(Segment parentSegment) {
		LinkedList<Coordinate> parentCoordinates = parentSegment.getCoordinates();
		LinkedList<Coordinate> coordinates = new LinkedList<Coordinate>();

		if (CollectionUtils.isEmpty(parentCoordinates)) {
			coordinates = NetworkAddressManager.buildCoordinates(new Coordinate(), getLength());
		} else {
			coordinates = NetworkAddressManager.buildCoordinates(parentSegment.getCoordinates().getLast(), getLength());
		}

		setCoordinates(coordinates);
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
		if (parentNeuron == null && parentSegment != null) {
			return parentSegment.getParentNeuron();
		} else {
			return parentNeuron;
		}
	}

	public void setParentNeuron(ArtificialNeuron parentNeuron) {
		this.parentNeuron = parentNeuron;
	}

	public LinkedList<Coordinate> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(LinkedList<Coordinate> coordinates) {
		this.coordinates = coordinates;
	}

	public void addCoordinate(Coordinate coordinate) {
		this.coordinates.add(coordinate);
	}

	public Segment getParentSegment() {
		return parentSegment;
	}

	public void setParentSegment(Segment parentSegment) {
		this.parentSegment = parentSegment;
	}
}
