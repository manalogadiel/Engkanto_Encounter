package creatures;

import core.Vitals;

public final class Sirena extends Creature {

    public Sirena() {
        super("Sirena");
        setStartingVitals();
    }

    @Override
    protected void setStartingVitals() {
        vitals.setAuraPulse(Vitals.AuraPulse.EMPOWERING);
        vitals.setSoulFlux(80.0);
        vitals.setPyricMarks(2);
        vitals.setConsciousness(Vitals.Consciousness.AWAKENED);
        vitals.setRitualGround(Vitals.RitualGround.UNMARKED);
        vitals.setSpiritualVision(Vitals.SpiritualVision.VISIBLE);
        vitals.setUncorrupted(1);
        vitals.setPossessed(1);
        vitals.setChanneling(true);
    }
}
