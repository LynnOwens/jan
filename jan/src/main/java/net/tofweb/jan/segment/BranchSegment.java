package net.tofweb.jan.segment;

import java.util.ArrayList;
import java.util.List;

import net.tofweb.jan.network.SynapticTerminal;
import net.tofweb.jan.neuron.ArtificialNeuron;

public class BranchSegment extends Segment {

	List<SynapticTerminal> synapses;
	private List<BranchSegment> childSegments = new ArrayList<BranchSegment>();
	private Segment parentSegment;

	public BranchSegment(ArtificialNeuron parentNeuron, Segment parentSegment) {
		super(parentNeuron);
		this.parentSegment = parentSegment;
	}

	public BranchSegment(ArtificialNeuron parentNeuron) {
		super(parentNeuron);
		// TODO Auto-generated constructor stub
	}

	public List<SynapticTerminal> getSynapses() {
		return synapses;
	}

	public void setSynapses(List<SynapticTerminal> synapses) {
		this.synapses = synapses;
	}

	public List<BranchSegment> getChildSegments() {
		return childSegments;
	}

	public void setChildSegments(List<BranchSegment> childSegments) {
		this.childSegments = childSegments;
	}

	public void addChildSegment(BranchSegment childSegment) {
		this.childSegments.add(childSegment);
	}

	public Segment getParentSegment() {
		return parentSegment;
	}

	public void setParentSegment(Segment parentSegment) {
		this.parentSegment = parentSegment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((synapses == null) ? 0 : synapses.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BranchSegment other = (BranchSegment) obj;
		if (synapses == null) {
			if (other.synapses != null)
				return false;
		} else if (!synapses.equals(other.synapses))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BranchSegment [synapses=" + synapses + "]";
	}

}
