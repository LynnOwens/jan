package net.tofweb.jan.segment;

import java.util.concurrent.ThreadLocalRandom; 

import net.tofweb.jan.Configuration;
import net.tofweb.jan.measurement.KilohmPerCentimeterSquared;
import net.tofweb.jan.measurement.MicroFaradPerCentimeterSquared;
import net.tofweb.jan.measurement.MicroMeter;
import net.tofweb.jan.network.SynapticTerminal;
import net.tofweb.jan.neuron.ArtificialNeuron;
import net.tofweb.jan.potential.Potential;

public class AxonalBranchSegment extends BranchSegment {

	public static final MicroMeter LENGTH = Configuration.getAxonSegmentLength();
	public static final MicroMeter RADIUS = Configuration.getAxonSegmentRadius();
	private static MicroFaradPerCentimeterSquared membraneCapacitance = Configuration.getAxonMembraneCapacitance();
	private static KilohmPerCentimeterSquared membraneResistance = Configuration.getAxonMembraneResistance();
	private static KilohmPerCentimeterSquared intracellularResistance = Configuration.getAxonIntracellularResistance();
	private static Potential restingPotential = Configuration.getAxonRestingPotential();
	private static Integer maximumAxonalSegmentSplits = Configuration.getAxonSegmentSplitMaximum();
	private static Integer synapsesPerMicroMeterSquared = Configuration.getAxonSynapsesPerMicroMeterSquared();

	public AxonalBranchSegment(ArtificialNeuron parentNeuron, Segment parentSegment) {
		super(parentNeuron, parentSegment);
	}
	
	@Override
	public void populateSynapses() {
		Integer synapsesRemaining = getSynapsesPerMicroMeterSquared() * getSurfaceArea().getMicroMeters().intValue();
		
		getSynapses().clear();
		while (synapsesRemaining > 0)
		{
			addSynapse(new SynapticTerminal());
			synapsesRemaining--;
		}
	}

	@Override 	
	public void arborize() {
		int maxRemainingAxonalChildren = this.getParentNeuron().getNumRemainingAxonalChildren();
		int remainingSegmentChildren = ThreadLocalRandom.current().nextInt(0, getMaximumAxonalSegmentSplits() + 1);
		nativeArborize(maxRemainingAxonalChildren, remainingSegmentChildren);
	}

	@Override
	public MicroFaradPerCentimeterSquared getMembraneCapacitance() {
		return membraneCapacitance;
	}

	@Override
	public void setMembraneCapacitance(MicroFaradPerCentimeterSquared membraneCapacitance) {
		AxonalBranchSegment.membraneCapacitance = membraneCapacitance;
	}

	@Override
	public KilohmPerCentimeterSquared getMembraneResistance() {
		return membraneResistance;
	}

	@Override
	public void setMembraneResistance(KilohmPerCentimeterSquared membraneResistance) {
		AxonalBranchSegment.membraneResistance = membraneResistance;
	}

	@Override
	public KilohmPerCentimeterSquared getIntracellularResistance() {
		return intracellularResistance;
	}

	@Override
	public void setIntracellularResistance(KilohmPerCentimeterSquared intracellularResistance) {
		AxonalBranchSegment.intracellularResistance = intracellularResistance;
	}

	@Override
	public Potential getRestingPotential() {
		return restingPotential;
	}

	@Override
	public void setRestingPotential(Potential restingPotential) {
		AxonalBranchSegment.restingPotential = restingPotential;
	}

	public Integer getMaximumAxonalSegmentSplits() {
		return maximumAxonalSegmentSplits;
	}

	public void setMaximumAxonalSegmentSplits(Integer maximumAxonalSegmentSplits) {
		AxonalBranchSegment.maximumAxonalSegmentSplits = maximumAxonalSegmentSplits;
	}

	public Integer getSynapsesPerMicroMeterSquared() {
		return synapsesPerMicroMeterSquared;
	}

	public void setSynapsesPerMicroMeterSquared(Integer synapsesPerMicroMeterSquared) {
		AxonalBranchSegment.synapsesPerMicroMeterSquared = synapsesPerMicroMeterSquared;
	}

}
