package core;

import creatures.Creature;
import java.util.*;

public class Battle {
    Scanner scanner = new Scanner(System.in);
    private final Creature enemy;
    private final Exorcist exorcist;
    
    boolean endGame = false;
    private boolean userExited = false; // Add this flag

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
        Game game = new Game();
        String[] hiddenCreature = {
            "The shadows shift, but nothing reveals itself.",
            "You feel eyes watching you from the shadows."
        };
        int index = random.nextInt(hiddenCreature.length);
        setFirstText(hiddenCreature[index]);

        while(!endGame){
            // Vitals vitals = enemy.getVitals();
            game.clearScreen();
            System.out.println(firstText);
            
            System.out.println();

            enemy.showVitals();
            System.out.println("");

            System.out.print(userText);
            // we used this a while back for debugging
            // enemy.showBane();
            // System.out.println("Faith State val: " + vitals.getFaithStateValue());
            // System.out.println("Channeling val: " + vitals.getChanneling());
            exorcist.showSkills();
            

            if (exorcist.getGameLose() == true) {
                game.clearScreen();
                displayGameOver();
                System.out.print("Press Enter to exit...");
                scanner.nextLine(); 
                this.endGame = true;
                break;
            }
            else if (exorcist.getHolyWaterUsed() == true) {
                game.clearScreen();
                displayVictory();
                System.out.print("Press Enter to continue...");
                scanner.nextLine(); 
                break;
            }

            System.out.print("Choose a skill number to use (1-15) or 'E' to exit: ");
            String input = scanner.nextLine().trim();
            
            // Handle exit command (case-insensitive)
            if (input.equalsIgnoreCase("E")) {
                if (confirmExit()) {
                    this.userExited = true;
                    this.endGame = true;
                    break;
                } else {
                    continue;
                }
            }
            
            // Handle numeric input
            try {
                int choice = Integer.parseInt(input);
                
                if (choice < 1 || choice > 15) {
                    System.out.println("Invalid input! Please enter a number between 1 and 15.");
                    System.out.println("Press Enter to continue...");
                    scanner.nextLine(); 
                    continue; 
                }
                
                exorcist.useSkill(choice, enemy);
                setSecondText(choice);
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 15 or 'E' to exit.");
                System.out.println("Press Enter to continue...");
                scanner.nextLine();
            }
        }
    }
    
    private boolean confirmExit() {
        System.out.print("Are you sure you want to exit? Press Enter to confirm exit, or any other key to continue: ");
        String confirmation = scanner.nextLine().trim();
        return confirmation.isEmpty(); 
    }
    

    public boolean didUserExit() {
        return userExited;
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

    private void displayGameOver() {
        System.out.println();
        System.out.println("╔════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                                                ║");
        System.out.println("║    ██████   █████  ███    ███ ███████      ██████  ██    ██ ███████ ██████     ║");
        System.out.println("║   ██       ██   ██ ████  ████ ██          ██    ██ ██    ██ ██      ██   ██    ║");
        System.out.println("║   ██   ███ ███████ ██ ████ ██ █████       ██    ██ ██    ██ █████   ██████     ║");
        System.out.println("║   ██    ██ ██   ██ ██  ██  ██ ██          ██    ██  ██  ██  ██      ██   ██    ║");
        System.out.println("║    ██████  ██   ██ ██      ██ ███████      ██████    ████   ███████ ██   ██    ║");
        System.out.println("║                                                                                ║");
        System.out.println("║                        The darkness has consumed you...                        ║");
        System.out.println("║                  The creatures continue to terrorize the world.                ║");
        System.out.println("║                                                                                ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════╝");
        System.out.println();
    }
    private void displayVictory() {
        System.out.println();
        System.out.println("╔════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                                                ║");
        System.out.println("║            ██    ██ ██  ██████ ████████  ██████  ██████  ██    ██              ║");
        System.out.println("║            ██    ██ ██ ██         ██    ██    ██ ██   ██  ██  ██               ║");
        System.out.println("║            ██    ██ ██ ██         ██    ██    ██ ██████    ████                ║");
        System.out.println("║             ██  ██  ██ ██         ██    ██    ██ ██   ██    ██                 ║");
        System.out.println("║              ████   ██  ██████    ██     ██████  ██   ██    ██                 ║");
        System.out.println("║                                                                                ║");
        System.out.println("║                    Light has triumphed over the shadows!                       ║");
        System.out.println("║             The cursed creature has been cleansed from this realm.             ║");
        System.out.println("║                                                                                ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════╝");
        System.out.println();
}

}