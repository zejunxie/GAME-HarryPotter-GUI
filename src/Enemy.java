public class Enemy {
    String name;
    int healthPoints;
    int damagePoints;
    String location;
    String tips;

    // Constructor for enemy object
    public Enemy(String name, int healthPoints, int damagePoints, String location, String tips) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.damagePoints = damagePoints;
        this.location = location;
        this.tips = tips;
    }

    public int attack() {
        return damagePoints;
    }
}