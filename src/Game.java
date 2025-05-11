import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Game implements MouseListener, MouseMotionListener, ActionListener {
    private static final int DELAY = 50;
    private final int pointsIncrement = 9;
    private static int state = 0;
    private GameView frontend;
    private Board board;
    private ShapeManager shapeManager;
    private int points = 0;
    private int clickNum;
    private Shape clickedShape = null;
    private ArrayList<Shape> randomShapes;
    private boolean[][] oneShape;
    boolean[][] shapeSquares;
    private int setDragged = 0;
    private int x;
    private int y;
    private Timer clock;
    private int clickX = 0;
    private int clickY = 0;
    private boolean shapeThere = false;
    private int pressedX = 0;
    private int pressedY = 0;
    private boolean rowStatus;
    private boolean colStatus;
    private boolean[][] copy = new boolean[9][9];
    private int numBox;
    private int numRow;
    private int numCol;
    private boolean boxStatus;



    public Game() {
        board = new Board();
        this.shapeManager = new ShapeManager();
        randomShapes = new ArrayList<>();
        currentShapes();
        frontend = new GameView(this);
        this.frontend.addMouseListener(this);
        this.frontend.addMouseMotionListener(this);
        this.clickNum = 0;
        clock = new Timer(DELAY, this);
        clock.start();
    }

    // Generates three shapes after every round user plays
    public void currentShapes() {
        for (int i = 0; i < 3; i++) {
            // Take random index from backend to generate random block
            int shapeIndex = shapeManager.randomNum();
            System.out.println("SHAPE INDEX " + shapeIndex);
            // Creates a random block from random index
            Shape newShape = new Shape(shapeIndex);
            // Where random shapes originate
            int topLeftX = (i + 1) * 300 + 95;
            int topLeftY = 690;
            newShape.x = topLeftX;
            newShape.y = topLeftY;
            randomShapes.add(newShape);
        }
    }

    public void mousePressed(MouseEvent e) {
        clickedShape = null;
        int x = e.getX();
        int y = e.getY();

        // When user is at home page
        if (state == 0) {
            // When user presses play, reset board, points generate shapes??
            if (x > 100 && x < 700 && y > 450 && y < 660) {
                points = 0;
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        board.getBoard()[i][j] = false;
                        copy[i][j] = false;
                    }
                }
                state = 2;
                frontend.repaint();
            }
            if (x > 100 && x < 700 && y > 700 && y < 900) {
                state = 1;
                frontend.repaint();
            }
        }
        // When user is at instructions page
        if (state == 1) {
            if (x > 20 && x < 180 && y > 70 && y < 160) {
                state = 0;
            }
        }
        // When user is at gameOver page
        if (state == 3) {
            if (x > 550 && x < 875 && y > 630 && y < 790) {
                state = 0;
                randomShapes = new ArrayList<Shape>();
                currentShapes();
                frontend.repaint();
            }
        }

        // Iterate to see if a shape is overlapping
        for (int i = randomShapes.size() - 1; i >= 0; i--) {
            Shape a = randomShapes.get(i);
            if (a.isClicked(x, y)) {
                clickedShape = a;
                // Location of where the shape was originally at
                pressedX = clickedShape.x;
                pressedY = clickedShape.y;
                // Update position of the clicked shape by calculating offset
                clickedShape.x = x -  clickX;
                clickedShape.y = y -  clickY;
                break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (clickedShape != null) {
            this.x = clickedShape.x;
            this.y = clickedShape.y;
            // Calculate position of nearest grid cell by adding half cell size before division so it rounds correctly
            int cellX = (this.y - 200 + 50 / 2) / 50;
            int cellY = (this.x - 500 + 50 / 2) / 50;
            // Top left corner of new cell that the shape will be snapped into
            int snappedX = 500 + cellY * 50;
            int snappedY = 200 + cellX * 50;
            // Snap shape into position
            clickedShape.x = snappedX;
            clickedShape.y = snappedY;
            if (validPlacement()) {
                fillWithShape();
                // If the placement of the shape is valid, remove it from the generating array
                randomShapes.remove(clickedShape);
                // Reload generated shapes if all shapes have been placed on board
                if (randomShapes.isEmpty()) {
                    currentShapes();
                }

            }
            if (!validPlacement()) {
                if (shapeThere) {
                    clickedShape.x = pressedX;
                    clickedShape.y = pressedY;
                }
            }
            clickedShape = null;
            setDragged = 0;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Ask the input event the current location (x and y position on the Frame) of the mouse
        int x = e.getX();
        int y = e.getY();

        if (clickedShape != null) {
            setDragged = 1;
            clickedShape.x = x;
            clickedShape.y = y;
        }
    }

    // Getting a shape from arrayList to draw on board
    public boolean[][] getCurrentShape(int i) {
        if (randomShapes != null && i >= 0 && i < randomShapes.size()) {
            oneShape = randomShapes.get(i).getSquares();
            return oneShape;
        }
        else {
            return null;
        }
    }

    public ArrayList<Shape> random() {
        return randomShapes;
    }

    public Shape getClickedShape() {
        return clickedShape;
    }

    public int getState() {
        return state;
    }

    // In order for the shape to fill the board, the board's square needs to be true
    public void fillWithShape() {
        shapeSquares = clickedShape.getSquares();
        // Calculate the board cell corresponding to the top left corner of shape
        int boardRow = (clickedShape.y - 200) / 50;
        int boardCol = (clickedShape.x - 500) / 50;

        for (int i = 0; i < shapeSquares.length; i++) {
            for (int j = 0; j < shapeSquares[0].length; j++) {
                if (shapeSquares[i][j]) {
                    // Positions of the rest of the board cells with this block
                    int newRow = boardRow + i;
                    int newCol = boardCol + j;
                    board.getBoard()[newRow][newCol] = true;
                }
            }
        }
        checkAllWins();
    }

    // The two checking conditions that make the shape valid, checking is using the same board indexes in fillShape()
    public boolean validPlacement() {
        if (clickedShape == null) {
            return false;
        }
        shapeSquares = clickedShape.getSquares();
        int boardRow = (clickedShape.y - 200) / 50;
        int boardCol = (clickedShape.x - 500) / 50;

        for (int i = 0; i < shapeSquares.length; i++) {
            for (int j = 0; j < shapeSquares[0].length; j++) {
                if (shapeSquares[i][j]) {
                    int newRow = boardRow + i;
                    int newCol = boardCol + j;

                    // Is this block out of the board's boundaries
                    if (newRow < 0 || newRow >= 9 || newCol < 0 || newCol >= 9) {
                        shapeThere = true;
                        return false;
                    }
                    // Are the potential cells already occupied
                    if (board.getBoard()[newRow][newCol]) {
                        shapeThere = true;
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int getSetDragged() {
        return setDragged;
    }

    public boolean[][] boardState() {
        return board.getBoard();
    }

    public void checkRowWin() {
        for (int i = 0; i < board.getBoard().length; i++) {
            boolean rowFull = true;
            for (int j = 0; j < board.getBoard()[0].length; j++) {
                // If board cell has not been occupied, no clear
                if (!board.getBoard()[i][j]) {
                    rowFull = false;
                    break;
                }
            }
            // Passing the inner for-loop means looking through a whole row, it has cleared!
            if (rowFull) {
                // Increment the number of rows being cleared to update points
                numRow++;
                // Don't set block to false yet, wait for other checks to complete to clear
                for (int k = 0; k < board.getBoard()[0].length; k++) {
                    copy[i][k] = true;
                }
                this.rowStatus = true;
            }
        }
    }

    // Same code as the rowWin, except checking cell in a column
    public void checkColWin() {
        for (int j = 0; j < board.getBoard()[0].length; j++) {
            boolean colFull = true;
            for (int i = 0; i < board.getBoard().length; i++) {
                if (!board.getBoard()[i][j]) {
                    colFull = false;
                    break;
                }
            }
            if (colFull) {
                numCol++;
                for (int k = 0; k < board.getBoard().length; k++) {
                    copy[k][j] = true;
                }
                this.colStatus = true;
            }
        }
    }

    public void checkBoxWin() {
        // Checks for three specific 3x3 boxes in each row starting from [0][0]
        for (int a = 0; a <= board.getBoard().length - 3; a += 3) {
            for (int b = 0; b <= board.getBoard().length - 3; b += 3) {
                boolean boxFull = true;
                // Inside the specific box, check if any of the 9 cells are empty
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int boxRow = a + i;
                        int boxCol = b + j;
                        // When box can't be cleared, stop checking for it
                        if (!board.getBoard()[boxRow][boxCol]) {
                            boxFull = false;
                            break;
                        }
                    }
                    if (!boxFull) {
                        break;
                    }
                }
                if (boxFull) {
                    numBox++;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            int rowClear = a + i;
                            int colClear = b + j;
                            copy[rowClear][colClear] = true;
                        }
                    }
                    this.boxStatus = true;
                }
            }
        }
    }

    // Set original board blocks to false on the ones can be cleared at the same time
    public void clearAll() {
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                if(copy[i][j]) {
                    if (board.getBoard()[i][j]) {
                        board.getBoard()[i][j] = false;
                    }
                }
            }
        }
        points += (pointsIncrement * (numBox + numCol + numRow));
    }

    // Check all three cases, clear all possible cases at the same time
    public void checkAllWins() {
        // Set the number of things cleared back each time a new thing is cleared
        copy = new boolean[board.getBoard().length][board.getBoard()[0].length];
        numRow = 0;
        numCol = 0;
        numBox = 0;
        rowStatus = false;
        colStatus = false;
        boxStatus = false;
        checkBoxWin();
        checkColWin();
        checkRowWin();
        if (rowStatus || colStatus || boxStatus) {
            clearAll();
            frontend.repaint();
        }
    }

    public int getPoints() {
        return points;
    }

    public boolean[][] getCopyBoard() {
        return copy;
    }

    // Same formula as isValid placement but instead with shapes (not clickedShape)
    // Tried to use one method with parameters but it didn't work
    public boolean canPlace(Shape shape, int x, int y) {
        if (shape == null) {
            return false;
        }
        shapeSquares = shape.getSquares();
        int boardRow = (x - 500) / 50;
        int boardCol = (y - 200) / 50;

        for (int i = 0; i < shapeSquares.length; i++) {
            for (int j = 0; j < shapeSquares[0].length; j++) {
                if (shapeSquares[i][j]) {
                    int newRow = boardRow + i;
                    int newCol = boardCol + j;
                    if (newRow < 0 || newRow >= 9 || newRow < 0 || newCol >= 9) {
                        return false;
                    }
                    if (board.getBoard()[newRow][newCol]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // Constantly checking if generated shapes are able to be placed on the board
    public boolean gameOver() {
        // Go through each generate shape, not just each clicked shape
        for (Shape shape : randomShapes) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    // Get origin of each cell of shape, compare it to cells on board
                    int lookX = 500 + j * 50;
                    int lookY = 200 + i * 50;
                    if (canPlace(shape, lookX, lookY)) {
                        return false;
                    }
                }
            }
        }
        // Switch to losing page if gameOver is true
        state = 3;
        frontend.repaint();
        return true;
    }

    public static void main(String[] args) {
        Game g = new Game();
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
    @Override
    public void actionPerformed(ActionEvent e) {
        frontend.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
    }

}
