import Utils.MusicUtils;

public class Main {
    public static void main(String[] args) {
        GameFrame app = new GameFrame();
        Thread t1 = new Thread(app);

        MusicUtils musicPlayer = new MusicUtils(".\\music\\bgMusic.WAV");
        t1.start();
        musicPlayer.start();
    }
}