import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {
    private final int WINDOW_HEIGHT = 953;
    private final int WINDOW_WIDTH = 1469;
    private Image titlePage;
    private Image instructions;
    private Image play;
    private Game backend;

    public GameView(Game backend) {
        titlePage = new ImageIcon("Resources/openingPage.png").getImage();
        instructions = new ImageIcon("Resources/instructionsPage.png").getImage();
        play = new ImageIcon("Resources/game.png").getImage();
        // Pass in backend into frontend constructor
        this.backend = backend;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Angelica's Blockadoku");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        g.drawImage(play, 0, 0, WINDOW_WIDTH,WINDOW_HEIGHT,this);
        if (backend.getState() == 1) {
            g.drawImage(instructions, 0, 0, WINDOW_WIDTH,WINDOW_HEIGHT, this);
        }
        drawBoard(g);
        for (int i = 1; i <= 3; i++) {
            drawRandomBlock(g, i);
        }
    }

    public void drawBoard(Graphics g) {
        //g.drawRect( 100, 100, backend.getBlock().getBlockHeight(), backend.getBlock().getBlockWidth());
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                g.drawRect( 500 + i * 50, 200 + j * 50, 50, 50);
            }
        }
    }

    public void drawRandomBlock(Graphics g, int interation) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (backend.getShape()[i][j] == true) {
                    g.setColor(Color.black);
                    g.drawRect((interation * 200) + (i * 50 + 300), j * 50 + 720, 50, 50);
                    g.setColor(Color.blue);
                    g.fillRect((interation * 200) + (i * 50 + 300), j * 50 + 720, 50, 50);
                }
            }
        }
    }

    public void drawScore(Graphics g) {

    }
    public void gameOver(Graphics g) {

    }
}