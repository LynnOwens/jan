package net.tofweb.jann.neuron;

import java.util.List;

import net.tofweb.jann.Configuration;
import net.tofweb.jann.network.NetworkMember;
import net.tofweb.jann.segment.AxonalBranchSegment;
import net.tofweb.jann.segment.DendriticBranchSegment;
import net.tofweb.jann.segment.SomaticSegment;

public class ArtificialNeuron extends NetworkMember {
	private SomaticSegment soma;
	private List<DendriticBranchSegment> dendrites;
	private AxonalBranchSegment axonHillock;
	private Integer maxNumberDendriteArbors = Configuration.getMaxNumberDendriteArbors();

	// TODO: Put a range around this
	private Integer numRemainingAxonalBranches = Configuration.getAverageNumOfAxonBranches();

	// TODO: Put a range around this
	private Integer numRemainingDendriticBranches = Configuration.getAverageNumOfDendriteBranches();

	public ArtificialNeuron() {
		super();

		// TODO: Move me to configuration
		// Axons branch about 150 times and are about 1000 coords long each
		// Dendrites branch about 225 times and are about 180 coords long each

		soma = new SomaticSegment(this);
		axonHillock = new AxonalBranchSegment(soma, 1000);
		axonHillock.arborize();
	}

	public void connectTo(ArtificialNeuron an) {

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

	public void addDendrite(DendriticBranchSegment dendrite) {
		this.dendrites.add(dendrite);
	}

	public AxonalBranchSegment getAxonHillock() {
		return axonHillock;
	}

	public void setAxonHillock(AxonalBranchSegment axonHillock) {
		this.axonHillock = axonHillock;
	}

	public Integer getMaxNumberDendriteArbors() {
		return maxNumberDendriteArbors;
	}

	public void setMaxNumberDendriteArbors(Integer maxNumberDendriteArbors) {
		this.maxNumberDendriteArbors = maxNumberDendriteArbors;
	}

	public Integer getNumRemainingAxonalBranches() {
		return numRemainingAxonalBranches;
	}

	public void setNumRemainingAxonalBranches(Integer numRemainingAxonalBranches) {
		this.numRemainingAxonalBranches = numRemainingAxonalBranches;
	}

	public Integer getNumRemainingDendriticBranches() {
		return numRemainingDendriticBranches;
	}

	public void setNumRemainingDendriticBranches(Integer numRemainingDendriticBranches) {
		this.numRemainingDendriticBranches = numRemainingDendriticBranches;
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
