public abstract class Character {
    private String name;
    private int health;
    private int damage;
    private int specialUses;

    public Character(String name, int health, int damage, int specialUses) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.specialUses = specialUses;
    }

    public void takeDamage(int damage) {
        health -= damage;

        if (health < 0) {
            health = 0;
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void attack(Character target) {
        target.takeDamage(damage);
    }

    protected void spendSpecialUse() {
        specialUses--;
    }

    public abstract void useSpecialAbility(Character target);

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpecialUses() {
        return specialUses;
    }
}