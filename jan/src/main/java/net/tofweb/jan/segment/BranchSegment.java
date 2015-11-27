package net.tofweb.jan.segment;

import java.util.List;

import net.tofweb.jan.network.SynapticTerminal;

public class BranchSegment extends Segment {

	List<SynapticTerminal> synapses;

	public List<SynapticTerminal> getSynapses() {
		return synapses;
	}

	public void setSynapses(List<SynapticTerminal> synapses) {
		this.synapses = synapses;
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
