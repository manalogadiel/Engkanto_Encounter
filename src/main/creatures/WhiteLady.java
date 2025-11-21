package creatures;

import core.Vitals;

public final class WhiteLady extends Creature {

    public WhiteLady() {
        super("White Lady");
        setStartingVitals();
    }

    @Override
    protected void setStartingVitals() {
        vitals.setAuraPulse(Vitals.AuraPulse.DEFILED);
        vitals.setSoulFlux(65.0);
        vitals.setPyricMarks(1);
        vitals.setConsciousness(Vitals.Consciousness.STIRRED);
        vitals.setRitualGround(Vitals.RitualGround.UNMARKED);
        vitals.setSpiritualVision(Vitals.SpiritualVision.FLICKERING);
        vitals.setUncorrupted(0);
        vitals.setPossessed(1);
        vitals.setChanneling(false);
    }
}
