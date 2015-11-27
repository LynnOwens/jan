package net.tofweb.jan;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Properties;

import org.apache.log4j.Logger;

import net.tofweb.jan.measurement.KilohmPerCentimeterSquared;
import net.tofweb.jan.measurement.MicroFaradPerCentimeterSquared;
import net.tofweb.jan.measurement.MicroMeter;
import net.tofweb.jan.measurement.MilliVolt;
import net.tofweb.jan.potential.Potential;

public class Configuration {

	private static final Logger log = Logger.getLogger(Configuration.class);

	public static BigDecimal actionThresholdMillivolts = new BigDecimal("-55");
	public static MicroMeter somaLength = new MicroMeter(new BigDecimal("100"));
	public static MicroMeter somaRadius = new MicroMeter(new BigDecimal("50"));
	public static KilohmPerCentimeterSquared somaMembraneResistance = new KilohmPerCentimeterSquared(
			new BigDecimal("2200"));
	public static KilohmPerCentimeterSquared somaIntracellularResistance = new KilohmPerCentimeterSquared(
			new BigDecimal("8000"));
	public static MicroFaradPerCentimeterSquared somaMembraneCapacaitance = new MicroFaradPerCentimeterSquared(
			new BigDecimal("14"));
	public static Potential somaRestingPotential = new Potential(new MilliVolt(new BigDecimal("-65")),
			somaIntracellularResistance);

	public void load() {
		Properties prop = new Properties();
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

		actionThresholdMillivolts = new BigDecimal(
				prop.getProperty("potential.action.threshold.millivolts", actionThresholdMillivolts.toString()));

		somaMembraneResistance = new KilohmPerCentimeterSquared(new BigDecimal(prop.getProperty(
				"segment.somatic.membraneResistance.specific.kO2", somaMembraneResistance.getKilohms().toString())));

		somaIntracellularResistance = new KilohmPerCentimeterSquared(
				new BigDecimal(prop.getProperty("segment.somatic.intracellularResistance.specific.kO2",
						somaIntracellularResistance.getKilohms().toString())));

		somaMembraneCapacaitance = new MicroFaradPerCentimeterSquared(
				new BigDecimal(prop.getProperty("segment.somatic.membraneCapacitance.specific.uf2",
						somaMembraneCapacaitance.getMicroFarads().toString())));

		somaLength = new MicroMeter(
				new BigDecimal(prop.getProperty("segment.somatic.length.um", somaLength.getMicroMeters().toString())));

		somaRadius = new MicroMeter(
				new BigDecimal(prop.getProperty("segment.somatic.radius.um", somaRadius.getMicroMeters().toString())));

		somaRestingPotential = new Potential(
				new MilliVolt(new BigDecimal(prop.getProperty("segment.somatic.rest.potential.millivolts",
						somaRestingPotential.getVoltage().toString()))),
				somaIntracellularResistance);
	}
}
