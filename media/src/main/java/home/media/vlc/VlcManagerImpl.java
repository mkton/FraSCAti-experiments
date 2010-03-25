package home.media.vlc;

import home.os.command.CommandProcessor;

import org.osoa.sca.annotations.Reference;
import org.osoa.sca.annotations.Scope;

@Scope("COMPOSITE")
public class VlcManagerImpl implements VlcManager {
	
	@Reference(name="os-command-service")
	CommandProcessor commandProcessor;
			
	private Process process;
	
	private void launchCommand(String command){
		this.stop();
		this.process = commandProcessor.process(command);
	}
	
	public void listenToUDPStream(int port) {
		this.launchCommand("vlc udp://@:1234");
		System.out.println("vlc is now listen to stream on port 1234");
	}

	public void runHttpInterface(int port) {
		this.launchCommand("vlc -I http --extraintf=http --qt-start-minimized");
		System.out.println("vlc is now available by http interface on port 8080");
	}

	public void stop(){
		if (this.process != null){
			this.process.destroy();
			this.process = null;
			System.out.println("vlc is now stopped");
		}
	}
}
