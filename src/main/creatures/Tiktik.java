package creatures;

import core.Vitals;

public final class Tiktik extends Creature {

    public Tiktik() {
        super("Tiktik");
        setStartingVitals();
    }

    @Override
    protected void setStartingVitals() {
        vitals.setAuraPulse(Vitals.AuraPulse.DEFILED);
        vitals.setSoulFlux(85.0);
        vitals.setPyricMarks(2);
        vitals.setConsciousness(Vitals.Consciousness.STIRRED);
        vitals.setRitualGround(Vitals.RitualGround.UNMARKED);
        vitals.setSpiritualVision(Vitals.SpiritualVision.FLICKERING);
        vitals.setUncorrupted(0);
        vitals.setPossessed(2);
        vitals.setChanneling(true);
    }
}
