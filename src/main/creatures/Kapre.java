package creatures;

import core.Vitals;

public final class Kapre extends Creature {

    public Kapre() {
        super("Kapre");
        setStartingVitals();
    }

    @Override
    protected void setStartingVitals() {
        vitals.setAuraPulse(Vitals.AuraPulse.CHAOTIC);
        vitals.setSoulFlux(70.0);
        vitals.setPyricMarks(1);
        vitals.setConsciousness(Vitals.Consciousness.DORMANT);
        vitals.setRitualGround(Vitals.RitualGround.UNMARKED);
        vitals.setSpiritualVision(Vitals.SpiritualVision.VEILED);
        vitals.setUncorrupted(1);
        vitals.setPossessed(0);
        vitals.setChanneling(false);
    }
}
