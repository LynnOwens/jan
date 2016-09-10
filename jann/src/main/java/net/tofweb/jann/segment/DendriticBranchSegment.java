package net.tofweb.jann.segment;

import net.tofweb.jann.Configuration;

public class DendriticBranchSegment extends BranchSegment {

	public DendriticBranchSegment(Segment parentSegment, Integer maxNumSegments) {
		super(parentSegment, maxNumSegments);

		setLength(Configuration.getDendriteSegmentLength());
		setRadius(Configuration.getDendriteSegmentRadius());
		setMembraneCapacitance(Configuration.getDendriteMembraneCapacitance());
		setMembraneResistance(Configuration.getDendriteMembraneResistance());
		setIntracellularResistance(Configuration.getDendriteIntracellularResistance());
		setRestingPotential(Configuration.getDendriteRestingPotential());
		setSegmentSplitMaximum(Configuration.getDendriteSegmentSplitMaximum());
		setSynapsesPerMicroMeterSquared(Configuration.getDendriteSynapsesPerMicroMeterSquared());
	}

}
