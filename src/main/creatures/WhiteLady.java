package creatures;

public final class WhiteLady extends Creature {

    public WhiteLady() {
        super("White Lady");
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
        vitals.setUncorrupted(0);
        vitals.setPossessed(0);
        vitals.setChanneling(10);
        vitals.setFaithState(10);
        vitals.setRareCreatureEncountered(false);
        exorcist.setHeartBaneUsed(false);
    }
}
