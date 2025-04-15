import java.util.ArrayList;

public class Block {
    private final int height = 1;
    private final int width = 1;
    private ArrayList<Block> gameBLocks;
    private Block boardBlock;
    private Block randomBlock;


    // if you call block, what do you want it to do?
    public Block() {

    }

    public Block getRandomBlock() {
        // generated random block
        return randomBlock;
    }

    public Block getDefaultBlock() {
        // return default board block
        return boardBlock;
    }
}
