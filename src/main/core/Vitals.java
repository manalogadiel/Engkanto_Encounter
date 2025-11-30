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
    private int channeling;
    private int kepwengDeadlineTurn;
    private FaithState faithState;

    private int auraPulseValue;
    private int consciousnessValue;
    private int ritualGroundValue;
    private int spiritualVisionValue; 
    private int faithStateValue;
    private int requiredMarks;

    private boolean rareCreatureEncountered;

    public Vitals() {
        // Initialize enum fields to defaults to prevent null
        this.auraPulse = AuraPulse.CORRUPTED;
        this.consciousness = Consciousness.DORMANT;
        this.ritualGround = RitualGround.UNMARKED;
        this.spiritualVision = SpiritualVision.VEILED;
        this.faithState = FaithState.NORMAL;
    }

    // Helper methods to map integer values to enum types
    public static AuraPulse getAuraPulseFromInt(int value) {
        if (value == 10) return null; // auto lose, handle in game logic
        if (value >= 9) return AuraPulse.CHAOTIC;
        if (value >= 6) return AuraPulse.DEFILED;
        if (value >= 3) return AuraPulse.EMPOWERING;
        return AuraPulse.CORRUPTED;
    }

    public static Consciousness getConsciousnessFromInt(int value) {
        if (value == 10) return Consciousness.AWAKENED;
        if (value >= 8) return Consciousness.STIRRED;
        return Consciousness.DORMANT;
    }

    public static RitualGround getRitualGroundFromInt(int value) {
        if (value >= 4) return RitualGround.BOUNDED;
        if (value >= 1) return RitualGround.CORRUPTED;
        if (value == 0) return RitualGround.UNMARKED;
        return RitualGround.PURIFIED;
    }

    public static SpiritualVision getSpiritualVisionFromInt(int value) {
        if (value >= 5) return SpiritualVision.VISIBLE;
        if (value >= 1) return SpiritualVision.FLICKERING;
        return SpiritualVision.VEILED;
    }

    public static FaithState getFaithStateFromInt(int value) {
        if (value >= 3) return FaithState.NORMAL;
        if (value >= 2) return FaithState.WAVERING;
        return FaithState.FALTERED;
    }

    public AuraPulse getAuraPulse() { return auraPulse; }
    public Consciousness getConsciousness() { return consciousness; }
    public double getSoulFlux() { return soulFlux; }
    public RitualGround getRitualGround() { return ritualGround; }
    public int getPyricMarks() { return pyricMarks; }
    public SpiritualVision getSpiritualVision() { return spiritualVision; }
    public int getUncorrupted() { return uncorrupted; }
    public int getPossessed() { return possessed; }
    public int getChanneling() { return channeling; }
    public int getKepwengDeadlineTurn() { return kepwengDeadlineTurn; }
    public FaithState getFaithState() { return faithState; }

    public int getAuraPulseValue() { return auraPulseValue; }
    public int getConsciousnessValue() { return consciousnessValue; }
    public int getRitualGroundValue() { return ritualGroundValue; }
    public int getSpiritualVisionValue() { return spiritualVisionValue; }
    public int getFaithStateValue() { return faithStateValue; }
    public int getRequiredMarks() { return requiredMarks; } 
    public int getChannelingValue() { return channeling; }
    public boolean isRareCreatureEncountered() { return rareCreatureEncountered; }

    public void setRareCreatureEncountered(boolean encountered) { 
        this.rareCreatureEncountered = encountered; 
    }
    public void setAuraPulse(int auraPulseValue) { 
        this.auraPulse = getAuraPulseFromInt(auraPulseValue); 
        this.auraPulseValue = auraPulseValue;
    }
    public void setConsciousness(int consciousnessValue) { 
        this.consciousness = getConsciousnessFromInt(consciousnessValue); 
        this.consciousnessValue = consciousnessValue;
    }
    public void setSoulFlux(double soulFlux) { 
        this.soulFlux = soulFlux; 
    }
    public void setRitualGround(int ritualGroundValue) { 
        this.ritualGround = getRitualGroundFromInt(ritualGroundValue); 
        this.ritualGroundValue = ritualGroundValue;
    }
    public void setPyricMarks(int pyricMarks) { 
        this.pyricMarks = pyricMarks; 
    }
    public void setSpiritualVision(int spiritualVisionValue) { 
        this.spiritualVision = getSpiritualVisionFromInt(spiritualVisionValue); 
        this.spiritualVisionValue = spiritualVisionValue;
    }
    public void setUncorrupted(int uncorrupted) { 
        this.uncorrupted = uncorrupted; 
    }
    public void setPossessed(int possessed) { 
        this.possessed = possessed; 
    }
    public void setChanneling(int channeling) { 
        this.channeling = channeling;
    }
    public void setFaithState(int faithStateValue) {
        this.faithState = getFaithStateFromInt(faithStateValue);
        this.faithStateValue = faithStateValue;
    }
    public void setKepwengDeadlineTurn(int kepwengDeadlineTurn) { 
        this.kepwengDeadlineTurn = kepwengDeadlineTurn; 
    }
    public void setRequiredMarks(int requiredMarks) {
        this.requiredMarks = requiredMarks;
    }
}
