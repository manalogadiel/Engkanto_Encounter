package modes;

import core.Battle;
import creatures.*;
import java.util.Random;

public class Survival {

    private final Creature[] creatures = {
        new Duwende(),
        new WhiteLady(),
        new Engkanto(),
        new Kapre(),
        new Manananggal(),
        new Tiyanak(),
        new Tikbalang(),
        new Sirena(),
        new Tiktik()
    };

    public void start() {
        Random random = new Random();
        int index = random.nextInt(creatures.length); 
        Creature encounter = creatures[index];    

        Battle battle = new Battle(encounter);
        battle.start();
    }
}
