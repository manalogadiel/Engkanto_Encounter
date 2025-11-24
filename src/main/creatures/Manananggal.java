package creatures;

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
    }
}
