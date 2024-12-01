package Utils;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class MusicUtils extends Thread {
    private String fileName;
    private final int EXTERNAL_BUFFER_SIZE = 520888; // 缓冲区大小
    private boolean isPlaying = true; // 控制播放状态

    public MusicUtils(String wavFile) {
        this.fileName = wavFile;
    }

    public void stopMusic() {
        isPlaying = false;
    }

    @Override
    public void run() {
        File soundFile = new File(fileName);
        if (!soundFile.exists()) {
            System.err.println("Wave file not found: " + fileName);
            return;
        }

        while (isPlaying) {
            try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile)) {
                AudioFormat format = audioInputStream.getFormat();
                DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
                try (SourceDataLine auline = (SourceDataLine) AudioSystem.getLine(info)) {
                    auline.open(format);
                    auline.start();

                    byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
                    int nBytesRead;
                    while (isPlaying && (nBytesRead = audioInputStream.read(abData, 0, abData.length)) != -1) {
                        auline.write(abData, 0, nBytesRead);
                    }

                    auline.drain();
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                    return;
                }
            } catch (UnsupportedAudioFileException | IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
