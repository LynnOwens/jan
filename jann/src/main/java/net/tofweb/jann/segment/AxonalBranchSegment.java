package net.tofweb.jann.segment;

import java.util.concurrent.ThreadLocalRandom;

import net.tofweb.jann.Configuration;

public class AxonalBranchSegment extends BranchSegment {

	public AxonalBranchSegment(Segment parentSegment, Integer maxNumSegments) {
		super(parentSegment, maxNumSegments);

		setLength(Configuration.getAxonSegmentLength());
		setRadius(Configuration.getAxonSegmentRadius());
		setMembraneCapacitance(Configuration.getAxonMembraneCapacitance());
		setMembraneResistance(Configuration.getAxonMembraneResistance());
		setIntracellularResistance(Configuration.getAxonIntracellularResistance());
		setRestingPotential(Configuration.getAxonRestingPotential());
		setSegmentSplitMaximum(Configuration.getAxonSegmentSplitMaximum());
		setSynapsesPerMicroMeterSquared(Configuration.getAxonSynapsesPerMicroMeterSquared());
	}

	public void arborize() {
		Integer myChildSegments = getMaxNumSegments() - 1;

		// TODO move me to configuration: 150 / 1000
		Integer chanceOfBranching = 8;

		if (myChildSegments > 0) {
			Integer chanceOfBranchingRoll = ThreadLocalRandom.current().nextInt(0, 101);
			if (chanceOfBranchingRoll < chanceOfBranching) {
				Integer branchSegments = myChildSegments / 2;
				myChildSegments = myChildSegments - branchSegments;
				AxonalBranchSegment branch = new AxonalBranchSegment(this, branchSegments);
				this.addChildSegment(branch);
				branch.arborize();
			}

			AxonalBranchSegment branch = new AxonalBranchSegment(this, myChildSegments);
			this.addChildSegment(branch);
			branch.arborize();
		}
	}

}
