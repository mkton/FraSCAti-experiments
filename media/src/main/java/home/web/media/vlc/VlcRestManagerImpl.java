package home.web.media.vlc;

import home.media.vlc.VlcManager;

import org.osoa.sca.annotations.Reference;
import org.osoa.sca.annotations.Scope;

@Scope("COMPOSITE")
public class VlcRestManagerImpl implements VlcRestManager {

	@Reference(name="vlc-manager-service")
	VlcManager vlcManager;
	
	public void listenToUDPStream(int port) {
		this.vlcManager.listenToUDPStream(port);
	}

	public void runHttpInterface(int port) {
		this.vlcManager.runHttpInterface(port);
	}

	public void stop() {
		this.vlcManager.stop();
	}

}
