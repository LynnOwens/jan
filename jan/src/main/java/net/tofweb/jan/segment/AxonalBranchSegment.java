package net.tofweb.jan.segment;

import java.util.concurrent.ThreadLocalRandom;

import net.tofweb.jan.Configuration;
import net.tofweb.jan.neuron.ArtificialNeuron;

public class AxonalBranchSegment extends BranchSegment {

	public AxonalBranchSegment(ArtificialNeuron parentNeuron, Segment parentSegment) {
		super(parentNeuron, parentSegment);

		setLength(Configuration.getAxonSegmentLength());
		setRadius(Configuration.getAxonSegmentRadius());
		setMembraneCapacitance(Configuration.getAxonMembraneCapacitance());
		setMembraneResistance(Configuration.getAxonMembraneResistance());
		setIntracellularResistance(Configuration.getAxonIntracellularResistance());
		setRestingPotential(Configuration.getAxonRestingPotential());
		setSegmentSplitMaximum(Configuration.getAxonSegmentSplitMaximum());
		setSynapsesPerMicroMeterSquared(Configuration.getAxonSynapsesPerMicroMeterSquared());
	}

	@Override
	public void arborize() {
		int maxRemainingAxonalChildren = this.getParentNeuron().getNumRemainingAxonalChildren();
		int remainingSegmentChildren = ThreadLocalRandom.current().nextInt(0, getSegmentSplitMaximum() + 1);
		nativeArborize(maxRemainingAxonalChildren, remainingSegmentChildren);
	}

}
