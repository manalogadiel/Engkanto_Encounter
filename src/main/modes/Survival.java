package modes;

import core.*;
import creatures.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Survival {
    
    public void start() throws InterruptedException {
        Random random = new Random();
        Exorcist survivalExorcist = new Exorcist();
        boolean survivalLost = false;
        boolean userExitedGame = false; 
        
        while (!survivalLost && !userExitedGame) { 
            Creature encounter = switch(random.nextInt(9)) {
                case 0 -> new Duwende();
                case 1 -> new WhiteLady();
                case 2 -> new Tiyanak();
                case 3 -> new Kapre();
                case 4 -> new Tikbalang();
                case 5 -> new Tiktik();
                case 6 -> new Manananggal();
                case 7 -> new Sirena();
                default -> new Engkanto();
            };
            
            survivalExorcist.resetForBattle();
            Battle battle = new Battle(encounter, survivalExorcist);
            battle.start();

            // Check if user exited from the battle
            if (battle.didUserExit()) {
                System.out.println("Exiting Survival Mode...");
                TimeUnit.MILLISECONDS.sleep(800);
                userExitedGame = true;
            }
            // Check if player lost the battle
            else if (survivalExorcist.getGameLose()) {
                survivalLost = true;
            } else {
                System.out.println("You have defeated the " + encounter.getName() + "! Prepare for the next encounter.");
            }
        }
        
    }
}