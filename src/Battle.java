import java.util.ArrayList;
import java.util.Random;
public class Battle {
    private Team team1;
    private Team team2;
    public Battle(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }
    private Random random = new Random();

    private Character getRandomAliveCharacter(Team team){
        ArrayList<Character> aliveCharacters = new ArrayList<>();
        for(Character character: team.getMembers()){
            if(character.isAlive()){
                aliveCharacters.add(character);
            }

        }
        if (aliveCharacters.size() == 0){
            return null;
        }
        return aliveCharacters.get(random.nextInt(aliveCharacters.size()));


    }
    private void performTurn(Character attacker, Team enemyTeam){
        if(!attacker.isAlive()){
            return;

        }
        Character target = getRandomAliveCharacter(enemyTeam);
        if (target == null){
            return;
        }
        if (attacker.getSpecialUses() > 0 && random.nextBoolean()){
            attacker.useSpecialAbility(target);
            System.out.println(attacker.getName()+" атакует используя особую способность на  " +target.getName());
            System.out.println("Осталось здоровья у "+target.getName()+": "+target.getHealth());

        }else {
            attacker.attack(target);
            System.out.println(attacker.getName()+" атакует " +target.getName());
            System.out.println("Осталось здоровья у "+target.getName()+": "+target.getHealth());


        }



    }
    private void printTeam(Team team) {
        System.out.println("Команда " + team.getName() + ":");

        for (Character character : team.getMembers()) {
            System.out.println(
                    character.getClass().getSimpleName()
                            + " "
                            + character.getName()
            );
        }

        System.out.println();
    }
    public void startBattle() {
        printTeam(team1);
        printTeam(team2);
        int round = 1;
        int maxRounds = 20;
        while (round <= maxRounds
                && team1.hasAliveCharacters()
                && team2.hasAliveCharacters()) {
            System.out.println();
            System.out.println("Раунд " + round+":");
            System.out.println();
            round++;
            for (Character character : team1.getMembers()) {
                performTurn(character, team2);

                if (!team2.hasAliveCharacters()) {
                    break;
                }
            }
            if (!team2.hasAliveCharacters()) {
                break;
            }
            for (Character character : team2.getMembers()) {
                performTurn(character, team1);

                if (!team1.hasAliveCharacters()) {
                    break;
                }
            }

        }
        System.out.println();
        if (!team1.hasAliveCharacters()) {
            System.out.println("Победила команда " + team2.getName());

        } else if (!team2.hasAliveCharacters()) {
            System.out.println("Победила команда " + team1.getName());

        } else {
            System.out.println("Бой завершён без победителя");

        }
    }


}
