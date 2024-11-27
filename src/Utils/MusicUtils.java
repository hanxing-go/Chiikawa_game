package Utils;


import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicUtils extends Thread {
    private String fileName;
    private final int EXTERNAL_BUFFER_SIZE = 520888;

    public MusicUtils(String wavFile) {
        this.fileName = wavFile;
    }

    @SuppressWarnings("unused")
    public void run() {
        File soundFile = new File(fileName); // 播放音乐的文件名
        if (!soundFile.exists()) {
            System.err.println("Wave file not found:" + fileName);
            return;
        }
        while (true) { // 设置循环播放
            AudioInputStream audioInputStream = null; // 创建音频输入流对象
            try {
                audioInputStream = AudioSystem.getAudioInputStream(soundFile); // 创建音频对象
            } catch (UnsupportedAudioFileException e1) {
                e1.printStackTrace();
                return;
            } catch (IOException e1) {
                e1.printStackTrace();
                return;
            }
            AudioFormat format = audioInputStream.getFormat(); // 音频格式
            SourceDataLine auline = null; // 源数据线
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            try {
                auline = (SourceDataLine) AudioSystem.getLine(info);
                auline.open(format);
            } catch (LineUnavailableException e) {
                e.printStackTrace();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
            if (auline.isControlSupported(FloatControl.Type.PAN)) {
                FloatControl pan = (FloatControl) auline.getControl(FloatControl.Type.PAN);
            }
            auline.start();
            int nBytesRead = 0;
            byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
            try {
                while (nBytesRead != -1) {
                    nBytesRead = audioInputStream.read(abData, 0, abData.length);
                    if (nBytesRead >= 0)
                        auline.write(abData, 0, nBytesRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            } finally {
                auline.drain();
// auline.close();
            }
        }
    }
}
