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
        vitals.setConsciousness(0);
        vitals.setRitualGround(0);
        vitals.setSpiritualVision(0);
        vitals.setUncorrupted(1);
        vitals.setPossessed(0);
        vitals.setChanneling(10);
    }
}
