package dev.learninggame.gfx;

import java.io.File;
import javax.sound.sampled.*;

/* classe responsavel pelo som */ 

public class Som {
	
	private Clip clip;
	
	public Som(String s) {
		
        try {
            AudioInputStream ais = 
            		AudioSystem.getAudioInputStream(
            				getClass().getResourceAsStream(s));
            
            AudioFormat baseFormat = ais.getFormat();
            AudioFormat decodeFormat = new AudioFormat(
            		AudioFormat.Encoding.PCM_SIGNED,
            		baseFormat.getSampleRate(),
            		16,
            		baseFormat.getChannels(),
            		baseFormat.getChannels() * 2,
            		baseFormat.getSampleRate(),
            		false
          
            		);
            		AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais);
            		clip = AudioSystem.getClip();
            		clip.open(dais);
            		
        } catch (Exception ex) {
            System.out.println("Erro ao executar SOM!");
            ex.printStackTrace();
        }
	    
	}
	
	//metodo que da play faz o som da play
	 public void play() {
     	if(clip == null) return;
     	stop();
     	clip.setFramePosition(0);
     	clip.start();
     }
     
	 //esse para
     public void stop() {
     	if(clip.isRunning()) clip.stop();
     }
     
     public void close() {
    	 stop();
    	 clip.close();
     }
}
