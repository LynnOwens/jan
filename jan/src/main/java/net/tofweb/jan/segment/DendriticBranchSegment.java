package net.tofweb.jan.segment;

import java.util.concurrent.ThreadLocalRandom;

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

		populateSynapses();
	}

	@Override
	public void arborize() {
		int maxRemainingDendriticChildren = this.getParentNeuron().getNumRemainingDendriticChildren();
		int remainingSegmentChildren = ThreadLocalRandom.current().nextInt(0, getSegmentSplitMaximum() + 1);
		nativeArborize(maxRemainingDendriticChildren, remainingSegmentChildren);
	}

}
