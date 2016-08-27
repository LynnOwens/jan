package net.tofweb.jan.segment;

import net.tofweb.jan.Configuration;
import net.tofweb.jan.neuron.ArtificialNeuron;

public class DendriticBranchSegment extends BranchSegment {

	public DendriticBranchSegment(ArtificialNeuron parentNeuron, Segment parentSegment) {
		super(parentNeuron, parentSegment);

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
