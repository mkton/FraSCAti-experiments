package home.media.vlc;

import org.osoa.sca.annotations.Service;

@Service
public interface VlcManager {
	
	/**
	 * Start vlc with the http interface
	 * 
	 *  @param http port for the interface
	 */
	public void runHttpInterface(int port);
	
	/**
	 * Make vlc listen to and play a stream via udp protocol
	 * 
	 * @param the port where the server should listen to
	 */
	public void listenToUDPStream(int port);
	
	/**
	 * Stop vlc
	 */
	public void stop();
}
