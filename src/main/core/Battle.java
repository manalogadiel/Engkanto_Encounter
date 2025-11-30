package core;

import creatures.Creature;
import java.util.*;

public class Battle {
    Scanner scanner = new Scanner(System.in);
    private final Creature enemy;
    private final Exorcist exorcist;
    
    boolean endGame = false;

    static String firstText = "";
    String userText = "";

    public Battle(Creature enemy){
        this.enemy = enemy;
        this.exorcist = new Exorcist();
    }

    public Battle(Creature enemy, Exorcist exorcist){
        this.enemy = enemy;
        this.exorcist = exorcist;
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

        while(!endGame){
            Vitals vitals = enemy.getVitals();
            Game.clearScreen();
            System.out.println(firstText);
            
            System.out.println();

            enemy.showVitals();
            System.out.println("");

            System.out.print(userText);
            enemy.showBane();
            System.out.println("Faith State val: " + vitals.getFaithStateValue());
            System.out.println("Channeling val: " + vitals.getChanneling());
            exorcist.showSkills();
            

            if (exorcist.getGameLose() == true) {
                System.out.println("Your vitals have dropped too low. You lose the battle.");
                this.endGame = true;
                break;
            }
            else if (exorcist.getHolyWaterUsed() == true) {
                System.out.println("You have used Holy Water. The battle ends.");
                break;
            }

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
    
    public boolean isLost() {
        return exorcist.getGameLose();
    }
}