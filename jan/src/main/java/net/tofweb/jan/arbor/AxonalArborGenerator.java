package net.tofweb.jan.arbor;

import java.util.concurrent.ThreadLocalRandom;

import net.tofweb.jan.Configuration;
import net.tofweb.jan.neuron.ArtificialNeuron;
import net.tofweb.jan.segment.AxonalBranchSegment;

public class AxonalArborGenerator implements Runnable {

	private AxonalBranchSegment parentSegment;

	public AxonalArborGenerator(AxonalBranchSegment parentSegment) {
		super();
		this.parentSegment = parentSegment;
	}

	public void run() {
		// Determine a semi-random number of possible children
		Integer numChildrenPossible = ThreadLocalRandom.current().nextInt(1,
				Configuration.getAxonSegmentSplitMaximum() + 1);
		ArtificialNeuron parentNeuron = parentSegment.getParentNeuron();

		// While we can still have children ...
		while (numChildrenPossible > 0) {
			// Get the number of remaining children the AN can have
			Integer arborRemainingChildren = parentNeuron.getNumRemainingAxonalChildren();

			// If the AN can still have children ...
			if (arborRemainingChildren > 0) {
				// Decrement the number of children the arbor can still have
				arborRemainingChildren--;
				parentNeuron.setNumRemainingAxonalChildren(arborRemainingChildren);

				// Have a child
				AxonalBranchSegment child = new AxonalBranchSegment(parentNeuron, parentSegment);
				parentSegment.addChildSegment(child);

				// Start arborization of that child
				(new Thread(new AxonalArborGenerator(child))).start();

				// Decrement the number of kids this axonal segment can have
				numChildrenPossible--;
			}
		}

	}

}
