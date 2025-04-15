import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {
    private int WINDOW_HEIGHT = 800;
    private int WINDOW_WIDTH = 1000;
    private Image titlePage;
    private Image instructions;
    private Image play;
    private Game backend;

    public GameView(Game backend) {
        titlePage = new ImageIcon("Resources/titlepage.png").getImage();
        instructions = new ImageIcon("Resources/instructions.png").getImage();
        play = new ImageIcon("Resources/defaultscorepage.png").getImage();
        // Pass in backend into frontend constructor
        this.backend = backend;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Angelica's Blockadoku");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);

    }
}
