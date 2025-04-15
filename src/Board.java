public class Board {
    private boolean isFilled;
    Block [][] board;
    private final int height = 27;
    private final int width = 27;
    private int x;
    private int y;


    public Board(int x, int y) {
        this.x = x;
        this.y = y;
        isFilled = false;
    }
}
