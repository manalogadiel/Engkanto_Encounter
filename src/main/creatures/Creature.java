package creatures;

import core.Vitals;

public abstract class Creature {
    protected String name;
    protected Vitals vitals;

    public Creature(String name) {
        this.name = name;
        this.vitals = new Vitals(); // default, can override later
        
    }

    // Each creature will define its own starting vitals
    protected abstract void setStartingVitals();

    public String getName() {
        return name;
    }

    public Vitals getVitals() {
        return vitals;
    }

    public void showVitals() {
        System.out.printf(
            "%-25s %-25s%n",
            "Aura Pulse: " + vitals.getAuraPulse(),
            "Consciousness: " + vitals.getConsciousness()
        );
        System.out.printf(
            "%-25s %-25s%n",
            "Soul Flux: " + vitals.getSoulFlux() + "°",
            "Ritual Ground: " + vitals.getRitualGround()
        );
        System.out.printf(
            "%-25s %-25s%n",
            "Pyric Marks: " + vitals.getPyricMarks(),
            "Spiritual Vision: " + vitals.getSpiritualVision()
        );
    
            if (vitals.getUncorrupted() > 0 || vitals.getPossessed() > 0) {
                System.out.println("Essence: " + vitals.getUncorrupted() + " Uncorrupted, " + vitals.getPossessed() + " Possessed");
            }

            if (vitals.getChanneling()) {
                System.out.println("\nThe creature is channeling its energy!");
            }
    }

    @Override
    public String toString(){
        return name;
    }
}
