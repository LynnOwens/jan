package net.tofweb.jan.network;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.glassfish.grizzly.filterchain.FilterChainBuilder;
import org.glassfish.grizzly.filterchain.TransportFilter;
import org.glassfish.grizzly.nio.transport.TCPNIOTransport;
import org.glassfish.grizzly.nio.transport.TCPNIOTransportBuilder;
import org.glassfish.grizzly.utils.EchoFilter;
import org.glassfish.grizzly.utils.StringFilter;

import net.tofweb.jan.Main;

public class BackPlane implements Runnable {

	private static final Logger log = Logger.getLogger(BackPlane.class);

	public static final String HOST = "::1";
	public static final int PORT = 7777;

	public void run() {

		// Set up a simple configuration that logs on the console.
		BasicConfigurator.configure();

		// Create a FilterChain using FilterChainBuilder
		FilterChainBuilder filterChainBuilder = FilterChainBuilder.stateless();

		// Add TransportFilter, which is responsible
		// for reading and writing data to the connection
		filterChainBuilder.add(new TransportFilter());

		// StringFilter is responsible for Buffer <-> String conversion
		filterChainBuilder.add(new StringFilter(Charset.forName("UTF-8")));

		// EchoFilter is responsible for echoing received messages
		filterChainBuilder.add(new EchoFilter());

		// Create TCP transport
		final TCPNIOTransport transport = TCPNIOTransportBuilder.newInstance().build();

		// Apply the filter chain to the processor
		transport.setProcessor(filterChainBuilder.build());

		try {
			// binding transport to start listen on certain host and port
			transport.bind(HOST, PORT);

			// start the transport
			transport.start();

			// Run forever
			while (Main.keepAlive) {

			}
		} catch (IOException e) {
			log.error(e);
		} finally {
			// stop the transport
			try {
				transport.shutdownNow();
			} catch (IOException e) {
				log.error(e);
			}
		}
	}
}
