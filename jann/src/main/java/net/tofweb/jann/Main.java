package net.tofweb.jann;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import net.tofweb.jann.network.neuron.ArtificialNeuron;

public class Main {
	private static final Logger log = Logger.getLogger(Main.class);
	public static Boolean keepAlive = true;

	public static void main(String[] args) {
		try {
			Main m = new Main();
			// m.begin();
			String example = "2001:0db8:85a3:0000:0000:8a2e:0370:7334";
			String sixthHextet = example.substring(StringUtils.ordinalIndexOf(example, ":", 5) + 1,
					StringUtils.ordinalIndexOf(example, ":", 6));
			String seventhHextet = example.substring(StringUtils.ordinalIndexOf(example, ":", 6) + 1,
					StringUtils.ordinalIndexOf(example, ":", 7));
			String eighthHextet = example.substring(StringUtils.ordinalIndexOf(example, ":", 7) + 1);
			log.debug(sixthHextet);
			log.debug(seventhHextet);
			log.debug(eighthHextet);

			log.debug(Integer.parseInt(sixthHextet, 16));
			log.debug(Integer.parseInt(seventhHextet, 16));
			log.debug(Integer.parseInt(eighthHextet, 16));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	private void begin() throws IOException {
		// Load log4j
		Properties props = new Properties();
		props.load(getClass().getResourceAsStream("/log4j.properties"));
		PropertyConfigurator.configure(props);

		// Configure the app
		new Configuration().load();

		// Build two neurons
		ArtificialNeuron a1 = new ArtificialNeuron();
		ArtificialNeuron a2 = new ArtificialNeuron();

		/*
		 * Each AN has it's own address, called a centerPoint Each AST gets it's
		 * own address based on that centerPoint
		 * 
		 * AN has a connectTo(AN) and a connectNear(AN) method These methods
		 * build DBS as needed.
		 * 
		 * Another AN in the same network as the the first can connect with a
		 * DBS off the soma.
		 * 
		 * When the other AN is in another network or the DBS has run out of DST
		 * then it grows another DBS
		 */
	}

}
