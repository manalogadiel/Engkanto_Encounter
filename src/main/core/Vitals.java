package core;

public class Vitals {
    public enum AuraPulse { CHAOTIC, DEFILED, EMPOWERING, CORRUPTED } 
    public enum Consciousness { AWAKENED, STIRRED, DORMANT } 
    public enum RitualGround { BOUNDED, CORRUPTED, UNMARKED, PURIFIED } 
    public enum SpiritualVision { VISIBLE, FLICKERING, VEILED } 
    public enum FaithState { NORMAL, WAVERING, FALTERED }

    private AuraPulse auraPulse;
    private Consciousness consciousness;
    private double soulFlux;
    private RitualGround ritualGround;
    private int pyricMarks;
    private SpiritualVision spiritualVision;
    private int uncorrupted;
    private int possessed;
    private boolean channeling;
    private int kepwengDeadlineTurn;

    public AuraPulse getAuraPulse() { return auraPulse; }
    public Consciousness getConsciousness() { return consciousness; }
    public double getSoulFlux() { return soulFlux; }
    public RitualGround getRitualGround() { return ritualGround; }
    public int getPyricMarks() { return pyricMarks; }
    public SpiritualVision getSpiritualVision() { return spiritualVision; }
    public int getUncorrupted() { return uncorrupted; }
    public int getPossessed() { return possessed; }
    public boolean getChanneling() { return channeling; }
    public int getKepwengDeadlineTurn() { return kepwengDeadlineTurn; }

    public void setAuraPulse(AuraPulse auraPulse) { this.auraPulse = auraPulse; }
    public void setConsciousness(Consciousness consciousness) { this.consciousness = consciousness; }
    public void setSoulFlux(double soulFlux) { this.soulFlux = soulFlux; }
    public void setRitualGround(RitualGround ritualGround) { this.ritualGround = ritualGround; }
    public void setPyricMarks(int pyricMarks) { this.pyricMarks = pyricMarks; }
    public void setSpiritualVision(SpiritualVision spiritualVision) { this.spiritualVision = spiritualVision; }
    public void setUncorrupted(int uncorrupted) { this.uncorrupted = uncorrupted; }
    public void setPossessed(int possessed) { this.possessed = possessed; }
    public void setChanneling(boolean channeling) { this.channeling = channeling; }
    public void setKepwengDeadlineTurn(int kepwengDeadlineTurn) { this.kepwengDeadlineTurn = kepwengDeadlineTurn; }
}
