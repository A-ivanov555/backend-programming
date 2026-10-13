public class Warrior extends Character {
    public Warrior(String name) {
        super(name,150,50,3);
    }
    @Override
    public void useSpecialAbility(Character target) {
        if (getSpecialUses()>0){
            target.takeDamage(getDamage()*2);
            spendSpecialUse();

        }

    }
}
