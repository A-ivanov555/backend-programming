public class Mage extends Character{
    public Mage(String name) {
        super(name,90,30,2);

    }
    @Override
    public void useSpecialAbility(Character target){
    if (getSpecialUses()>0){
        target.takeDamage(getDamage()*3);
        spendSpecialUse();
    }
}
}
