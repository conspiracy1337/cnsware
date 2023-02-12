package CheatLoader;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.*;

public class AudioPlayer {
	
	public static void playInject()
			throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		URL injectaudio = AudioPlayer.class.getResource("/CheatLoader/inject.wav");
		AudioInputStream buttonStream = AudioSystem.getAudioInputStream(injectaudio);
		Clip injectfct = AudioSystem.getClip();
		injectfct.open(buttonStream);
		injectfct.start();
	}

	public static void playInjected()
			throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		URL injectedaudio = AudioPlayer.class.getResource("/CheatLoader/injected.wav");
		AudioInputStream injectStream = AudioSystem.getAudioInputStream(injectedaudio);
		Clip injectedfct = AudioSystem.getClip();
		injectedfct.open(injectStream);
		injectedfct.start();
	}

	public static void playButton()
			throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		URL buttonaudio = AudioPlayer.class.getResource("/CheatLoader/button.wav");
		AudioInputStream buttonStream = AudioSystem.getAudioInputStream(buttonaudio);
		Clip buttonfct = AudioSystem.getClip();
		buttonfct.open(buttonStream);
		buttonfct.start();
	}

}
