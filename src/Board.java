public class Board {
    private boolean filledStatus;
    Block [][] board;
    private final int height = 27;
    private final int width = 27;
    private int x;
    private int y;


    public Board(int x, int y) {
        this.x = x;
        this.y = y;
        filledStatus = false;
    }

    public boolean isFilled() {
        return true;
    }

    // is there space for the block to be played on the board at all?
    public boolean isSpace() {
        return true;
    }

    // Where the player specifically wants to play
    public boolean isValid() {
        return true;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

}
