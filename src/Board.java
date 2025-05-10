public class Board {
    boolean[][] board;
    private final int height = 9;
    private final int width = 9;

    public Board() {
        board = new boolean[height][width];
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
}
