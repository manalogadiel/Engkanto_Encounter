package creatures;

import java.util.Random;

public final class Tiktik extends Creature {

    public Tiktik() {
        super("Tiktik");
        setStartingVitals();
    }

    @Override
    protected void setStartingVitals() {
        vitals.setAuraPulse(0);
        vitals.setSoulFlux(80.0);
        vitals.setPyricMarks(0);
        vitals.setConsciousness(7);
        vitals.setRitualGround(0);
        vitals.setSpiritualVision(0);
        vitals.setUncorrupted(1);
        vitals.setPossessed(1);
        vitals.setChanneling(10);
        vitals.setRequiredMarks(new Random().nextInt(2,4));
        vitals.setRareCreatureEncountered(true);
    }
}
