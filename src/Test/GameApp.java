package Test;

import Utils.MusicUtils;

public class GameApp {
    public static void main(String[] args) {
        MusicUtils music = new MusicUtils(".\\music\\test.WAV");
        music.start();
        @SuppressWarnings("unused")
        int musicOpenLab = 1;
    }
}
