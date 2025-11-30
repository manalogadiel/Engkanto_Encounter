package core;

import creatures.Creature;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Exorcist {
    private final List<String> inventory = new ArrayList<>();
    private String skillText;
    private int skillRange = 1000;
    private int boundRange = 800;
    private int lightRange = 800;
    private boolean thirdEyeUsed = false;
    private boolean chamberOpened = false;
    private boolean heartBaneUsed;
    private boolean holyWaterUsed = false;
    private boolean gameLose = false;

    public Exorcist() {
        inventory.add("Draw Circle");
        inventory.add("Essence Chamber");
        inventory.add("Chant Prayer");
        inventory.add("Heartbane");
        inventory.add("Kepweng's Potion");
        inventory.add("Third Eye");
        inventory.add("Burn Herbs");
        inventory.add("Ember Rite");
        inventory.add("Invoke Fire");
        inventory.add("Holy Water");
        inventory.add("Light Candle");
        inventory.add("Spirit Bell");
        inventory.add("Sprinkle Salt");
        inventory.add("Garlic Blast");
        inventory.add("Rosary");  
    }
    
    public void showSkills() {
        int columns = 5;
        int rows = 3;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                int index = row * columns + col;
                if (index < inventory.size()) {
                    System.out.printf("[%2d] %-20s", index + 1, inventory.get(index));
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public String getSkillByIndex(int idx) {
        if (idx < 1 || idx > inventory.size()) return null;
        return inventory.get(idx - 1);
    }

    public boolean useSkill(int idx, Creature enemy){
        String skill = getSkillByIndex(idx);
        System.out.println(skill);
        if (skill == null){
            return false;
        }
        Vitals vitals = enemy.getVitals(); 
        Exorcist exorcist = enemy.getExorcist();

        int chanceDefault = 0;
        if (this.thirdEyeUsed == true) {
            chanceDefault = 90;
        }
        switch (skill){
            case "Third Eye" -> {
                if (!getThirdEyeUsed()){
                    if (thirdEyeSuccess(90)) {
                        this.lightRange = 100;
                        this.thirdEyeUsed = true;
                        String revelation = getThirdEyeRevelation(enemy);
                        Battle.setFirstText(revelation);
                        setSkillText("The veil lifts; the creature's true form manifests before you.\n");
                    }
                    else {
                        setSkillText("You opened your third eye, but dust got caught into it. \n");
                    }
                }
                else {
                    setSkillText("Your third eye is already open.\n");
                }
            }
            case "Draw Circle" -> {
                if (drawCircleSuccess(chanceDefault, boundRange)) {
                    this.skillRange = 100;
                    vitals.setRitualGround(Math.min(10, vitals.getRitualGroundValue() + new Random().nextInt(2,5)));
                    vitals.setConsciousness(Math.min(10, vitals.getConsciousnessValue()+1));
                    setSkillText("The circle glows faintly - the creature is bound within.\n"); 
                }
                else {
                    vitals.setChanneling(Math.max(0, vitals.getChanneling() - 1));
                    setSkillText("You drew an oblong. The creature pauses... then flees.\n");
                }
            }
            case "Light Candle" -> {
                if (lightCandleSuccess(chanceDefault, lightRange)) {
                    vitals.setSpiritualVision(Math.min(10, vitals.getSpiritualVisionValue() + (new Random().nextInt(2,5))));
                    vitals.setSoulFlux(vitals.getSoulFlux() - (new Random().nextDouble(0.02, 2.67)));
                    vitals.setConsciousness(Math.min(10, vitals. getConsciousnessValue()+1));
                    vitals.setChanneling(Math.max(0, vitals.getChanneling() - new Random().nextInt(1,2)));
                    setSkillText("The flame holds - increasing visibility. The creature can no longer hide.\n"); 
                }
                else {
                    vitals.setConsciousness(Math.min(10, vitals.getConsciousnessValue()+1));
                    vitals.setSoulFlux(vitals.getSoulFlux() - (new Random().nextDouble(4.02, 15.67)));
                    vitals.setChanneling(Math.min(10, vitals.getChanneling() - new Random().nextInt(1,2)));
                    vitals.setSpiritualVision(Math.max(0, vitals.getSpiritualVisionValue() - (new Random().nextInt(2,3))));
                    setSkillText("Your candle was blew by the birthday celebrant. That's unfortunate.\n");
                }
            }
            case "Essence Chamber" -> {
                if (skillSuccess(90, skillRange)) {
                    setChamberOpened(true);
                    vitals.setConsciousness(Math.min(10, vitals.getConsciousnessValue()+1));
                    vitals.setSoulFlux(vitals.getSoulFlux() - (new Random().nextDouble(0.02, 2.67)));
                    vitals.setRitualGround(Math.max(0, vitals.getRitualGroundValue() - new Random().nextInt(1)));
                     vitals.setSpiritualVision(Math.min(10, vitals.getSpiritualVisionValue() + (new Random().nextInt(1))));
                    setSkillText("The chamber stabilizes; your herbs are now infused with essence and ready to use.\n"); 
                }
                else {
                    vitals.setConsciousness(Math.min(10, vitals.getConsciousnessValue() + 1));
                    vitals.setSoulFlux(vitals.getSoulFlux() - (new Random().nextDouble(2.02, 3.67)));
                    setSkillText("The container cracked; herbs fell.\n");
                }
            }
            case "Burn Herbs" -> {
                if (getChamberOpened() == true) {
                    if (skillSuccess(90, skillRange)) {
                        vitals.setSoulFlux(Math.min(130.00, vitals.getSoulFlux() + new Random().nextDouble(3.23, 12.93)));
                        vitals.setFaithState(Math.max(0, vitals.getFaithStateValue() - new Random().nextInt(1,3)));
                        vitals.setChanneling(Math.max(0, vitals.getChanneling() - new Random().nextInt(1,2)));
                        vitals.setRitualGround(Math.max(0, vitals.getRitualGroundValue() - new Random().nextInt(1,2)));
                        vitals.setSpiritualVision(Math.min(10, vitals.getSpiritualVisionValue() + (new Random().nextInt(1, 2))));
                        vitals.setAuraPulse(Math.max(0, vitals.getAuraPulseValue() - (new Random().nextInt(1))));
                        setSkillText("The herbs smolder slowly; the air grows thick with acrid fumes.\n"); 
                    }
                    else {
                        vitals.setSoulFlux(vitals.getSoulFlux() - new Random().nextDouble(3.23, 15.93));
                        setSkillText("The herbs fail to ignite properly; the smoke disperses harmlessly.\n");
                    }
                }
                else {
                    setSkillText("You have not prepared the Essence Chamber yet.\n");
                }
            }
            case "Chant Prayer" -> {
                if (skillSuccess(90, skillRange)) {
                    vitals.setPyricMarks(Math.max(0, vitals.getPyricMarks() - 1));
                    vitals.setChanneling(Math.min(10, vitals.getChanneling() + (new Random().nextInt(2,4))));
                    vitals.setRitualGround(Math.max(0, vitals.getRitualGroundValue()- new Random().nextInt(1,2)));
                    vitals.setSpiritualVision(Math.min(10, vitals.getSpiritualVisionValue() + (new Random().nextInt(1,2))));
                    setSkillText("Your prayer resonates; the flames calm and Pyric Marks decrease.\n"); 
                }
                else {
                    vitals.setChanneling(Math.max(0, vitals.getChanneling() - (new Random().nextInt(2))));
                    vitals.setAuraPulse(Math.max(0, vitals.getAuraPulseValue() - (new Random().nextInt(1, 3))));
                    setSkillText("Your voice cracks mid-prayer; no divine response.\n");
                }
            }
            case "Ember Rite" -> {
                if (vitals.getConsciousness() == Vitals.Consciousness.AWAKENED){
                    setSkillText("You Embered an awakened Creature, it reflected back and killed you.\n");
                    setGameLose(true);
                }
                else {
                    if (skillSuccess(90, skillRange)) {
                        vitals.setPyricMarks(Math.min(10, vitals.getPyricMarks()+1));
                        vitals.setFaithState(Math.max(0, vitals.getFaithStateValue() - new Random().nextInt(1,2)));
                        vitals.setRitualGround(Math.max(0, vitals.getRitualGroundValue() - new Random().nextInt(1,3)));
                        vitals.setSpiritualVision(Math.min(10, vitals.getSpiritualVisionValue() + (new Random().nextInt(2,3))));
                        vitals.setAuraPulse(Math.max(0, vitals.getAuraPulseValue() - (new Random().nextInt(1))));
                        vitals.setSoulFlux(vitals.getSoulFlux() - new Random().nextDouble(1.23, 2.93));
                        setSkillText("The flames answer your call; the Ember Rite is fulfilled.\n");
                        if (vitals.getPyricMarks() >= vitals.getRequiredMarks()) {
                            setSkillText("The creature's heart essence has been fully dissolved!\n");
                        }
                    }
                    else {
                        vitals.setFaithState(Math.max(0, vitals.getFaithStateValue() - new Random().nextInt(2,3)));
                        setSkillText("The power rejects your command; the creature's mind resists.\n");
                    }
                }
            }
            case "Spirit Bell" -> {
                if (skillSuccess(90, skillRange)) {
                    vitals.setRitualGround(Math.max(0, vitals.getRitualGroundValue() - 1));
                    vitals.setConsciousness(Math.max(0, vitals.getConsciousnessValue() - new Random().nextInt(7, 10)));
                    vitals.setChanneling(Math.max(0, vitals.getChanneling() - new Random().nextInt(1,2)));
                    setSkillText("The bell's chime echoes - The creature collapses into silence.\n"); 
                }
                else {
                    vitals.setChanneling(Math.max(0, vitals.getChanneling() - new Random().nextInt(1,2)));
                    setSkillText("You rang the wrong bell, Mamang Sorbetero is looking for it.\n");
                }
            }
            case "Heartbane" -> {
                if (vitals.getPyricMarks() >= vitals.getRequiredMarks() && !exorcist.getHeartBaneUsed()) {
                    if (skillSuccess(90, skillRange)) {
                        exorcist.setHeartBaneUsed(true);
                        vitals.setFaithState(Math.max(0, vitals.getFaithStateValue() - new Random().nextInt(1,2)));
                        vitals.setChanneling(Math.max(0, vitals.getChanneling() - new Random().nextInt(1,2)));
                        vitals.setAuraPulse(Math.max(0, vitals.getAuraPulseValue() - (new Random().nextInt(1, 3))));
                        setSkillText("Your strike pierces true; the creature's heart essence dissolves.\n"); 
                    }
                    else {
                        vitals.setAuraPulse(Math.max(0, vitals.getAuraPulseValue() - (new Random().nextInt(1, 3))));
                        setSkillText("The core retaliates; your energy is repelled.\n");
                    }
                }
                else{
                    setSkillText("The creature's heart is still strong; more Pyric Marks are needed or you've used it already, think wise.\n");
                }
            }
            case "Kepweng's Potion" -> {
                if (vitals.getAuraPulse() == Vitals.AuraPulse.CHAOTIC){
                    if (skillSuccess(90, skillRange)) {
                        vitals.setAuraPulse(vitals.getAuraPulseValue() - (new java.util.Random().nextBoolean() ? 1 : 7));
                        vitals.setChanneling(Math.max(0, vitals.getChanneling() - new Random().nextInt(1,2)));
                        setSkillText("The potion suppressed the creature's aura pulse; it is now stable.\n"); 
                    }
                    else {
                        setSkillText("You used the wrong potion; the creature has gone on a rampage.\n");
                    }
                } else {
                    setSkillText("The creature's aura pulse is not chaotic; the potion can't be used.\n");
                }
            }
        
            case "Invoke Fire" -> {
                if (vitals.getPyricMarks() >= 1){
                    if (skillSuccess(90, skillRange)) {
                        vitals.setChanneling(Math.min(10, vitals.getChanneling() + (new Random().nextInt(1,2))));
                        vitals.setRitualGround(Math.max(0, vitals.getRitualGroundValue() - new Random().nextInt(1,2)));
                        vitals.setSpiritualVision(Math.min(10, vitals.getSpiritualVisionValue() + (new Random().nextInt(1))));
                        setSkillText("The fire surges and burns away lingering channeling.\n"); 
                    }
                    else {

                        setSkillText("The flames flicker out; channeling continues.\n");
                    }
                }
                else {
                    setSkillText("The creature resists; no Pyric Marks to fuel the fire.\n");
                }
            }
            case "Holy Water" -> {
                if (exorcist.getHeartBaneUsed() == true && vitals.getChanneling() > 5 && vitals.getSoulFlux() > 80.0 && vitals.getFaithState() == Vitals.FaithState.NORMAL
                    && vitals.getUncorrupted() == 0 && vitals.getPossessed() == 0 && vitals.getPyricMarks() == 0) {
                    if (skillSuccess(90, skillRange)) {
                        setHolyWaterUsed(true);
                        setSkillText("The water sizzles - corruption successfully fades. \n"); 
                    }
                    else {
                        setSkillText("You accidentally drank the water due to thirst\n");
                    }
                }
                else {
                    setSkillText("The holy water has no effect; the creature's essence remains intact.\n" + getHeartBaneUsed());
                }
            }
            case "Sprinkle Salt" -> {
                if (vitals.isRareCreatureEncountered()) {
                    if (vitals.getConsciousness() == Vitals.Consciousness.AWAKENED) {
                        setSkillText("You cannot use salt on an awakened creature.\n");
                        break;
                    }
                    if (skillSuccess(90, skillRange)) {
                        vitals.setUncorrupted(Math.max(0, vitals.getUncorrupted() - 1));
                        vitals.setFaithState(Math.max(0, vitals.getFaithStateValue() - new Random().nextInt(1,3)));
                        vitals.setRitualGround(Math.max(0, vitals.getRitualGroundValue() - new Random().nextInt(1,2)));
                        vitals.setSpiritualVision(Math.min(10, vitals.getSpiritualVisionValue() + (new Random().nextInt(1, 2))));
                        setSkillText("The salt purifies the essence; corruption fades.\n");
                        if (vitals.getPossessed() > 0) {
                           vitals.setUncorrupted(Math.min(10, vitals.getUncorrupted() + 1));
                           vitals.setSoulFlux(vitals.getSoulFlux() - new Random().nextDouble(3.23, 15.93)); 
                        }
                    }
                    else {
                        vitals.setFaithState(Math.max(0, vitals.getFaithStateValue() - new Random().nextInt(1,3)));
                        setSkillText("You used iodized salt. Nothing happens.\n");
                    }
                }
                else {
                    setSkillText("The creature is common; salt has no special effect.\n");
                }
            }
            case "Garlic Blast" -> {
                if (vitals.isRareCreatureEncountered() ==  true) {
                    if (skillSuccess(90, skillRange)) {
                        vitals.setPossessed(Math.max(0, vitals.getPossessed() - 1));
                        vitals.setUncorrupted(vitals.getUncorrupted() + 1);
                        vitals.setAuraPulse(Math.max(0, vitals.getAuraPulseValue() - (new Random().nextInt(1, 3))));
                        vitals.setRitualGround(Math.max(0, vitals.getRitualGroundValue() - new Random().nextInt(1,2)));
                        vitals.setSpiritualVision(Math.min(10, vitals.getSpiritualVisionValue() + (new Random().nextInt(2,3))));
                        setSkillText("The garlic fumes sting; possession weakens.\n"); 
                    }
                    else {
                        vitals.setAuraPulse(Math.max(0, vitals.getAuraPulseValue() - (new Random().nextInt(1, 3))));
                        vitals.setSoulFlux(vitals.getSoulFlux() - new Random().nextDouble(3.23, 15.93));
                        setSkillText("You tossed stale garlic; it had no effect.\n");
                    }
                }
                else {
                    if (skillSuccess(90, skillRange)) {
                        vitals.setAuraPulse(Math.max(0, vitals.getAuraPulseValue() - (new Random().nextInt(1, 3))));
                        vitals.setRitualGround(Math.max(0, vitals.getRitualGroundValue() - new Random().nextInt(1,2)));
                        vitals.setSoulFlux(vitals.getSoulFlux() - new Random().nextDouble(3.23, 15.93));
                        setSkillText("The garlic fumes sting; possession weakens.\n"); 
                    }
                    else {
                        vitals.setAuraPulse(Math.max(0, vitals.getAuraPulseValue() - (new Random().nextInt(1, 3))));
                        setSkillText("You tossed stale garlic; it had no effect.\n");
                    }
                }
            }
            case "Rosary" -> {
                if (skillSuccess(90, skillRange)) {
                    vitals.setFaithState(Math.min(10, vitals.getFaithStateValue() + new Random().nextInt(2, 4)));
                    vitals.setSpiritualVision(Math.min(10, vitals.getSpiritualVisionValue() + (new Random().nextInt(2,3))));
                    setSkillText("Hallelujah! Your faith has been restored and strengthened.\n"); 
                }
                else {
                    vitals.setAuraPulse(Math.max(0, vitals.getAuraPulseValue() - (new Random().nextInt(1, 3))));
                    setSkillText("Your rosary snaps into pieces.\n");
                }
            }
            default -> {
                    System.out.println("Skill not implemented yet.");
            }
        }

        if (vitals.getRitualGround() == Vitals.RitualGround.UNMARKED){
            this.skillRange = 500;
        }
            else if (vitals.getRitualGround() == Vitals.RitualGround.CORRUPTED){
                this.skillRange = 125;
            }

        if (getThirdEyeUsed() == true && vitals.getSpiritualVision() == Vitals.SpiritualVision.VEILED){
            this.lightRange = 125;
            this.boundRange = 300;
        }
            else if (vitals.getSpiritualVision() == Vitals.SpiritualVision.FLICKERING){
                this.lightRange = 100;
                this.boundRange = 200;
            }
            else if (vitals.getSpiritualVision() == Vitals.SpiritualVision.VISIBLE){
                this.lightRange = 150;
                this.boundRange = 100;
            }
        
        if (vitals.getFaithStateValue() == 0 || vitals.getSoulFlux() <= 60.0 || vitals.getChanneling() == 0 || vitals.getAuraPulseValue() == 10) {
            setGameLose(true);
        }

        return false;
    }

    private String getThirdEyeRevelation(Object enemy) {
        Random random = new Random();
        String enemyType = enemy.getClass().getSimpleName();
        
        Map<String, String[]> revelationMap = new HashMap<>();
        
        revelationMap.put("Manananggal", new String[]{
            "A flying Manananggal is hovering over the rooftops.",
            "The Manananggal has separated its torso and is searching for prey.",
            "A winged Manananggal is perched on the church bell tower.",
            "The Manananggal's true form flies silently under the moonlight."
            });
        
        revelationMap.put("WhiteLady", new String[]{
            "A weeping White Lady floats through the abandoned hallway.",
            "The White Lady is brushing her long hair in front of the mirror.",
            "A translucent White Lady searches for her lost children.",
            "The White Lady's ghostly form drifts through the old mansion."
            });
        
        revelationMap.put("Duwende", new String[]{
            "A mischievous Duwende is hiding among the roots of the balete tree.",
            "The Duwende is tinkering with stolen household items in its burrow.",
            "A bearded Duwende watches from the shadows of the garden.",
            "The Duwende is whispering secrets to the earthworms."
            });
        
        revelationMap.put("Tiyanak", new String[]{
            "A crying Tiyanak is luring travelers deep into the forest.",
            "The Tiyanak's true form plays cruel tricks on lost children.",
            "A demonic Tiyanak mimics a baby's cry from the swamp.",
            "The Tiyanak is waiting to prey on compassionate souls."
            });
        
        revelationMap.put("Kapre", new String[]{
            "A giant Kapre is smoking a large cigar in the treetops.",
            "The Kapre watches travelers from its perch in the old acacia tree.",
            "A massive Kapre is laughing at those who get lost in its domain.",
            "The Kapre's glowing eyes peer down from the dark canopy."
            });
        
        revelationMap.put("Tikbalang", new String[]{
            "A towering Tikbalang is leading travelers astray on the mountain path.",
            "The Tikbalang stands guard at the crossroads, confusing directions.",
            "A horse-headed Tikbalang is creating illusions in the fog.",
            "The Tikbalang's shadow looms large over the confused wanderers."
            });
        
        revelationMap.put("Tiktik", new String[]{
            "A Tiktik is flying overhead, its tongue clicking in the night.",
            "The Tiktik perches on the roof, searching for pregnant women.",
            "A winged Tiktik circles above the sleeping village.",
            "The Tiktik's shadow passes over the moon as it hunts."
            });
        
        revelationMap.put("Sirena", new String[]{
            "A beautiful Sirena is singing her enchanting song from the rocks.",
            "The Sirena combs her hair while luring fishermen to their doom.",
            "A mystical Sirena swims gracefully in the moonlit cove.",
            "The Sirena's melody echoes across the treacherous waters."
            });
        
        revelationMap.put("Engkanto", new String[]{
            "A handsome Engkanto is dancing in the enchanted grove.",
            "The Engkanto charms mortals with its otherworldly beauty.",
            "A noble Engkanto leads travelers deeper into its magical realm.",
            "The Engkanto's illusion hides the dangerous truth of the forest."
            });
        String[] revelations = revelationMap.getOrDefault(enemyType, new String[]{"The creature's true form is revealed before you."});
        return revelations[random.nextInt(revelations.length)];
    }
    public void setSkillText(String skillText) {
        this.skillText = skillText;
    }

    public String getSkillText() {
        return skillText;
    }

    public boolean skillSuccess(int chancePercent, int skillRange) {
        return new Random().nextInt(skillRange) <= chancePercent;
    }   

    public boolean thirdEyeSuccess(int chancePercent) {
        return new Random().nextInt(100) <= chancePercent;
    } 

    public boolean drawCircleSuccess(int chancePercent, int boundRange) {
        return new Random().nextInt(boundRange) <= chancePercent;
    } 

    public boolean lightCandleSuccess(int chancePercent, int lightRange) {
        return new Random().nextInt(lightRange) <= chancePercent;
    } 

    public void resetSkillRanges() {
        this.skillRange = 1000;
        this.boundRange = 800;
        this.lightRange = 800;
    }

    public void setThirdEyeUsed(boolean used) {
        this.thirdEyeUsed = used;
    }
    public void setHeartBaneUsed(boolean used) {
        this.heartBaneUsed = used;
    }
    public void setHolyWaterUsed(boolean used) {
        this.holyWaterUsed = used;
    }
    public void setChamberOpened(boolean opened) {
        this.chamberOpened = opened;
    }
    public void setGameLose(boolean lose) {
        this.gameLose = lose;
    }

    public void resetForBattle() {
        this.chamberOpened = false;
        this.thirdEyeUsed = false;
        this.holyWaterUsed = false;
        this.heartBaneUsed = false;
        this.gameLose = false; 
    }
    public boolean getThirdEyeUsed() {
        return thirdEyeUsed;
    }
    public boolean getHeartBaneUsed() {
        return heartBaneUsed;
    } 
    public boolean getHolyWaterUsed() {
        return holyWaterUsed;
    }
    public boolean getChamberOpened() {
        return chamberOpened;
    }
    public boolean getGameLose() {
        return gameLose;
    }
    
}
