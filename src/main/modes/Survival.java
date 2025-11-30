package modes;

import core.*;
import creatures.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Survival {
    private final Creature[] creatures = {
        new Duwende(),
        new WhiteLady(),
        new Tiyanak(),
        new Kapre(),
        new Tikbalang(),
        new Tiktik(),
        new Manananggal(),
        new Sirena(),
        new Engkanto()
    };

    public void start() throws InterruptedException {
        Random random = new Random();
        Exorcist survivalExorcist = new Exorcist();
        boolean survivalLost = false;
        boolean userExitedGame = false; 
        
        while (!survivalLost && !userExitedGame) { 
            int index = random.nextInt(creatures.length); 
            Creature encounter = creatures[index];    

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