public class Main {
    public static void main(String[] args) {
        Team team1 = new Team("Green");
        Team team2 = new Team("Blue");
        team1.addCharacter(new Warrior("Arthur"));
        team1.addCharacter(new Mage("Merlin"));
        team1.addCharacter(new Archer("Robin"));

        team2.addCharacter(new Warrior("Leon"));
        team2.addCharacter(new Mage("Morgana"));
        team2.addCharacter(new Archer("Hawkeye"));

        Battle battle = new Battle(team1, team2);
        battle.startBattle();
    }
}
