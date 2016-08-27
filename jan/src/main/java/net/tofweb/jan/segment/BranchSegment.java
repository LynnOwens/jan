package net.tofweb.jan.segment;

import java.util.ArrayList;
import java.util.List;

import net.tofweb.jan.network.SynapticTerminal;
import net.tofweb.jan.neuron.ArtificialNeuron;

public abstract class BranchSegment extends Segment {

	private List<SynapticTerminal> synapses = new ArrayList<SynapticTerminal>();
	private Integer synapsesPerMicroMeterSquared;
	private List<BranchSegment> childSegments = new ArrayList<BranchSegment>();
	private Segment parentSegment;
	private Integer segmentSplitMaximum;

	public BranchSegment(ArtificialNeuron parentNeuron, Segment parentSegment) {
		super(parentNeuron);
		this.parentSegment = parentSegment;
	}

	public abstract void arborize();

	protected void nativeArborize(Integer maxRemainingChildren, Integer remainingSegmentSplits) {
		if (maxRemainingChildren > 0) {
			while (remainingSegmentSplits > 0) {

				ArtificialNeuron parentNeuron = this.getParentNeuron();
				maxRemainingChildren = parentNeuron.getNumRemainingAxonalChildren();

				if (maxRemainingChildren > 0) {
					AxonalBranchSegment nextChild = new AxonalBranchSegment(parentNeuron, this);
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

	public void populateSynapses() {
		Integer synapsesRemaining = getSynapsesPerMicroMeterSquared() * getSurfaceArea().getMicroMeters().intValue();

		getSynapses().clear();
		while (synapsesRemaining > 0) {
			addSynapse(new SynapticTerminal());
			synapsesRemaining--;
		}
	}

	public BranchSegment(ArtificialNeuron parentNeuron) {
		super(parentNeuron);
	}

	public List<SynapticTerminal> getSynapses() {
		return synapses;
	}

	public void setSynapses(List<SynapticTerminal> synapses) {
		this.synapses = synapses;
	}

	public void addSynapse(SynapticTerminal synapse) {
		this.synapses.add(synapse);
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

	public Integer getSynapsesPerMicroMeterSquared() {
		return synapsesPerMicroMeterSquared;
	}

	public void setSynapsesPerMicroMeterSquared(Integer synapsesPerMicroMeterSquared) {
		this.synapsesPerMicroMeterSquared = synapsesPerMicroMeterSquared;
	}

	public Integer getSegmentSplitMaximum() {
		return segmentSplitMaximum;
	}

	public void setSegmentSplitMaximum(Integer segmentSplitMaximum) {
		this.segmentSplitMaximum = segmentSplitMaximum;
	}

}
