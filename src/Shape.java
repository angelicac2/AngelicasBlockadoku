public class Shape {
    private boolean[][] squares;
    int x;
    int y;
    private int iteration = 1;
    private int shapeLength;
    private int shapeWidth;


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

    public void setCenter(int xIn, int yIn) {
        x = xIn;
        y = yIn;
    }


    public int getShapeLength() {
        return squares.length;
    }

    public int getShapeWidth() {
        return squares[0].length;
    }

    public boolean isClicked(int x, int y) {
        double dx = 0;
        double dy = 0;
        if (getShapeLength() < x && getShapeWidth() < y) {
            dx = (this.x - x) * (this.x - x);
            dy = (this.y - y) * (this.y - y);
        }
        return Math.sqrt(dx + dy) <= squares.length;
    }

}
