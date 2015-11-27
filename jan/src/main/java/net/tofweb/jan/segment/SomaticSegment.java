package net.tofweb.jan.segment;

import java.math.BigDecimal;

import net.tofweb.jan.Configuration;
import net.tofweb.jan.measurement.KilohmPerCentimeterSquared;
import net.tofweb.jan.measurement.MicroFaradPerCentimeterSquared;
import net.tofweb.jan.measurement.MicroMeter;
import net.tofweb.jan.potential.Potential;

public class SomaticSegment extends Segment {

	private BigDecimal actionThresholdMilivolts = Configuration.actionThresholdMillivolts;
	private MicroMeter length = Configuration.somaLength;
	private MicroMeter radius = Configuration.somaRadius;
	private MicroFaradPerCentimeterSquared membraneCapacitance = Configuration.somaMembraneCapacaitance;
	private KilohmPerCentimeterSquared membraneResistance = Configuration.somaMembraneResistance;
	private KilohmPerCentimeterSquared intracellularResistance = Configuration.somaIntracellularResistance;
	private Potential restingPotential = Configuration.somaRestingPotential;

}
