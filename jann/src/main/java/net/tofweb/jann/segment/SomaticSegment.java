package net.tofweb.jann.segment;

import java.math.BigDecimal;

import net.tofweb.jann.Configuration;
import net.tofweb.jann.measurement.KilohmPerCentimeterSquared;
import net.tofweb.jann.measurement.MicroFaradPerCentimeterSquared;
import net.tofweb.jann.measurement.MicroMeter;
import net.tofweb.jann.network.neuron.ArtificialNeuron;
import net.tofweb.jann.potential.Potential;

public class SomaticSegment extends Segment {

	private BigDecimal actionThresholdMilivolts = Configuration.getActionThresholdMillivolts();
	private MicroMeter length = Configuration.getSomaLength();
	private MicroMeter radius = Configuration.getSomaRadius();
	private MicroFaradPerCentimeterSquared membraneCapacitance = Configuration.getSomaMembraneCapacitance();
	private KilohmPerCentimeterSquared membraneResistance = Configuration.getSomaMembraneResistance();
	private KilohmPerCentimeterSquared intracellularResistance = Configuration.getSomaIntracellularResistance();
	private Potential restingPotential = Configuration.getSomaRestingPotential();

	public SomaticSegment(ArtificialNeuron parentNeuron) {
		super(parentNeuron);
	}

	@Override
	public String toString() {
		return "SomaticSegment [actionThresholdMilivolts=" + actionThresholdMilivolts + ", length=" + length
				+ ", radius=" + radius + ", membraneCapacitance=" + membraneCapacitance + ", membraneResistance="
				+ membraneResistance + ", intracellularResistance=" + intracellularResistance + ", restingPotential="
				+ restingPotential + "]";
	}

}
