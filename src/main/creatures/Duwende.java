package creatures;

import java.util.Random;

public final class Duwende extends Creature {

    public Duwende() {
        super("Duwende");
        setStartingVitals();
    }

    @Override
    protected void setStartingVitals() {
        vitals.setAuraPulse(3);
        vitals.setSoulFlux(75.0);
        vitals.setPyricMarks(0);
        vitals.setConsciousness(10);
        vitals.setRitualGround(0);
        vitals.setSpiritualVision(1);
        vitals.setUncorrupted(0);
        vitals.setPossessed(0);
        vitals.setChanneling(10); 
        vitals.setRequiredMarks(new Random().nextInt(2,4));
        vitals.setRareCreatureEncountered(false);
    }
}
