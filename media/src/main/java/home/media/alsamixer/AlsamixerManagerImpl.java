package home.media.alsamixer;

import home.os.command.CommandProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.osoa.sca.annotations.Reference;
import org.osoa.sca.annotations.Scope;

@Scope("COMPOSITE")
public class AlsamixerManagerImpl implements AlsamixerManager {

	private static final String alsaSetCommand = "amixer set Master ";
	private static final String alsaGetCommand = "amixer get Master ";
	//private static final String alsaCutPercentSoundLevel = " | grep % | cut -d% -f 1 | cut -d[ -f 2";
	
	@Reference(name="os-command-service")
	CommandProcessor commandProcessor;
	
	@Override
	public void increaseSoundLevel(int gain) {
		String cmd = alsaSetCommand + gain + "+";
		Process process = commandProcessor.process(cmd);
		
		return;
	}

	@Override
	public void reduceSoundLevel(int gain) {
		String cmd = alsaSetCommand + gain + "-";
		Process process = commandProcessor.process(cmd);
		
		return;
	}
	
	@Override
	public int getSoundLevel(){
		String cmd = alsaGetCommand;
		Process process = commandProcessor.process(cmd);
		
		return this.getSoundLevelFomProcess(process);
	}
	
	private int getSoundLevelFomProcess(Process process) {		
		BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String result = "";
		String tmp;
		try {
			// we get the last line
			while((tmp = in.readLine()) != null ){
				result = tmp;
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (result == "")
			return 0;
		
		int i1 = result.indexOf("[") + 1;
		int i2 = result.indexOf("%");
		result = result.substring(i1, i2);
		
		return Integer.parseInt(result);
	}

}
