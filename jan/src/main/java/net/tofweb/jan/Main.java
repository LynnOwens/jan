package net.tofweb.jan;

import org.apache.log4j.Logger;

import net.tofweb.jan.network.BackPlane;
import net.tofweb.jan.neuron.ArtificialNeuron;

public class Main {
	private static final Logger log = Logger.getLogger(Main.class);
	public static Boolean keepAlive = true;

	public static void main(String[] args) {
		new Configuration().load();
		(new Thread(new BackPlane())).start();
		ArtificialNeuron a1 = new ArtificialNeuron();
		ArtificialNeuron a2 = new ArtificialNeuron();
	}

}
