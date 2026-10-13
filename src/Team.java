import java.util.ArrayList;

public class Team
{
    private String name;
    private ArrayList<Character> members;
    public Team(String name)
    {
        this.name = name;
        this.members = new ArrayList<>();
    }
    public void addCharacter(Character character){
        members.add(character);

    }
    public boolean hasAliveCharacters(){
        for(Character character : members){
            if(character.isAlive()){
                return true;

            }
        }
        return false;
    }

    public ArrayList<Character> getMembers() {
        return members;
    }

    public String getName(){
        return name;

    }

    }



