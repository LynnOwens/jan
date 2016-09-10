package net.tofweb.jann.segment;

import java.util.concurrent.ThreadLocalRandom;

import net.tofweb.jann.Configuration;
import net.tofweb.jann.neuron.ArtificialNeuron;

public class AxonalBranchSegment extends BranchSegment {

	public AxonalBranchSegment(Segment parentSegment) {
		super(parentSegment);

		setLength(Configuration.getAxonSegmentLength());
		setRadius(Configuration.getAxonSegmentRadius());
		setMembraneCapacitance(Configuration.getAxonMembraneCapacitance());
		setMembraneResistance(Configuration.getAxonMembraneResistance());
		setIntracellularResistance(Configuration.getAxonIntracellularResistance());
		setRestingPotential(Configuration.getAxonRestingPotential());
		setSegmentSplitMaximum(Configuration.getAxonSegmentSplitMaximum());
		setSynapsesPerMicroMeterSquared(Configuration.getAxonSynapsesPerMicroMeterSquared());

		// Axons branch about 150 times and are about 1000 coords long each
		// Dendrites branch about 225 times and are about 180 coords long each
		// Soma has 1 coord
		// TODO me
	}

	public void arborize() {
		int maxRemainingAxonalChildren = this.getParentNeuron().getNumRemainingAxonalChildren();
		int remainingSegmentChildren = ThreadLocalRandom.current().nextInt(0, getSegmentSplitMaximum() + 1);
		nativeArborize(maxRemainingAxonalChildren, remainingSegmentChildren);
	}

	private void nativeArborize(Integer maxRemainingChildren, Integer remainingSegmentSplits) {
		if (maxRemainingChildren > 0) {
			while (remainingSegmentSplits > 0) {

				ArtificialNeuron parentNeuron = this.getParentNeuron();
				maxRemainingChildren = parentNeuron.getNumRemainingAxonalChildren();

				if (maxRemainingChildren > 0) {
					AxonalBranchSegment nextChild = new AxonalBranchSegment(this);
					this.addChildSegment(nextChild);
					parentNeuron.setNumRemainingAxonalChildren(--maxRemainingChildren);
					remainingSegmentSplits--;
					nextChild.arborize();
				} else {
					break;
				}
			}
		}
	}

	// private void populateSynapses() {
	// Integer synapsesRemaining = getSynapsesPerMicroMeterSquared() *
	// getSurfaceArea().getMicroMeters().intValue();
	//
	// getSynapses().clear();
	// while (synapsesRemaining > 0) {
	// addSynapse(new SynapticTerminal());
	// synapsesRemaining--;
	// }
	// }
}
