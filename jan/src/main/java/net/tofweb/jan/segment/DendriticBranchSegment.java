package net.tofweb.jan.segment;

import java.util.concurrent.ThreadLocalRandom;

import net.tofweb.jan.Configuration;
import net.tofweb.jan.measurement.KilohmPerCentimeterSquared;
import net.tofweb.jan.measurement.MicroFaradPerCentimeterSquared;
import net.tofweb.jan.measurement.MicroMeter;
import net.tofweb.jan.network.SynapticTerminal;
import net.tofweb.jan.neuron.ArtificialNeuron;
import net.tofweb.jan.potential.Potential;

public class DendriticBranchSegment extends BranchSegment {

	public static final MicroMeter LENGTH = Configuration.getDendriteSegmentLength();
	public static final MicroMeter RADIUS = Configuration.getDendriteSegmentRadius();
	private static MicroFaradPerCentimeterSquared membraneCapacitance = Configuration.getDendriteMembraneCapacitance();
	private static KilohmPerCentimeterSquared membraneResistance = Configuration.getDendriteMembraneResistance();
	private static KilohmPerCentimeterSquared intracellularResistance = Configuration.getDendriteIntracellularResistance();
	private static Potential restingPotential = Configuration.getDendriteRestingPotential();
	private static Integer maximumDendriticSegmentSplits = Configuration.getDendriteSegmentSplitMaximum();
	private static Integer synapsesPerMicroMeterSquared = Configuration.getDendriteSynapsesPerMicroMeterSquared();

	public DendriticBranchSegment(ArtificialNeuron parentNeuron, Segment parentSegment) {
		super(parentNeuron, parentSegment);
	}

	@Override
	protected void populateSynapses() {
		Integer synapsesRemaining = getSynapsesPerMicroMeterSquared() * getSurfaceArea().getMicroMeters().intValue();
		
		getSynapses().clear();
		while (synapsesRemaining > 0)
		{
			addSynapse(new SynapticTerminal());
			synapsesRemaining--;
		}
	}
	
	@Override
	protected void arborize() {
		int maxRemainingNeuronChildren = this.getParentNeuron().getNumRemainingDendriticChildren();

		if (maxRemainingNeuronChildren > 0) {
			int remainingSegmentChildren = ThreadLocalRandom.current().nextInt(0, getMaximumDendriticSegmentSplits() + 1);

			while (remainingSegmentChildren > 0) {
				ArtificialNeuron parentNeuron = this.getParentNeuron();
				maxRemainingNeuronChildren = parentNeuron.getNumRemainingAxonalChildren();

				if (maxRemainingNeuronChildren > 0) {
					AxonalBranchSegment nextChild = new AxonalBranchSegment(parentNeuron, this);
					this.addChildSegment(nextChild);
					parentNeuron.setNumRemainingDendriticChildren(--maxRemainingNeuronChildren);
					remainingSegmentChildren--;
					nextChild.arborize();
				} else {
					break;
				}
			}
		}	
	}

	public MicroFaradPerCentimeterSquared getMembraneCapacitance() {
		return membraneCapacitance;
	}

	public void setMembraneCapacitance(MicroFaradPerCentimeterSquared membraneCapacitance) {
		DendriticBranchSegment.membraneCapacitance = membraneCapacitance;
	}

	public KilohmPerCentimeterSquared getMembraneResistance() {
		return membraneResistance;
	}

	public void setMembraneResistance(KilohmPerCentimeterSquared membraneResistance) {
		DendriticBranchSegment.membraneResistance = membraneResistance;
	}

	public KilohmPerCentimeterSquared getIntracellularResistance() {
		return intracellularResistance;
	}

	public void setIntracellularResistance(KilohmPerCentimeterSquared intracellularResistance) {
		DendriticBranchSegment.intracellularResistance = intracellularResistance;
	}

	public Potential getRestingPotential() {
		return restingPotential;
	}

	public void setRestingPotential(Potential restingPotential) {
		DendriticBranchSegment.restingPotential = restingPotential;
	}

	public Integer getSynapsesPerMicroMeterSquared() {
		return synapsesPerMicroMeterSquared;
	}

	public void setSynapsesPerMicroMeterSquared(Integer synapsesPerMicroMeterSquared) {
		DendriticBranchSegment.synapsesPerMicroMeterSquared = synapsesPerMicroMeterSquared;
	}

	public Integer getMaximumDendriticSegmentSplits() {
		return maximumDendriticSegmentSplits;
	}

	public void setMaximumDendriticSegmentSplits(Integer maximumDendriticSegmentSplits) {
		DendriticBranchSegment.maximumDendriticSegmentSplits = maximumDendriticSegmentSplits;
	}

}
