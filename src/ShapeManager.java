import java.util.ArrayList;

public class ShapeManager {
    private static boolean[][] shape1;
    private static boolean[][] shape2;
    private static boolean[][] shape3;
    private static boolean[][] shape4;
    private static boolean[][] shape5;
    private static boolean[][] shape6;
    private static boolean[][] shape7;
    private static boolean[][] shape8;
    private static boolean[][] shape9;
    private static boolean[][] shape10;
    private static boolean[][] shape11;
    private static boolean[][] shape12;
    private static boolean[][] shape13;
    private static boolean[][] shape14;
    private static boolean[][] shape15;
    private static boolean[][] shape16;
    private static boolean[][] shape17;
    private static boolean[][] shape18;
    private static boolean[][] shape19;
    private static boolean[][] shape20;
    private static boolean[][] shape21;
    private static boolean[][] shape22;
    private static boolean[][] shape23;
    private static boolean[][] shape24;
    private static boolean[][] shape25;

    private static final ArrayList<boolean[][]> generateShape = new ArrayList<>();;

    static {
        makeShape1();
        makeShape2();
        makeShape3();
        makeShape4();
        makeShape5();
        makeShape6();
        makeShape7();
        makeShape8();
        makeShape9();
        makeShape10();
        makeShape11();
        makeShape12();
        makeShape13();
        makeShape14();
        makeShape15();
        makeShape16();
        makeShape17();
        makeShape18();
        makeShape19();
        makeShape20();
        makeShape21();
        makeShape22();
        makeShape23();
        makeShape24();
        addShapes();
    }

    public static boolean[][] makeShape1() {
        shape1 = new boolean[][]{
                {true, true, true, false, false},
                {false, true, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
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
        return shape4;
    }
    public static boolean[][] makeShape5() {
        shape5 = new boolean[][]{
                {false, true, false, false, false},
                {true, true, false, false, false},
                {true, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        return shape5;
    }
    public static boolean[][] makeShape6() {
        shape6 = new boolean[][]{
                {true, false, false, false, false},
                {true, true, false, false, false},
                {false, true, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        return shape6;
    }
    public static boolean[][] makeShape7() {
        shape7 = new boolean[][]{
                {true, true, false, false, false},
                {false, true, true, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        return shape7;
    }
    public static boolean[][] makeShape8() {
        shape8 = new boolean[][]{
                {false, true, true, false, false},
                {true, true, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        return shape8;
    }
    public static boolean[][] makeShape9() {
        shape9 = new boolean[][]{
                {true, true, true, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        return shape9;
    }
    public static boolean[][] makeShape10() {
        shape10 = new boolean[][]{
                {true, false, false, false, false},
                {true, false, false, false, false},
                {true, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        return shape10;
    }
    public static boolean[][] makeShape11() {
        shape11 = new boolean[][]{
                {true, true, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        return shape11;
    }

    public static boolean[][] makeShape12() {
        shape12 = new boolean[][]{
                {true, true, true, true, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        return shape12;
    }
    public static boolean[][] makeShape13() {
        shape13 = new boolean[][]{
                {true, false, false, false, false},
                {true, false, false, false, false},
                {true, false, false, false, false},
                {true, false, false, false, false},
                {false, false, false, false, false}
        };
        return shape13;
    }
    public static boolean[][] makeShape14() {
        shape14 = new boolean[][]{
                {true, true, false, false, false},
                {true, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        return shape14;
    }
    public static boolean[][] makeShape15() {
        shape15 = new boolean[][]{
                {false, true, false, false, false},
                {true, true, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        return shape15;
    }
    public static boolean[][] makeShape16() {
        shape16 = new boolean[][]{
                {true, true, false, false, false},
                {false, true, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        return shape16;
    }
    public static boolean[][] makeShape17() {
        shape17 = new boolean[][]{
                {true, false, false, false, false},
                {true, true, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        return shape17;
    }
    public static boolean[][] makeShape18() {
        shape18 = new boolean[][]{
                {true, false, false, false, false},
                {true, false, false, false, false},
                {true, true, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        return shape18;
    }
    public static boolean[][] makeShape19() {
        shape19 = new boolean[][]{
                {true, true, false, false, false},
                {false, true, false, false, false},
                {false, true, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        return shape19;
    }
    public static boolean[][] makeShape20() {
        shape20 = new boolean[][]{
                {true, true, false, false, false},
                {true, false, false, false, false},
                {true, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        return shape20;
    }
    public static boolean[][] makeShape21() {
        shape21 = new boolean[][]{
                {false, true, false, false, false},
                {false, true, false, false, false},
                {true, true, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        return shape21;
    }
    public static boolean[][] makeShape22() {
        shape22 = new boolean[][]{
                {true, false, false, false, false},
                {false, true, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        return shape22;
    }
    public static boolean[][] makeShape23() {
        shape23 = new boolean[][]{
                {false, true, false, false, false},
                {true, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        return shape23;
    }
    public static boolean[][] makeShape24() {
        shape24 = new boolean[][]{
                {true, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        return shape24;
    }

    public static void addShapes() {
        generateShape.add(shape1);
        generateShape.add(shape2);
        generateShape.add(shape3);
        generateShape.add(shape4);
        generateShape.add(shape5);
        generateShape.add(shape6);
        generateShape.add(shape7);
        generateShape.add(shape8);
        generateShape.add(shape9);
        generateShape.add(shape10);
        generateShape.add(shape11);
        generateShape.add(shape12);
        generateShape.add(shape13);
        generateShape.add(shape14);
        generateShape.add(shape15);
        generateShape.add(shape16);
        generateShape.add(shape17);
        generateShape.add(shape18);
        generateShape.add(shape19);
        generateShape.add(shape20);
        generateShape.add(shape21);
        generateShape.add(shape22);
        generateShape.add(shape23);
        generateShape.add(shape24);
    }

    public int randomNum() {
        System.out.println("ARRAY SIZE" + generateShape.size());
        return (int)(Math.random() * (generateShape.size()) + 1);
    }

    public int numShapes() {
        return generateShape.size();
    }
}
