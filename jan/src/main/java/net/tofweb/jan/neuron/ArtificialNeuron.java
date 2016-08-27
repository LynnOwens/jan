package net.tofweb.jan.neuron;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import net.tofweb.jan.Configuration;
import net.tofweb.jan.segment.AxonalBranchSegment;
import net.tofweb.jan.segment.DendriticBranchSegment;
import net.tofweb.jan.segment.SomaticSegment;

public class ArtificialNeuron {
	private SomaticSegment soma;
	private List<DendriticBranchSegment> dendrites;
	private AxonalBranchSegment axonHillock;
	private Integer maxNumberDendriteArbors = Configuration.getMaxNumberDendriteArbors();

	// TODO: Put a range around this
	private Integer numRemainingAxonalChildren = Configuration.getAverageNumOfAxonBranches();
	
	// TODO: Put a range around this
	private Integer numRemainingDendriticChildren = Configuration.getAverageNumOfDendriteBranches();

	public ArtificialNeuron() {
		super();

		// Setup the soma
		soma = new SomaticSegment(this);

		// Build the axon hillock
		axonHillock = new AxonalBranchSegment(this, soma);

		// Build the axon arbor
		axonHillock.arborize();
		
		// Build multiple dendrite arbors
		populateDendrites();
	}
	
	public void populateDendrites() {
		int remainingDendriteHillocks = ThreadLocalRandom.current().nextInt(0, getMaxNumberDendriteArbors() + 1);
		
		if (remainingDendriteHillocks > 0) {
			DendriticBranchSegment dendrite = new DendriticBranchSegment(this, soma);
			dendrite.arborize();
			addDendrite(dendrite);
		}
	}

	public SomaticSegment getSoma() {
		return soma;
	}

	public void setSoma(SomaticSegment soma) {
		this.soma = soma;
	}

	public List<DendriticBranchSegment> getDendrites() {
		return dendrites;
	}

	public void setDendrites(List<DendriticBranchSegment> dendriteArbors) {
		this.dendrites = dendriteArbors;
	}
	
	public void addDendrite(DendriticBranchSegment dendrite)
	{
		this.dendrites.add(dendrite);
	}

	public AxonalBranchSegment getAxonHillock() {
		return axonHillock;
	}

	public void setAxonHillock(AxonalBranchSegment axonHillock) {
		this.axonHillock = axonHillock;
	}

	public Integer getNumRemainingAxonalChildren() {
		return numRemainingAxonalChildren;
	}

	public void setNumRemainingAxonalChildren(Integer numRemainingAxonalChildren) {
		this.numRemainingAxonalChildren = numRemainingAxonalChildren;
	}

	public Integer getNumRemainingDendriticChildren() {
		return numRemainingDendriticChildren;
	}

	public void setNumRemainingDendriticChildren(Integer numRemainingDendriticChildren) {
		this.numRemainingDendriticChildren = numRemainingDendriticChildren;
	}

	public Integer getMaxNumberDendriteArbors() {
		return maxNumberDendriteArbors;
	}

	public void setMaxNumberDendriteArbors(Integer maxNumberDendriteArbors) {
		this.maxNumberDendriteArbors = maxNumberDendriteArbors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((axonHillock == null) ? 0 : axonHillock.hashCode());
		result = prime * result + ((dendrites == null) ? 0 : dendrites.hashCode());
		result = prime * result + ((soma == null) ? 0 : soma.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArtificialNeuron other = (ArtificialNeuron) obj;
		if (axonHillock == null) {
			if (other.axonHillock != null)
				return false;
		} else if (!axonHillock.equals(other.axonHillock))
			return false;
		if (dendrites == null) {
			if (other.dendrites != null)
				return false;
		} else if (!dendrites.equals(other.dendrites))
			return false;
		if (soma == null) {
			if (other.soma != null)
				return false;
		} else if (!soma.equals(other.soma))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ArtificialNeuron [soma=" + soma + ", dendriteArbors=" + dendrites + ", axonHillock=" + axonHillock
				+ "]";
	}

}