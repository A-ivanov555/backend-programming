public class Archer extends Character{
    public Archer(String name){
        super(name,100,25,3);
    }
    @Override
    public void useSpecialAbility(Character target) {
        if(getSpecialUses()>0){
            target.takeDamage(getDamage()+15);
            spendSpecialUse();
        }
    }
}
