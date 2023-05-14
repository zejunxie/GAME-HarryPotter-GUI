import java.util.Scanner;
public class Wizard {
    Wand wand;
    SortingHat sortingHat;
    int healthPoints;
    int spellDamage;
    int accuracy;
    int resistance;
    int potionEffectiveness;
    House house;
    String weapon;

    public Wizard() {
        wand = new Wand();
        sortingHat = new SortingHat();
        house = sortingHat.assignhouse();
        healthPoints = 100;
        spellDamage = house.getSpelldamage();
        accuracy = house.getAccuracy();
        resistance = house.getResistance();
        potionEffectiveness = house.getPotionhpmodif();
        weapon=house.getWeapons();
    }
}