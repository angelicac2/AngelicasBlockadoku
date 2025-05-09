import java.awt.*;

public class Shape {
    private boolean[][] squares;
    int x;
    int y;
    private int squareSize = 50;
    int blockX;
    int blockY;

    public Shape(int n) {
        if (n == 1) {
            squares = ShapeManager.makeShape1();
        }
        else if (n == 2) {
            squares = ShapeManager.makeShape2();
        }
        else if (n == 3) {
            squares = ShapeManager.makeShape3();
        }
        else if (n == 4) {
            squares = ShapeManager.makeShape4();
        }
        else if (n == 5) {
            squares = ShapeManager.makeShape5();
        }
        else if (n == 6) {
            squares = ShapeManager.makeShape6();
        }
        else if (n == 7) {
            squares = ShapeManager.makeShape7();
        }
        else if (n == 8) {
            squares = ShapeManager.makeShape8();
        }
        else if (n == 9) {
            squares = ShapeManager.makeShape9();
        }
        else if (n == 10) {
            squares = ShapeManager.makeShape10();
        }
        else if (n == 11) {
            squares = ShapeManager.makeShape11();
        }
        else if (n == 12) {
            squares = ShapeManager.makeShape12();
        }
        else if (n == 13) {
            squares = ShapeManager.makeShape13();
        }
        else if (n == 14) {
            squares = ShapeManager.makeShape14();
        }
        else if (n == 15) {
            squares = ShapeManager.makeShape15();
        }
        else if (n == 16) {
            squares = ShapeManager.makeShape16();
        }
        else if (n == 17) {
            squares = ShapeManager.makeShape17();
        }
        else if (n == 18) {
            squares = ShapeManager.makeShape18();
        }
        else if (n == 19) {
            squares = ShapeManager.makeShape19();
        }
        else if (n == 20) {
            squares = ShapeManager.makeShape20();
        }
        else if (n == 21) {
            squares = ShapeManager.makeShape21();
        }
        else if (n == 22) {
            squares = ShapeManager.makeShape22();
        }
        else if (n == 23) {
            squares = ShapeManager.makeShape23();
        }
        else if (n == 24) {
            squares = ShapeManager.makeShape24();
        }
    }

    public boolean[][] getSquares() {
        return this.squares;
    }

    public boolean isClicked(int mouseX, int mouseY) {
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[0].length; j++) {
                if (squares[i][j]) {
                    // Calculate the top-left corner
                    blockX = this.x + j * squareSize;
                    blockY = this.y + i * squareSize;

                    // Check if the mouse click in bounds of block
                    if (mouseX >= blockX && mouseX < blockX + squareSize && mouseY >= blockY && mouseY < blockY + squareSize) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void reDraw(Graphics g) {
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                if (squares[i][j] == true) {
                    int drawX = this.x + j * squareSize;
                    int drawY = this.y + i * squareSize;
                    g.setColor(Color.black);
                    g.drawRect(drawX, drawY, 50, 50);
                    g.setColor(Color.blue);
                    g.fillRect(drawX, drawY, 50, 50);
                }
            }
        }
    }

}
