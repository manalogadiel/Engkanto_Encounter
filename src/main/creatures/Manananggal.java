package creatures;

import java.util.Random;

public final class Manananggal extends Creature {

    public Manananggal() {
        super("Manananggal");
        setStartingVitals();
    }

    @Override
    protected void setStartingVitals() {
        vitals.setAuraPulse(0);
        vitals.setSoulFlux(85.0);
        vitals.setPyricMarks(0);
        vitals.setConsciousness(8);
        vitals.setRitualGround(0);
        vitals.setSpiritualVision(0);
        vitals.setUncorrupted(0);
        vitals.setPossessed(2);
        vitals.setChanneling(10);
        vitals.setFaithState(10);
        vitals.setRequiredMarks(new Random().nextInt(2,4));
        vitals.setRareCreatureEncountered(true);
        exorcist.setHeartBaneUsed(true);
    }
}
