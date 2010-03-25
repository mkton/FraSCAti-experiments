
package home.media.alsamixer.client;

import home.media.alsamixer.AlsamixerManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.osoa.sca.annotations.Reference;
import org.osoa.sca.annotations.Service;

@Service(Runnable.class)
public class AlsamixerCommandLineClientImpl implements Runnable {

	@Reference(name="alsamixer-manager-service")
	AlsamixerManager manager;
	
	@Override
	public void run() {
		System.out.println("Welcome on your wonderful alsamixer" +
				" command line client");
		System.out.println("Use '+' or '-' in order to increase" +
				" or reduce sound volume.");
		System.out.println("type 'exit' for going away...");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String msg = "";
		
		while (! msg.equals("exit"))
		{
			try {
				msg = br.readLine();
				
				if (msg.equals("+")) {
					manager.increaseSoundLevel(10);
					System.out.println(manager.getSoundLevel());
				}
				else if (msg.equals("-")) {
					manager.reduceSoundLevel(10);
					System.out.println(manager.getSoundLevel());
				}
				else if (! msg.equals("exit")){
					System.out.println("na pas compris...");	
				}
        	} catch (IOException ioe) {
       			System.out.println("IO error!");
       			System.exit(1);
    		}
		}
	}	
}
