package Test;

import Utils.MusicUtils;

public class TestMain {
    private static MusicUtils musicPlayer;
    public static void main(String[] args) {
        GameApp ga = new GameApp();
        ga.initFrame();
        musicPlayer = new MusicUtils(".\\music\\bgMusic.WAV");
        musicPlayer.start();
    }
}
