import java.util.ArrayList;

public class ShapeManager {
    // Instance Variables
    private int x;              // Center x
    private int y;              // Center y
    private int dx;             // delta x in one time unit
    private int dy;             // delta y in one time unit
    private static boolean[][] shape1;
    private static boolean[][] shape2;
    private static boolean[][] shape3;
    private static boolean[][] shape4;
    private static boolean[][] shape5;
    private static boolean[][] shape6;
    private boolean[][] shape7;
    private boolean[][] shape8;
    private boolean[][] shape9;
    private boolean[][] shape10;
    private boolean[][] shape11;
    private boolean[][] shape12;
    private static ArrayList<boolean[][]> generateShape;


    public ShapeManager() {
        generateShape = new ArrayList<>();
        makeShape1();
        makeShape2();
        makeShape3();
        makeShape4();
        makeShape5();
        makeShape6();
    }

    public static boolean[][] makeShape1() {
        shape1 = new boolean[][]{
                {true, true, true, false, false},
                {false, true, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        generateShape.add(shape1);
        return shape1;
    }

    public static boolean[][] makeShape2() {
        shape2 = new boolean[][]{
                {true, false, false, false, false},
                {true, true, false, false, false},
                {true, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        generateShape.add(shape2);
        return shape2;
    }
    public static boolean[][] makeShape3() {
        shape3 = new boolean[][]{
                {false, true, false, false, false},
                {true, true, false, false, false},
                {false, true, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        generateShape.add(shape3);
        return shape3;
    }
    public static boolean[][] makeShape4() {
        shape4 = new boolean[][]{
                {false, true, false, false, false},
                {true, true, true, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        generateShape.add(shape4);
        return shape4;
    }
    public static boolean[][] makeShape5() {
        shape5 = new boolean[][]{
                {false, true, false, false, false},
                {true, true, false, false, false},
                {true, false, false, false, false},
                {true, false, false, false, false},
                {false, false, false, false, false}
        };
        generateShape.add(shape5);
        return shape5;
    }
    public static boolean[][] makeShape6() {
        shape6 = new boolean[][]{
                {true, false, false, false, false},
                {true, true, false, false, false},
                {false, true, false, false, false},
                {false, true, false, false, false},
                {false, false, false, false, false}
        };
        generateShape.add(shape6);
        return shape6;
    }

    public boolean[][] randomShape() {
        int random = (int)(Math.random() * generateShape.size());
        return generateShape.get(random);
    }

    public int numShapes() {
        return generateShape.size();
    }
}
