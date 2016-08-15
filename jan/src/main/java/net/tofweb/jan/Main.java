package net.tofweb.jan;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import net.tofweb.jan.network.BackPlane;
import net.tofweb.jan.neuron.ArtificialNeuron;

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

		// Start the network
		(new Thread(new BackPlane())).start();

		// Build two neurons
		ArtificialNeuron a1 = new ArtificialNeuron();
		ArtificialNeuron a2 = new ArtificialNeuron();
	}

}
