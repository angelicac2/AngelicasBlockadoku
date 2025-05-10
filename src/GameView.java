import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {
    private final int WINDOW_HEIGHT = 953;
    private final int WINDOW_WIDTH = 1469;
    private Image titlePage;
    private Image instructions;
    private Image play;
    private Image endPage;
    private Image arrow;
    private Game backend;

    public GameView(Game backend) {
        this.backend = backend;
        titlePage = new ImageIcon("Resources/openingPage.png").getImage();
        instructions = new ImageIcon("Resources/instructionsPage.png").getImage();
        endPage = new ImageIcon("Resources/endPage.png").getImage();
        play = new ImageIcon("Resources/game.png").getImage();
        arrow = new ImageIcon("Resources/arrow.png").getImage();
        // Pass in backend into frontend constructor
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Angelica's Blockadoku");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        System.out.println("GameView constructor: backend.randomShapes size: " + backend.random().size()); // ADD THIS
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        System.out.println("GameView paint() called. backend.randomShapes size: " + backend.random().size());
        if (backend.getState() == 0) {
            g.drawImage(titlePage, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT,this);
        }
        if (backend.getState() == 1) {
            g.drawImage(instructions, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
            g.drawImage(arrow, 40, 45,  110, 100, this);
        }
        if (backend.getState() == 2) {
            g.drawImage(play, 0, 0, WINDOW_WIDTH,WINDOW_HEIGHT,this);
            drawBoard(g);
            for (int i = 0; i < backend.random().size(); i++) {
                drawRandomBlock(g, i);
            }
            drawScore(g);
            gameOver(g);
        }
        if (backend.getState() == 3) {
            g.drawImage(endPage, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        }
    }


    // Draws the original 9x9 board, also fills each board when shape is dragged into it
    public void drawBoard(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setFont(new Font("Algerian", Font.BOLD, 30));
        g.drawString("points: ", 1100, 120);
        g.drawString(String.valueOf(backend.getPoints()), 1220, 120);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!backend.boardState()[j][i]) {
                    g.setColor(Color.BLACK);
                    g.drawRect(500 + i * 50, 200 + j * 50, 50, 50);
                }
                if (backend.boardState()[j][i]) {
                    g.setColor(Color.BLUE);
                    g.fillRect(500 + i * 50, 200 + j * 50, 50, 50);
                    g.setColor(Color.BLACK);
                    g.drawRect(500 + i * 50, 200 + j * 50, 50, 50);
                }
            }
        }
        // Looked online to learn how to use g2d, set stroke, and basic stroke;
        // to make lines different boldness
        g2d.setStroke(new BasicStroke(3));
        for (int i = 0; i <= 9; i += 3) {
            g.drawLine(500, 200 + i * 50, 950, i * 50 + 200);
        }
        for (int j = 0; j <= 9; j += 3) {
            g.drawLine(500 + j * 50, 200, j * 50 + 500, 650);
        }
        g2d.setStroke(new BasicStroke(1));
    }

    // Generates three random blocks and puts them at the bottom of the screen for user
    public void drawRandomBlock(Graphics g, int increment) {
        Shape currentShape = backend.random().get(increment);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (backend.getCurrentShape(increment)[i][j]) {
                    int drawX = currentShape.x + j * 50;
                    int drawY = currentShape.y + i * 50;
                    g.setColor(Color.black);
                    g.drawRect(drawX, drawY, 50, 50);
                    g.setColor(Color.blue);
                    g.fillRect(drawX, drawY, 50, 50);
                }
            }
        }
        // Constantly changing the position of shape when it is being dragged
        if (backend.getSetDragged() == 1) {
            backend.getClickedShape().reDraw(g);
        }
    }


    // If a row, box, or column has been cleared, set the square back to white (unfilled)
    public void drawScore(Graphics g) {
        boolean valid = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (backend.checkRowWin()) {
                    if (!backend.boardState()[i][j]) {
                        valid = false;
                    }
                }
                if (backend.checkColWin()) {
                    if (!backend.boardState()[i][j]) {
                        valid = false;
                    }
                }
                if (backend.checkBoxWin()) {
                    if (!backend.boardState()[i][j]) {
                        valid = false;
                    }
                }
                if (!valid) {
                    g.setColor(Color.white);
                    g.fillRect(500 + i * 50, 200 + j * 50, 50, 50);
                }
                // Update points for user
                g.setColor(Color.black);
                g.setFont(new Font("Algerian", Font.BOLD, 30));
                g.drawString(String.valueOf(backend.getPoints()), 1220, 120);
            }
        }
    }

    // When the user loses the game, immediately switch to game user screen
    public void gameOver(Graphics g) {
        if (backend.gameOver()) {
            g.setColor(Color.white);
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        }
        g.setColor(Color.black);
        g.setFont(new Font("Algerian", Font.BOLD, 30));
        g.drawString(String.valueOf(backend.getPoints()), 1220, 120);
    }
}