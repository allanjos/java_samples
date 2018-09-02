import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlayAudioFile {
    private static Clip clip = null;

    public static void main(String args[]) {
        System.out.println("Play audio file");

        for (int i = 0; i < 5; i++) {
            // Play audio in a separate thread

            playAudio("audio.wav");

            // Wait some time playing the audio

            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                System.err.println("Error: " + e.toString());
            }

            // Stop audio

            stopAudio();

            // Wait some time playing the audio

            try {
                Thread.sleep(200);
            }
            catch (InterruptedException e) {
                System.err.println("Error: " + e.toString());
            }
        }
    }

    public static synchronized void playAudio(final String url) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    PlayAudioFile.clip = AudioSystem.getClip();

                    InputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(url));

                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(bufferedInputStream);

                    PlayAudioFile.clip.open(inputStream);

                    PlayAudioFile.clip.start();
                }
                catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }

    public static synchronized void stopAudio() {
        clip.stop();
    }
}