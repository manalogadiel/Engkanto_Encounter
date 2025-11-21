package core;

import creatures.Creature;
import java.util.*;

public class Battle {
    Scanner scanner = new Scanner(System.in);
    private final Creature enemy;

    boolean endGame = true;

    Exorcist exorcist = new Exorcist();

    static String firstText = "";
    String userText = "";

    public Battle(Creature enemy){
        this.enemy = enemy;
    }

    public void start() {
        Random random = new Random();
        

        String[] hiddenCreature = {
            "The shadows shift, but nothing reveals itself.",
            "You feel eyes watching you from the shadows.",
            "You feel eyes watching you from the shadows."
        };
        int index = random.nextInt(hiddenCreature.length);
        setFirstText(hiddenCreature[index]);

        while(endGame){
            Game.clearScreen();
            System.out.println(firstText);
            
            System.out.println();

            enemy.showVitals();
            System.out.println("");

            System.out.print(userText);

            exorcist.showSkills();

            System.out.print("Choose a skill number to use: ");
            int choice = scanner.nextInt();

            exorcist.useSkill(choice, enemy);
            setSecondText(choice);
        }
    }
    public static void setFirstText(String creatureText) {
        firstText = creatureText;
    }

    public void setSecondText(int choice){
        this.userText = exorcist.getSkillText();
    }

}
