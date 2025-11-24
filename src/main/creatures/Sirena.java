package creatures;

public final class Sirena extends Creature {

    public Sirena() {
        super("Sirena");
        setStartingVitals();
    }

    @Override
    protected void setStartingVitals() {
        vitals.setAuraPulse(3);
        vitals.setSoulFlux(80.0);
        vitals.setPyricMarks(0);
        vitals.setConsciousness(10);
        vitals.setRitualGround(0);
        vitals.setSpiritualVision(0);
        vitals.setUncorrupted(1);
        vitals.setPossessed(1);
        vitals.setChanneling(10);
    }
}
