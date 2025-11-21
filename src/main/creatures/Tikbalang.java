package creatures;

import core.Vitals;

public final class Tikbalang extends Creature {

    public Tikbalang() {
        super("Tikbalang");
        setStartingVitals();
    }

    @Override
    protected void setStartingVitals() {
        vitals.setAuraPulse(Vitals.AuraPulse.CHAOTIC);
        vitals.setSoulFlux(80.0);
        vitals.setPyricMarks(0);
        vitals.setConsciousness(Vitals.Consciousness.AWAKENED);
        vitals.setRitualGround(Vitals.RitualGround.UNMARKED);
        vitals.setSpiritualVision(Vitals.SpiritualVision.VISIBLE);
        vitals.setUncorrupted(1);
        vitals.setPossessed(1);
        vitals.setChanneling(false);
    }
}
