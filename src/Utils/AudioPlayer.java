package Utils;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioPlayer {
    private SourceDataLine line;

    public void play(String filePath, boolean loop) {
        new Thread(() -> {
            try {
                File audioFile = new File(filePath);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                AudioFormat format = audioStream.getFormat();
                DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
                line = (SourceDataLine) AudioSystem.getLine(info);
                line.open(format);
                line.start();

                byte[] buffer = new byte[4096];
                int bytesRead;

                do {
                    while ((bytesRead = audioStream.read(buffer)) != -1) {
                        line.write(buffer, 0, bytesRead);
                    }
                    audioStream = AudioSystem.getAudioInputStream(audioFile); // 重置流
                } while (loop);

                line.drain();
                line.close();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void stop() {
        if (line != null && line.isRunning()) {
            line.stop();
            line.close();
        }
    }
}
