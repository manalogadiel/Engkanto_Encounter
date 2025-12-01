package creatures;

import core.Exorcist;
import core.Vitals;

public abstract class Creature {
    protected String name;
    protected Vitals vitals;
    protected Exorcist exorcist;

    public Creature(String name) {
        this.name = name;
        this.vitals = new Vitals();
        this.exorcist = new Exorcist();
    }

    protected abstract void setStartingVitals();

    public String getName() {
        return name;
    }

    public Vitals getVitals() {
        return vitals;
    }
    
    public Exorcist getExorcist() {
        return exorcist;
    }

    public void resetVitals() {
        setStartingVitals();
        exorcist.resetForBattle();
    }
    public void showBane(){
        System.out.println("Heart Bane used: " + exorcist.getHeartBaneUsed());
    }
    public void showVitals() {
        System.out.printf(
            "%-25s %-25s%n",
            "Aura Pulse: " + vitals.getAuraPulse(),
            "Consciousness: " + vitals.getConsciousness()
        );
        System.out.printf(
            "%-25s %-25s%n",
            String.format("Soul Flux: %.2f°", vitals.getSoulFlux()),
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

        if (vitals.getChanneling() <= 1) {
            System.out.println("\nThe creature is channeling a catastrophic amount of energy.");
        } else if (vitals.getChanneling() <= 5) {
            System.out.println("\nThe creature is channeling its energy!");
        }
        if (vitals.getFaithStateValue() >= 2 && vitals.getFaithStateValue() <= 4) {
            System.out.println("Your Divine faith starts to waver out of fear.");
        } else if (vitals.getFaithStateValue() <= 1) {
            System.out.println("The creature is showing signs of faltering in its faith.");
        }
    }

    @Override
    public String toString(){
        return name;
    }
}
