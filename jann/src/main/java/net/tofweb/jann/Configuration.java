package net.tofweb.jann;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Properties;

import org.apache.log4j.Logger;

import net.tofweb.jann.measurement.KilohmPerCentimeterSquared;
import net.tofweb.jann.measurement.MicroFaradPerCentimeterSquared;
import net.tofweb.jann.measurement.MicroMeter;
import net.tofweb.jann.measurement.MilliVolt;
import net.tofweb.jann.potential.Potential;

public class Configuration {

	private static final Logger log = Logger.getLogger(Configuration.class);

	/*
	 * Segment
	 */

	/*
	 * Somatic segment
	 */
	private static BigDecimal actionThresholdMillivolts;
	private static MicroMeter somaLength;
	private static MicroMeter somaRadius;
	private static KilohmPerCentimeterSquared somaMembraneResistance;
	private static KilohmPerCentimeterSquared somaIntracellularResistance;
	private static MicroFaradPerCentimeterSquared somaMembraneCapacitance;
	private static Potential somaRestingPotential;
	private static Integer maxNumberDendriteArbors;

	/*
	 * Dendritic branch segment
	 */
	private static MicroMeter dendriteSegmentLength;
	private static MicroMeter dendriteSegmentRadius;
	private static KilohmPerCentimeterSquared dendriteMembraneResistance;
	private static KilohmPerCentimeterSquared dendriteIntracellularResistance;
	private static MicroFaradPerCentimeterSquared dendriteMembraneCapacitance;
	private static Potential dendriteRestingPotential;
	private static Integer averageNumOfDendriteBranches;
	private static Integer dendriteSegmentSplitMaximum;
	private static Integer dendriteSynapsesPerMicroMeterSquared;

	/*
	 * Axonal branch segment
	 */
	private static MicroMeter axonSegmentLength;
	private static MicroMeter axonSegmentRadius;
	private static KilohmPerCentimeterSquared axonMembraneResistance;
	private static KilohmPerCentimeterSquared axonIntracellularResistance;
	private static MicroFaradPerCentimeterSquared axonMembraneCapacitance;
	private static Potential axonRestingPotential;
	private static Integer averageNumOfAxonBranches;
	private static Integer axonSegmentSplitMaximum;
	private static Integer axonSynapsesPerMicroMeterSquared;

	/*
	 * Networking
	 */
	private static String ulaPrefix;
	private static String globalId;
	private static Integer foo = 5;

	private static Properties prop = new Properties();

	public void load() {
		InputStream in = null;

		try {
			in = getClass().getResourceAsStream("/config.properties");
			prop.load(in);
		} catch (Exception e) {
			log.info("Unable to load configuration properties file.  Using defaults.", e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					log.warn("Unable to close configuration properties file input stream", e);
				}
			}
		}

		/*
		 * Soma configuration
		 */
		actionThresholdMillivolts = new BigDecimal(prop.getProperty("potential.action.threshold.millivolts", "-55"));

		somaMembraneResistance = new KilohmPerCentimeterSquared(
				new BigDecimal(prop.getProperty("segment.somatic.membraneResistance.specific.kO2", "2200")));

		somaIntracellularResistance = new KilohmPerCentimeterSquared(
				new BigDecimal(prop.getProperty("segment.somatic.intracellularResistance.specific.kO2", "8000")));

		somaMembraneCapacitance = new MicroFaradPerCentimeterSquared(
				new BigDecimal(prop.getProperty("segment.somatic.membraneCapacitance.specific.uf2", "14")));

		somaLength = new MicroMeter(new BigDecimal(prop.getProperty("segment.somatic.length.um", "100")));

		somaRadius = new MicroMeter(new BigDecimal(prop.getProperty("segment.somatic.radius.um", "50")));

		somaRestingPotential = new Potential(
				new MilliVolt(new BigDecimal(prop.getProperty("segment.somatic.rest.potential.millivolts", "-65"))),
				somaIntracellularResistance);

		maxNumberDendriteArbors = Integer.valueOf(prop.getProperty("segment.somatic.rest.potential.millivolts", "4"));

		/*
		 * Dendrite configuration
		 */
		dendriteMembraneResistance = new KilohmPerCentimeterSquared(
				new BigDecimal(prop.getProperty("segment.dendritic.membraneResistance.specific.kO2", "120.2")));

		dendriteIntracellularResistance = new KilohmPerCentimeterSquared(
				new BigDecimal(prop.getProperty("segment.dendritic.intracellularResistance.specific.kO2", ".00004")));

		dendriteMembraneCapacitance = new MicroFaradPerCentimeterSquared(
				new BigDecimal(prop.getProperty("segment.dendritic.membraneCapacitance.specific.uf2", ".64")));

		dendriteSegmentLength = new MicroMeter(new BigDecimal(prop.getProperty("segment.dendritic.length.um", "107")));

		dendriteSegmentRadius = new MicroMeter(new BigDecimal(prop.getProperty("segment.dendritic.radius.um", "1.28")));

		dendriteRestingPotential = new Potential(
				new MilliVolt(new BigDecimal(prop.getProperty("segment.dendritic.rest.potential.millivolts", "-65"))),
				dendriteIntracellularResistance);

		averageNumOfDendriteBranches = Integer
				.valueOf(prop.getProperty("segment.dendritic.arbor.branch.average", "226"));

		dendriteSegmentSplitMaximum = Integer
				.valueOf(prop.getProperty("segment.dendritic.arbor.branch.split.max", "5"));

		dendriteSynapsesPerMicroMeterSquared = Integer
				.valueOf(prop.getProperty("segment.dendritic.synapse.density", "4"));

		/*
		 * Axon configuration
		 */
		axonMembraneResistance = new KilohmPerCentimeterSquared(
				new BigDecimal(prop.getProperty("segment.axonal.membraneResistance.specific.kO2", "100")));

		axonIntracellularResistance = new KilohmPerCentimeterSquared(
				new BigDecimal(prop.getProperty("segment.axonal.intracellularResistance.specific.kO2", "100")));

		axonMembraneCapacitance = new MicroFaradPerCentimeterSquared(
				new BigDecimal(prop.getProperty("segment.axonal.membraneCapacitance.specific.uf2", ".9")));

		axonSegmentLength = new MicroMeter(new BigDecimal(prop.getProperty("segment.axonal.length.um", "1688")));

		axonSegmentRadius = new MicroMeter(new BigDecimal(prop.getProperty("segment.axonal.radius.um", ".455")));

		axonRestingPotential = new Potential(
				new MilliVolt(new BigDecimal(prop.getProperty("segment.axonal.rest.potential.millivolts", "-65"))),
				axonIntracellularResistance);

		averageNumOfAxonBranches = Integer.valueOf(prop.getProperty("segment.axonal.arbor.branch.average", "150"));

		axonSegmentSplitMaximum = Integer.valueOf(prop.getProperty("segment.axonal.arbor.branch.split.max", "3"));

		axonSynapsesPerMicroMeterSquared = Integer.valueOf(prop.getProperty("segment.axonal.synapse.density", "7"));

		/*
		 * Networking
		 */
		ulaPrefix = prop.getProperty("network.address.prefix", "fd");
		globalId = prop.getProperty("network.address.globalid", "f0:9250:83e6");
	}

	private static void conditinallyLoad() {
		if (Configuration.prop.size() == 0) {
			Configuration c = new Configuration();
			c.load();
		}
	}

	public static BigDecimal getActionThresholdMillivolts() {
		Configuration.conditinallyLoad();
		return actionThresholdMillivolts;
	}

	public static void setActionThresholdMillivolts(BigDecimal actionThresholdMillivolts) {
		Configuration.actionThresholdMillivolts = actionThresholdMillivolts;
	}

	public static MicroMeter getSomaLength() {
		Configuration.conditinallyLoad();
		return somaLength;
	}

	public static void setSomaLength(MicroMeter somaLength) {
		Configuration.somaLength = somaLength;
	}

	public static MicroMeter getSomaRadius() {
		Configuration.conditinallyLoad();
		return somaRadius;
	}

	public static void setSomaRadius(MicroMeter somaRadius) {
		Configuration.somaRadius = somaRadius;
	}

	public static KilohmPerCentimeterSquared getSomaMembraneResistance() {
		Configuration.conditinallyLoad();
		return somaMembraneResistance;
	}

	public static void setSomaMembraneResistance(KilohmPerCentimeterSquared somaMembraneResistance) {
		Configuration.somaMembraneResistance = somaMembraneResistance;
	}

	public static KilohmPerCentimeterSquared getSomaIntracellularResistance() {
		Configuration.conditinallyLoad();
		return somaIntracellularResistance;
	}

	public static void setSomaIntracellularResistance(KilohmPerCentimeterSquared somaIntracellularResistance) {
		Configuration.somaIntracellularResistance = somaIntracellularResistance;
	}

	public static MicroFaradPerCentimeterSquared getSomaMembraneCapacitance() {
		Configuration.conditinallyLoad();
		return somaMembraneCapacitance;
	}

	public static void setSomaMembraneCapacaitance(MicroFaradPerCentimeterSquared somaMembraneCapacaitance) {
		Configuration.somaMembraneCapacitance = somaMembraneCapacaitance;
	}

	public static Potential getSomaRestingPotential() {
		Configuration.conditinallyLoad();
		return somaRestingPotential;
	}

	public static void setSomaRestingPotential(Potential somaRestingPotential) {
		Configuration.somaRestingPotential = somaRestingPotential;
	}

	public static MicroMeter getDendriteSegmentLength() {
		Configuration.conditinallyLoad();
		return dendriteSegmentLength;
	}

	public static void setDendriteSegmentLength(MicroMeter dendriteLength) {
		Configuration.dendriteSegmentLength = dendriteLength;
	}

	public static MicroMeter getDendriteSegmentRadius() {
		Configuration.conditinallyLoad();
		return dendriteSegmentRadius;
	}

	public static void setDendriteSegmentRadius(MicroMeter dendriteRadius) {
		Configuration.dendriteSegmentRadius = dendriteRadius;
	}

	public static KilohmPerCentimeterSquared getDendriteMembraneResistance() {
		Configuration.conditinallyLoad();
		return dendriteMembraneResistance;
	}

	public static void setDendriteMembraneResistance(KilohmPerCentimeterSquared dendriteMembraneResistance) {
		Configuration.dendriteMembraneResistance = dendriteMembraneResistance;
	}

	public static KilohmPerCentimeterSquared getDendriteIntracellularResistance() {
		Configuration.conditinallyLoad();
		return dendriteIntracellularResistance;
	}

	public static void setDendriteIntracellularResistance(KilohmPerCentimeterSquared dendriteIntracellularResistance) {
		Configuration.dendriteIntracellularResistance = dendriteIntracellularResistance;
	}

	public static MicroFaradPerCentimeterSquared getDendriteMembraneCapacitance() {
		Configuration.conditinallyLoad();
		return dendriteMembraneCapacitance;
	}

	public static void setDendriteMembraneCapacaitance(MicroFaradPerCentimeterSquared dendriteMembraneCapacaitance) {
		Configuration.dendriteMembraneCapacitance = dendriteMembraneCapacaitance;
	}

	public static Potential getDendriteRestingPotential() {
		Configuration.conditinallyLoad();
		return dendriteRestingPotential;
	}

	public static void setDendriteRestingPotential(Potential dendriteRestingPotential) {
		Configuration.dendriteRestingPotential = dendriteRestingPotential;
	}

	public static MicroMeter getAxonSegmentLength() {
		Configuration.conditinallyLoad();
		return axonSegmentLength;
	}

	public static void setAxonSegmentLength(MicroMeter axonSegmentLength) {
		Configuration.axonSegmentLength = axonSegmentLength;
	}

	public static MicroMeter getAxonSegmentRadius() {
		Configuration.conditinallyLoad();
		return axonSegmentRadius;
	}

	public static void setAxonSegmentRadius(MicroMeter axonSegmentRadius) {
		Configuration.axonSegmentRadius = axonSegmentRadius;
	}

	public static KilohmPerCentimeterSquared getAxonMembraneResistance() {
		Configuration.conditinallyLoad();
		return axonMembraneResistance;
	}

	public static void setAxonMembraneResistance(KilohmPerCentimeterSquared axonMembraneResistance) {
		Configuration.axonMembraneResistance = axonMembraneResistance;
	}

	public static KilohmPerCentimeterSquared getAxonIntracellularResistance() {
		Configuration.conditinallyLoad();
		return axonIntracellularResistance;
	}

	public static void setAxonIntracellularResistance(KilohmPerCentimeterSquared axonIntracellularResistance) {
		Configuration.axonIntracellularResistance = axonIntracellularResistance;
	}

	public static MicroFaradPerCentimeterSquared getAxonMembraneCapacitance() {
		Configuration.conditinallyLoad();
		return axonMembraneCapacitance;
	}

	public static void setAxonMembraneCapacitance(MicroFaradPerCentimeterSquared axonMembraneCapacitance) {
		Configuration.axonMembraneCapacitance = axonMembraneCapacitance;
	}

	public static Potential getAxonRestingPotential() {
		Configuration.conditinallyLoad();
		return axonRestingPotential;
	}

	public static void setAxonRestingPotential(Potential axonRestingPotential) {
		Configuration.axonRestingPotential = axonRestingPotential;
	}

	public static void setSomaMembraneCapacitance(MicroFaradPerCentimeterSquared somaMembraneCapacitance) {
		Configuration.somaMembraneCapacitance = somaMembraneCapacitance;
	}

	public static void setDendriteMembraneCapacitance(MicroFaradPerCentimeterSquared dendriteMembraneCapacitance) {
		Configuration.dendriteMembraneCapacitance = dendriteMembraneCapacitance;
	}

	public static Integer getAverageNumOfAxonBranches() {
		Configuration.conditinallyLoad();
		return averageNumOfAxonBranches;
	}

	public static void setAverageNumOfAxonBranches(Integer averageNumOfAxonBranches) {
		Configuration.averageNumOfAxonBranches = averageNumOfAxonBranches;
	}

	public static Integer getAxonSegmentSplitMaximum() {
		Configuration.conditinallyLoad();
		return axonSegmentSplitMaximum;
	}

	public static void setAxonSegmentSplitMaximum(Integer axonSegmentSplitMaximum) {
		Configuration.axonSegmentSplitMaximum = axonSegmentSplitMaximum;
	}

	public static Integer getAxonSynapsesPerMicroMeterSquared() {
		Configuration.conditinallyLoad();
		return axonSynapsesPerMicroMeterSquared;
	}

	public static void setAxonSynapsesPerMicroMeterSquared(Integer synapsesPerMicroMeterSquared) {
		Configuration.axonSynapsesPerMicroMeterSquared = synapsesPerMicroMeterSquared;
	}

	public static Integer getDendriteSynapsesPerMicroMeterSquared() {
		Configuration.conditinallyLoad();
		return dendriteSynapsesPerMicroMeterSquared;
	}

	public static void setDendriteSynapsesPerMicroMeterSquared(Integer dendriteSynapsesPerMicroMeterSquared) {
		Configuration.dendriteSynapsesPerMicroMeterSquared = dendriteSynapsesPerMicroMeterSquared;
	}

	public static Integer getAverageNumOfDendriteBranches() {
		Configuration.conditinallyLoad();
		return averageNumOfDendriteBranches;
	}

	public static void setAverageNumOfDendriteBranches(Integer averageNumOfDendriteBranches) {
		Configuration.averageNumOfDendriteBranches = averageNumOfDendriteBranches;
	}

	public static Integer getDendriteSegmentSplitMaximum() {
		Configuration.conditinallyLoad();
		return dendriteSegmentSplitMaximum;
	}

	public static void setDendriteSegmentSplitMaximum(Integer dendriteSegmentSplitMaximum) {
		Configuration.dendriteSegmentSplitMaximum = dendriteSegmentSplitMaximum;
	}

	public static Integer getMaxNumberDendriteArbors() {
		Configuration.conditinallyLoad();
		return maxNumberDendriteArbors;
	}

	public static void setMaxNumberDendriteArbors(Integer maxNumberDendriteArbors) {
		Configuration.maxNumberDendriteArbors = maxNumberDendriteArbors;
	}

	public static String getUlaPrefix() {
		Configuration.conditinallyLoad();
		return ulaPrefix;
	}

	public static void setUlaPrefix(String ulaPrefix) {
		Configuration.ulaPrefix = ulaPrefix;
	}

	public static String getGlobalId() {
		Configuration.conditinallyLoad();
		return globalId;
	}

	public static void setGlobalId(String globalId) {
		Configuration.globalId = globalId;
	}

	public static Integer getFoo() {
		return foo;
	}

	public static void setFoo(Integer foo) {
		Configuration.foo = foo;
	}

}
