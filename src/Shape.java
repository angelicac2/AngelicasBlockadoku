import java.awt.*;

public class Shape {
    private boolean[][] squares;
    int x;
    int y;
    private int iteration = 1;
    private int shapeLength;
    private int shapeWidth;
    private int squareSize = 50;
    int blockX;
    int blockY;



    public Shape(int n) {
        if (n == 1) {
            squares = ShapeManager.makeShape1();
        }
        if (n == 2) {
            squares = ShapeManager.makeShape2();
        }
        if (n == 3) {
            squares = ShapeManager.makeShape3();
        }
        if (n == 4) {
            squares = ShapeManager.makeShape4();
        }
        if (n == 5) {
            squares = ShapeManager.makeShape5();
        }
        if (n == 6) {
            squares = ShapeManager.makeShape6();
        }
    }

    public boolean[][] getSquares() {
        return squares;

    }


    public boolean isClicked(int mouseX, int mouseY) {
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[0].length; j++) {
                if (squares[i][j]) {
                    // Calculate the top-left corner
                    blockX = this.x + (j - shapeWidth / 2) * squareSize;
                    blockY = this.y + (i - shapeLength / 2) * squareSize;

                    // Check if the mouse click is within the bounds of this block
                    if (mouseX >= blockX && mouseX < blockX + squareSize && mouseY >= blockY && mouseY < blockY + squareSize) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int getLeftX() {
        return blockX;
    }

    public int getLeftY() {
        return blockY;
    }

    public void reDraw(Graphics g, int increment, int iteration, Game backend) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (squares[i][j] == true) {
                    g.setColor(Color.black);
                    g.drawRect((iteration * 200) + (i * 50 + 300) + (x + j * 50), j * 50 + 720 + (x + i * 50), 50, 50);
                    g.setColor(Color.blue);
                    g.fillRect((iteration * 200) + (i * 50 + 300) + (x + j * 50), j * 50 + 720 + (x + i * 50), 50, 50);
                }
            }
        }
    }
}
