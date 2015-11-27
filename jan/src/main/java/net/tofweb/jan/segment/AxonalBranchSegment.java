package net.tofweb.jan.segment;

import net.tofweb.jan.Configuration;
import net.tofweb.jan.measurement.KilohmPerCentimeterSquared;
import net.tofweb.jan.measurement.MicroFaradPerCentimeterSquared;
import net.tofweb.jan.measurement.MicroMeter;
import net.tofweb.jan.potential.Potential;

public class AxonalBranchSegment {

	private MicroMeter length = Configuration.getAxonSegmentLength();
	private MicroMeter radius = Configuration.getAxonSegmentRadius();
	private MicroFaradPerCentimeterSquared membraneCapacitance = Configuration.getAxonMembraneCapacitance();
	private KilohmPerCentimeterSquared membraneResistance = Configuration.getAxonMembraneResistance();
	private KilohmPerCentimeterSquared intracellularResistance = Configuration.getAxonIntracellularResistance();
	private Potential restingPotential = Configuration.getAxonRestingPotential();

}
