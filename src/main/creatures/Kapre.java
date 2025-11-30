package creatures;

public final class Kapre extends Creature {

    public Kapre() {
        super("Kapre");
        setStartingVitals();
    }

    @Override
    protected void setStartingVitals() {
        vitals.setAuraPulse(2);
        vitals.setSoulFlux(70.0);
        vitals.setPyricMarks(0);
        vitals.setConsciousness(10);
        vitals.setRitualGround(0);
        vitals.setSpiritualVision(0);
        vitals.setUncorrupted(0);
        vitals.setPossessed(0);
        vitals.setChanneling(10);
        vitals.setFaithState(10);
        vitals.setRareCreatureEncountered(false);
        exorcist.setHeartBaneUsed(false);
        
    }
}
