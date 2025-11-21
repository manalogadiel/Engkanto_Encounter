package core;

import creatures.Creature;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exorcist {
    private final List<String> inventory = new ArrayList<>();
    private String skillText;
    private int skillRange = 1000;
    private int boundRange = 800;
    private int lightRange = 800;
    private boolean thirdEyeUsed = false;
    Exorcist() {
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
        Vitals setVitals = new Vitals();
    
        int chanceDefault = 0;
        if (this.thirdEyeUsed == true) {
            chanceDefault = 90;
        }
        switch (skill){
            case "Third Eye" -> {
                if (thirdEyeSuccess(90)) {
                    this.lightRange = 1;
                    this.thirdEyeUsed = true;
                    Battle.setFirstText("A (doing) " + enemy + " (is doing this).");
                    setSkillText("The veil lifts; the creature's true form manifests before you.\n");
                }
                else {
                    setSkillText("You opened your third eye, but dust got caught into it. \n");
                }
            }
            case "Draw Circle" -> {
                if (drawCircleSuccess(chanceDefault, boundRange)) {
                    this.skillRange = 100;
                    vitals.setRitualGround(Vitals.RitualGround.BOUNDED);
                    setSkillText("The circle glows faintly - the creature is bound within.\n"); 
                }
                else {
                    setSkillText("You drew an oblong. The creature pauses... then flees.\n");
                }
            }
            case "Light Candle" -> {
                if (lightCandleSuccess(chanceDefault, lightRange)) {
                    this.boundRange = 100;
                    vitals.setSpiritualVision(Vitals.SpiritualVision.VISIBLE);
                    setSkillText("The flame holds - increasing visibility. The creature can no longer hide.\n"); 
                }
                else {
                    setSkillText("Your candle was blew by the birthday celebrant. That's unfortunate.\n");
                }
            }
            case "Essence Chamber" -> {
                if (skillSuccess(90, skillRange)) {
                    vitals.setRitualGround(Vitals.RitualGround.BOUNDED);
                    setSkillText("The chamber stabilizes; your herbs are now infused with essence and ready to use.\n"); 
                }
                else {
                    setSkillText("The container cracked; herbs fell.\n");
                }
            }
            case "Chant Prayer" -> {
                if (skillSuccess(90, skillRange)) {
                    vitals.setRitualGround(Vitals.RitualGround.BOUNDED);
                    setSkillText("Your prayer resonates; the flames calm and Pyric Marks decrease.\n"); 
                }
                else {
                    setSkillText("Your voice cracks mid-prayer; no divine response.\n");
                }
            }
            case "Heartbane" -> {
                if (skillSuccess(90, skillRange)) {
                    vitals.setRitualGround(Vitals.RitualGround.BOUNDED);
                    setSkillText("Your strike pierces true; the creature's heart essence dissolves.\n"); 
                }
                else {
                    setSkillText("The core retaliates; your energy is repelled.\n");
                }
            }
            case "Kepweng's Potion" -> {
                if (skillSuccess(90, skillRange)) {
                    vitals.setRitualGround(Vitals.RitualGround.BOUNDED);
                    setSkillText("The potion suppressed the creature's aura pulse; it is now stable.\n"); 
                }
                else {
                    setSkillText("You used the wrong potion; the creature has gone on a rampage.\n");
                }
            }
            case "Burn Herbs" -> {
                if (skillSuccess(90, skillRange)) {
                    vitals.setRitualGround(Vitals.RitualGround.BOUNDED);
                    setSkillText("The herbs smolder slowly; the air grows thick with acrid fumes.\n"); 
                }
                else {
                    setSkillText("The herbs fail to ignite properly; the smoke disperses harmlessly.\n");
                }
            }
            case "Ember Rite" -> {
                if (skillSuccess(90, skillRange)) {
                    vitals.setRitualGround(Vitals.RitualGround.BOUNDED);
                    setSkillText("The flames answer your call; the Ember Rite is fulfilled.\n"); 
                }
                else {
                    setSkillText("The power rejects your command; the creature's mind resists.\n");
                }
            }
            case "Invoke Fire" -> {
                if (skillSuccess(90, skillRange)) {
                    vitals.setRitualGround(Vitals.RitualGround.BOUNDED);
                    setSkillText("The fire surges and burns away lingering channeling.\n"); 
                }
                else {
                    setSkillText("The flames flicker out; channeling continues.\n");
                }
            }
            case "Holy Water" -> {
                if (skillSuccess(90, skillRange)) {
                    vitals.setRitualGround(Vitals.RitualGround.BOUNDED);
                    setSkillText("The water sizzles - corruption successfully fades. \n"); 
                }
                else {
                    setSkillText("You accidentally drank the water due to thirst\n");
                }
            }
            case "Spirit Bell" -> {
                if (skillSuccess(90, skillRange)) {
                    vitals.setRitualGround(Vitals.RitualGround.BOUNDED);
                    setSkillText("The bell's chime echoes - The creature collapses into silence.\n"); 
                }
                else {
                    setSkillText("You rang the wrong bell, Mamang Sorbetero is looking for it.\n");
                }
            }
            case "Sprinkle Salt" -> {
                if (skillSuccess(90, skillRange)) {
                    vitals.setRitualGround(Vitals.RitualGround.BOUNDED);
                    setSkillText("The salt purifies the essence; corruption fades.\n"); 
                }
                else {
                    setSkillText("You used iodized salt. Nothing happens.\n");
                }
            }
            case "Garlic Blast" -> {
                if (skillSuccess(90, skillRange)) {
                    vitals.setRitualGround(Vitals.RitualGround.BOUNDED);
                    setSkillText("The garlic fumes sting; possession weakens.\n"); 
                }
                else {
                    setSkillText("You tossed stale garlic; it had no effect.\n");
                }
            }
            case "Rosary" -> {
                if (skillSuccess(90, skillRange)) {
                    vitals.setRitualGround(Vitals.RitualGround.BOUNDED);
                    setSkillText("Hallelujah! Your faith has been restored and strengthened.\n"); 
                }
                else {
                    setSkillText("Your rosary snaps into pieces.\n");
                }
            }
            default -> {
                    System.out.println("Skill not implemented yet.");
            }
        }

        if (setVitals.getRitualGround() == Vitals.RitualGround.UNMARKED){
            this.skillRange = 500;
        }
        else if (setVitals.getRitualGround() == Vitals.RitualGround.CORRUPTED){
            this.skillRange = 150;
        }

        if (setVitals.getSpiritualVision() == Vitals.SpiritualVision.VEILED){
            this.lightRange = 0;
            vitals.setRitualGround(Vitals.RitualGround.UNMARKED);
        }
        else if (setVitals.getSpiritualVision() == Vitals.SpiritualVision.FLICKERING){
            this.lightRange = 150;
        }

        return false;
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
}
