import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Game {
    public static final int WELCOME = 0;
    public static final int INSTRUCTIONS = 1;
    public static final int PLAYING = 2;
    private final int pointsIncrement = 9;
    private static int state = 0;
    private GameView frontend;
    private Board board;
    private Shape shape;
    private int points = 0;
    private boolean status = false;



    public Game() {
        board = new Board(200, 200);
        shape = new Shape();
        frontend = new GameView(this);
        frontend.repaint();
    }

    // main function for playing the game; true if user wins, false if user loses
    public boolean playGame() {
        return true;
    }

    public int getState() {
        return state;
    }

    public void switchToInstructions() {

    }

    public void switchToGame(MouseEvent e) {
        if (e.getX() > 98 && e.getX() < 660 && e.getY() < 953 && e.getY() < 661) {
            state = INSTRUCTIONS;
        }
    }

    public boolean[][] getShape() {
        //frontend.repaint();
        return shape.randomShape();
    }

    public boolean[][] getBoard() {
        return board.fillBoard();
    }

    public boolean checkRowWin() {
        for (int i = 0; i < getBoard().length; i++) {
            for (int j = 0; j < getBoard()[0].length; j++) {
                if (getBoard()[i][j] == true) {
                    points += pointsIncrement;
                    status = true;
                }
            }
        }
        return status;
    }

    public boolean checkColWin() {
        for (int i = 0; i < getBoard().length; i++) {
            for (int j = 0; j < 9; j++) {
                if (getBoard()[i][j] == true) {
                    points += pointsIncrement;
                    status = true;
                }
            }
        }
        return status;
    }

    public boolean checkBoxWin() {
        return true;
    }

    public boolean regenerateBlocks() {
        // if user has placed all three blocks on board
        return true;
    }
}
