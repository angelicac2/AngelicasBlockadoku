public class Board {
    private boolean filledStatus;
    boolean[][] board;
    private final int height = 9;
    private final int width = 9;
    private int x;
    private int y;
    private Game backend;

    public Board() {
        board = new boolean[height][width];
        filledStatus = false;
        fillBoard();
    }

    public boolean[][] fillBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = false;
            }
        }
        return board;
    }

    public boolean[][] getBoard() {
        return board;
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
