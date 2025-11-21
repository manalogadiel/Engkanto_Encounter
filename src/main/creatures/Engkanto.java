package creatures;

import core.Vitals;

public final class Engkanto extends Creature {

    public Engkanto() {
        super("Engkanto");
        setStartingVitals();
    }

    @Override
    protected void setStartingVitals() {
        vitals.setAuraPulse(Vitals.AuraPulse.EMPOWERING);
        vitals.setSoulFlux(85.0);
        vitals.setPyricMarks(1);
        vitals.setConsciousness(Vitals.Consciousness.AWAKENED);
        vitals.setRitualGround(Vitals.RitualGround.UNMARKED);
        vitals.setSpiritualVision(Vitals.SpiritualVision.VISIBLE);
        vitals.setUncorrupted(2);
        vitals.setPossessed(0);
        vitals.setChanneling(false);
    }
}
