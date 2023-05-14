public enum House {
    GRYFFINDOR(10, 20,20,60,"The legendary sword of Godric Gryffindor"),
    HUFFLEPUFF(10, 25,10,60,"Default Weapon"),
    RAVENCLAW(10,20,10,70,"Default Weapon"),
    SLYTHERIN(15, 20,10,60,"Default Weapon"),
    NONE(0,0,0,0,"Default Weapon")
    ;

    private final int spellDamage;
    private final int potionHpModifier;
    private final int resistance;
    private final int accuracy;
    public final String weapons;


    House(int spellDamage, int potionHpModifier, int resistance, int accuracy, String weapons) {
        this.spellDamage = spellDamage;
        this.potionHpModifier = potionHpModifier;
        this.resistance = resistance;
        this.accuracy = accuracy;
        this.weapons = weapons;
    }

    public int getSpelldamage() {
        return spellDamage;
    }

    public int getPotionhpmodif() {
        return potionHpModifier;
    }

    public int getResistance() {
        return resistance;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public String getWeapons() {
        return weapons;
    }
}
