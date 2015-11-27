package net.tofweb.jan.segment;

import net.tofweb.jan.Configuration;
import net.tofweb.jan.measurement.KilohmPerCentimeterSquared;
import net.tofweb.jan.measurement.MicroFaradPerCentimeterSquared;
import net.tofweb.jan.measurement.MicroMeter;
import net.tofweb.jan.potential.Potential;

public class DendriticBranchSegment extends BranchSegment {

	private MicroMeter length = Configuration.getDendriteSegmentLength();
	private MicroMeter radius = Configuration.getDendriteSegmentRadius();
	private MicroFaradPerCentimeterSquared membraneCapacitance = Configuration.getDendriteMembraneCapacitance();
	private KilohmPerCentimeterSquared membraneResistance = Configuration.getDendriteMembraneResistance();
	private KilohmPerCentimeterSquared intracellularResistance = Configuration.getDendriteIntracellularResistance();
	private Potential restingPotential = Configuration.getDendriteRestingPotential();

}
