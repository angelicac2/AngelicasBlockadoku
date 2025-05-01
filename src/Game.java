import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.SQLOutput;
import java.util.ArrayList;

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
    private Shape clickedShape = null;
    private ArrayList<Shape> randomShapes = new ArrayList<>();
    private int dragOffsetX;
    private int dragOffsetY;
    private boolean[][] oneShape;
    private int prevX;
    private int prevY;

    public Game() {
        board = new Board();
        this.shapeManager = new ShapeManager();
        //randomShapes = new ArrayList<Shape>();
        currentShapes();
        frontend = new GameView(this);
        //frontend.repaint();
        this.frontend.addMouseListener(this);
        this.frontend.addMouseMotionListener(this);
        this.clickNum = 0;

        frontend.repaint();
    }

    public void currentShapes() {
        randomShapes.clear();
        for (int i = 0; i < 3; i++) {
            int shapeIndex = shapeManager.randomShapeIndex();
            Shape newShape = new Shape(shapeIndex);
            newShape.setCenter((i + 1) * 200 + (5 * 50 / 2 + 300), (5 * 50 / 2 + 720));
            randomShapes.add(newShape);
        }
        //frontend.repaint();
    }

    public ArrayList<Shape> random() {
        return randomShapes;
    }

    public boolean[][] getCurrentShape(int i) {
        if (randomShapes != null) {
            oneShape = randomShapes.get(i).getSquares();
            return oneShape;
        }
        else {
            return null;
        }
    }

    public Shape getClickedShape() {
        return clickedShape;
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
        clickedShape = null;
        int x = e.getX();
        int y = e.getY();
        for (Shape a : randomShapes) {
            if (a.isClicked(x, y)) {
                prevX = x;
                prevY = y;
                clickedShape = a;
                break;
            }
        }
        // For demo purposes only
        System.out.println("mousePressed event handler executed.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // For demo purposes only
        System.out.println("mouseReleased event handler executed.");
        clickedShape = null;
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

        int dx = x - prevX;
        int dy = y - prevY;


        // If the ball is clicked

        if (clickedShape != null) {
            // Update x and y.
            frontend.repaint();
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // For demo purposes only
        System.out.println("\t\t\texecuting mouseMoved event handler");
        int x = e.getX();
        int y = e.getY();
    }



    public boolean[][] getShape() {
        return shape.getSquares();
    }



    public boolean[][] getBoard() {
        frontend.repaint();
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
    public static void main(String[] args) {
        Game g = new Game();
    }
}
