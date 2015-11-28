package net.tofweb.jan.neuron;

import java.util.List;

import net.tofweb.jan.Configuration;
import net.tofweb.jan.arbor.AxonalArborGenerator;
import net.tofweb.jan.segment.AxonalBranchSegment;
import net.tofweb.jan.segment.DendriticBranchSegment;
import net.tofweb.jan.segment.SomaticSegment;

public class ArtificialNeuron {
	private SomaticSegment soma;
	private List<DendriticBranchSegment> dendriteArbors;
	private AxonalBranchSegment axonHillock;
	private Integer numRemainingAxonalChildren = Configuration.getAverageNumOfAxonBranches();

	public ArtificialNeuron() {
		super();

		// Setup the soma
		soma = new SomaticSegment(this);

		// Build the axon hillock
		axonHillock = new AxonalBranchSegment(this, soma);

		// Build the axon arbor
		(new Thread(new AxonalArborGenerator(axonHillock))).start();

	}

	public SomaticSegment getSoma() {
		return soma;
	}

	public void setSoma(SomaticSegment soma) {
		this.soma = soma;
	}

	public List<DendriticBranchSegment> getDendriteArbors() {
		return dendriteArbors;
	}

	public void setDendriteArbors(List<DendriticBranchSegment> dendriteArbors) {
		this.dendriteArbors = dendriteArbors;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((axonHillock == null) ? 0 : axonHillock.hashCode());
		result = prime * result + ((dendriteArbors == null) ? 0 : dendriteArbors.hashCode());
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
		if (dendriteArbors == null) {
			if (other.dendriteArbors != null)
				return false;
		} else if (!dendriteArbors.equals(other.dendriteArbors))
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
		return "ArtificialNeuron [soma=" + soma + ", dendriteArbors=" + dendriteArbors + ", axonHillock=" + axonHillock
				+ "]";
	}

}
