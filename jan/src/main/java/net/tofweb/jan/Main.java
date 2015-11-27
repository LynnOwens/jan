package net.tofweb.jan;

import org.apache.log4j.Logger;

public class Main {
	private static final Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		new Configuration().load();
		log.info("Action potential threshold is: " + Configuration.actionThresholdMillivolts);
	}

}
