import java.util.Random;

public class SortingHat {
    House house;

    // Constructor for sorting hat object
    public House  assignhouse() {
        Random random = new Random();
        int houseIndex = random.nextInt(House.values().length - 1); // exclude NONE
        house = House.values()[houseIndex];
        return house;


    }
}