package creatures;

import core.Vitals;

public class Tiyanak extends Creature {

    public Tiyanak() {
        super("Tiyanak");
    }

    @Override
    protected void setStartingVitals() {
        vitals.setAuraPulse(Vitals.AuraPulse.CORRUPTED);
        vitals.setSoulFlux(90.0);
        vitals.setPyricMarks(3);
        vitals.setConsciousness(Vitals.Consciousness.STIRRED);
        vitals.setRitualGround(Vitals.RitualGround.UNMARKED);
        vitals.setSpiritualVision(Vitals.SpiritualVision.FLICKERING);
        vitals.setUncorrupted(1);
        vitals.setPossessed(2);
        vitals.setChanneling(true);
    }
}
