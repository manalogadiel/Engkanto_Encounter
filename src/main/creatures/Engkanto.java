package creatures;

public final class Engkanto extends Creature {

    public Engkanto() {
        super("Engkanto");
        setStartingVitals();
    }

    @Override
    protected void setStartingVitals() {
        vitals.setAuraPulse(4);
        vitals.setSoulFlux(85.0);
        vitals.setPyricMarks(0);
        vitals.setConsciousness(10);
        vitals.setRitualGround(0);
        vitals.setSpiritualVision(1);
        vitals.setUncorrupted(2);
        vitals.setPossessed(0);
        vitals.setChanneling(10);
        
    }
}
