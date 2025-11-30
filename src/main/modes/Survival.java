package modes;

import core.*;
import creatures.*;
import java.util.Random;

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

    public void start() {
        Random random = new Random();
        Exorcist survivalExorcist = new Exorcist();
        boolean survivalLost = false;
        
        while (!survivalLost) {
            int index = random.nextInt(creatures.length); 
            Creature encounter = creatures[index];    

            Battle battle = new Battle(encounter, survivalExorcist);
            battle.start();

            if (survivalExorcist.getGameLose()) {
                System.out.println("You have been defeated in Survival Mode. Game Over.");
                Game game = new Game();
                game.waitForEnter();
                survivalLost = true;
            } else {
                System.out.println("You have defeated the " + encounter.getName() + "! Prepare for the next encounter.");
            }
        }
    }
}