package home.web.media.vlc;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.osoa.sca.annotations.Service;

@Service
public interface VlcRestManager {
	
	/**
	 * Start vlc with the http interface
	 * 
	 *  @param http port for the interface
	 */
	@GET
	@Path("/runHttp")
	@Produces("text/plain")
	public void runHttpInterface(@FormParam("port") int port);
	
	/**
	 * Make vlc listen to and play a stream via udp protocol
	 * 
	 * @param the port where the server should listen to
	 */
	@GET
	@Path("/listenToStream")
	@Produces("text/plain")
	public void listenToUDPStream(@FormParam("port") int port);
	
	/**
	 * Stop vlc
	 */
	@GET
	@Path("/stop")
	@Produces("text/plain")
	public void stop();
}
