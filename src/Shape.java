import java.util.ArrayList;

public class Shape {
    private boolean[][] shape1;
    private boolean[][] shape2;
    private boolean[][] shape3;
    private boolean[][] shape4;
    private boolean[][] shape5;
    private boolean[][] shape6;
    private boolean[][] shape7;
    private boolean[][] shape8;
    private boolean[][] shape9;
    private boolean[][] shape10;
    private boolean[][] shape11;
    private boolean[][] shape12;
    private ArrayList<boolean[][]> generateShape;

    public Shape() {
        generateShape = new ArrayList<>();
        makeShape1();
        makeShape2();
        makeShape3();
        makeShape4();
        makeShape5();
        makeShape6();
    }

    public void makeShape1() {
        shape1 = new boolean[][]{
                {true, true, true, false, false},
                {false, true, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        generateShape.add(shape1);
    }
    public void makeShape2() {
        shape2 = new boolean[][]{
                {true, false, false, false, false},
                {true, true, false, false, false},
                {true, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        generateShape.add(shape2);
    }
    public void makeShape3() {
        shape3 = new boolean[][]{
                {false, true, false, false, false},
                {true, true, false, false, false},
                {false, true, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        generateShape.add(shape3);
    }
    public void makeShape4() {
        shape4 = new boolean[][]{
                {false, true, false, false, false},
                {true, true, true, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        generateShape.add(shape4);
    }
    public void makeShape5() {
        shape5 = new boolean[][]{
                {false, true, false, false, false},
                {true, true, false, false, false},
                {true, false, false, false, false},
                {true, false, false, false, false},
                {false, false, false, false, false}
        };
        generateShape.add(shape5);
    }
    public void makeShape6() {
        shape6 = new boolean[][]{
                {true, false, false, false, false},
                {true, true, false, false, false},
                {false, true, false, false, false},
                {false, true, false, false, false},
                {false, false, false, false, false}
        };
        generateShape.add(shape6);
    }

    public boolean[][] randomShape() {
        int random = (int)(Math.random() * generateShape.size());
        return generateShape.get(random);
    }
}
