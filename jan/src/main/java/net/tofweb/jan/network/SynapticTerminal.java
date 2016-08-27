package net.tofweb.jan.network;

import org.apache.log4j.Logger;

public class SynapticTerminal {

	private static final Logger log = Logger.getLogger(SynapticTerminal.class);
	public static final String HOST = "::1";
	public static final int PORT = 7777;

	public SynapticTerminal() {
		// // Create a FilterChain using FilterChainBuilder
		// FilterChainBuilder filterChainBuilder =
		// FilterChainBuilder.stateless();
		//
		// // Add TransportFilter, which is responsible
		// // for reading and writing data to the connection
		// filterChainBuilder.add(new TransportFilter());
		//
		// // StringFilter is responsible for Buffer <-> String conversion
		// filterChainBuilder.add(new StringFilter(Charset.forName("UTF-8")));
		//
		// // EchoFilter is responsible for echoing received messages
		// filterChainBuilder.add(new EchoFilter());
		//
		// // Create TCP transport
		// final TCPNIOTransport transport =
		// TCPNIOTransportBuilder.newInstance().build();
		//
		// // Apply the filter chain to the processor
		// transport.setProcessor(filterChainBuilder.build());
		//
		// try {
		// // binding transport to start listen on certain host and port
		// transport.bind(HOST, PORT);
		//
		// // start the transport
		// transport.start();
		//
		// // Run forever
		// while (Main.keepAlive) {
		// Thread.sleep(60000);
		// }
		// } catch (IOException e) {
		// log.error(e);
		// } catch (InterruptedException e) {
		// log.error(e);
		// } finally {
		// // stop the transport
		// try {
		// transport.shutdownNow();
		// } catch (IOException e) {
		// log.error(e);
		// }
		// }
	}

}
