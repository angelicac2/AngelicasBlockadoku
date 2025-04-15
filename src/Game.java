public class Game {
    public static final int WELCOME = 0;
    public static final int INSTRUCTIONS = 1;
    public static final int PLAYING = 2;
    private static int state = 0;
    private GameView frontend;
    private Player player;
    private Board board;
    private Block block;


    public Game() {
        frontend = new GameView(this);
    }
}
