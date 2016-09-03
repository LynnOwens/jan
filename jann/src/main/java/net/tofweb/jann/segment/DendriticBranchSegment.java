package net.tofweb.jann.segment;

import net.tofweb.jann.Configuration;
import net.tofweb.jann.network.neuron.ArtificialNeuron;

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
