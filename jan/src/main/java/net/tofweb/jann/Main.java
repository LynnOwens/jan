package net.tofweb.jann;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import net.tofweb.jann.neuron.ArtificialNeuron;

public class Main {
	private static final Logger log = Logger.getLogger(Main.class);
	public static Boolean keepAlive = true;

	public static void main(String[] args) {
		try {
			Main m = new Main();
			m.begin();
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
