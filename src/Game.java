import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Game implements MouseListener, MouseMotionListener {
    public static final int WELCOME = 0;
    public static final int INSTRUCTIONS = 1;
    public static final int PLAYING = 2;
    private final int pointsIncrement = 9;
    private static int state = 0;
    private GameView frontend;
    private Board board;
    private ShapeManager shapeManager;
    private Shape shape;
    private int points = 0;
    private boolean status = false;
    private int clickNum;
    private int playButton = 20;

    public Game() {
        board = new Board(200, 200);
        this.shapeManager = new ShapeManager();
        frontend = new GameView(this);
        frontend.repaint();
        this.frontend.addMouseListener(this);
        this.frontend.addMouseMotionListener(this);
        this.clickNum = 0;
    }

    // main function for playing the game; true if user wins, false if user loses
    public boolean playGame() {
        return true;
    }

    public int getState() {
        return state;
    }

    public int getPlayButton() {
        return playButton;
    }

    public void mousePressed(MouseEvent e) {

        // For demo purposes only
        System.out.println("mousePressed event handler executed.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // For demo purposes only
        System.out.println("mouseReleased event handler executed.");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // For demo purposes only
        System.out.printf("mouseClicked event handler executed for click number: %d\n", clickNum);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // For demo purposes only
        System.out.println("mouseEntered event handler executed.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // For demo purposes only
        System.out.println("mouseExited event handler executed.");
    }

    /********************************************
     MouseListener event handlers - END
     ********************************************/

    /********************************************
     MouseMotionListener event handlers - BEGIN
     ********************************************/


    @Override

    public void mouseDragged(MouseEvent e) {
        // Have the ball follow the dragging mouse
        // Print to terminal for demo purposes only
        System.out.println("\t\t\texecuting mouseDragged event handler");

        // Ask the input event the current location (x and y position on the Frame) of the mouse
        int x = e.getX();
        int y = e.getY();

        // Check for each shape
        shape = new Shape(shapeManager.numShapes());

        for (int i = 1; i < 4; i++) {
            if (shape.isClicked(x, y)) {
                // Move the ball and repaint.
                shape.setCenter(x, y);
            }
        }
        // If the ball is clicked
        if (shape.isClicked(x, y)) {
            // Move the ball and repaint.
            shape.setCenter(x, y);
        }
        frontend.repaint();
    }



    @Override
    public void mouseMoved(MouseEvent e) {
        // For demo purposes only
        System.out.println("\t\t\texecuting mouseMoved event handler");
    }


    public boolean[][] getShape() {
        //frontend.repaint();
        return shapeManager.randomShape();
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
