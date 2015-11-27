package net.tofweb.jan.segment;

import java.math.BigDecimal;

import net.tofweb.jan.Configuration;
import net.tofweb.jan.measurement.KilohmPerCentimeterSquared;
import net.tofweb.jan.measurement.MicroFaradPerCentimeterSquared;
import net.tofweb.jan.measurement.MicroMeter;
import net.tofweb.jan.potential.Potential;

public class SomaticSegment extends Segment {

	private BigDecimal actionThresholdMilivolts = Configuration.getActionThresholdMillivolts();
	private MicroMeter length = Configuration.getSomaLength();
	private MicroMeter radius = Configuration.getSomaRadius();
	private MicroFaradPerCentimeterSquared membraneCapacitance = Configuration.getSomaMembraneCapacitance();
	private KilohmPerCentimeterSquared membraneResistance = Configuration.getSomaMembraneResistance();
	private KilohmPerCentimeterSquared intracellularResistance = Configuration.getSomaIntracellularResistance();
	private Potential restingPotential = Configuration.getSomaRestingPotential();

	@Override
	public String toString() {
		return "SomaticSegment [actionThresholdMilivolts=" + actionThresholdMilivolts + ", length=" + length
				+ ", radius=" + radius + ", membraneCapacitance=" + membraneCapacitance + ", membraneResistance="
				+ membraneResistance + ", intracellularResistance=" + intracellularResistance + ", restingPotential="
				+ restingPotential + "]";
	}

}
