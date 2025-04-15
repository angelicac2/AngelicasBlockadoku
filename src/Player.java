public class Player {
    private int points;
    private String name;
    private final int pointsAdded = 9;

    public Player(String name) {
        this.name = name;
        points = 0;
    }

    public int getPoints() {
        return this.points;
    }

    public void addPoints() {
        points += pointsAdded;
    }
}
