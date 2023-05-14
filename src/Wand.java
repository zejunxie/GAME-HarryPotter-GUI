import java.util.Random;

public class Wand {
    String type;
    String wood;
    int length;

    // Constructor for wand object
    public Wand() {
        Random random = new Random();
        String[] wandTypes = {"Blackthorn", "Elder", "Hawthorn", "Holly", "Oak", "Willow"};
        String[] wandWoods = {"Dragon heartstring", "Phoenix feather", "Unicorn hair"};
        type = wandTypes[random.nextInt(wandTypes.length)];
        wood = wandWoods[random.nextInt(wandWoods.length)];
        length = random.nextInt(12) + 8;
    }
}