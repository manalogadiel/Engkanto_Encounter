<h1 align = "center">Engkanto Encounter 👻</h1>
<h3 align = "center">A development of a console application Strategy/Simulation game inspired by Filipino Mythical Creatures using Java</h3>
<p align = "center">
<b>CS 2101 </b> <br/>
Manalo, Gadiel Gospel L.<br/>
Tañedo, Russel Matthew A.<br/>
Trayco, Calvin Ives Joseph B.
</p>

## 📝 ┊ Overview
Engkanto Encounter is a Java console-based Myth/Strategy/Simulation game inspired by Filipino folklore.
You play as a mystic exorcist tasked with identifying, weakening, and exorcising powerful mythical creatures to stop the Engkanto—master of these entities.
<br/><br/>
The game contains two playable modes:
📜 Story Mode — Progress through multiple encounters while uncovering the lore.
☠️ Survival Mode — Fight endless waves of random creatures.
The system uses ritual-based mechanics, creature attributes, and dynamic combat states to create a strategic gameplay experience with the use of Object-oriented Programming (OOP) concepts.
<br/>

## 📚 ┊ Project Structure
```
📂 src/main
├── 📂 core/
│   ├── Battle.java
│   ├── Exorcist.java
│   ├── Game.java
│   └── Vitals.java
│
├── 📂 creatures/
│   ├── Creature.java
│   ├── Duwende.java
│   ├── Engkanto.java
│   ├── Kapre.java
│   ├── Manananggal.java
│   ├── Sirena.java
│   ├── Tikbalang.java
│   ├── Tiktik.java
│   ├── Tiyanak.java
│   └── WhiteLady.java
│
├── 📂 levels/
│   ├── Level.java
│   └── StoryUtils.java
│
├── 📂 modes/
│   ├── Story.java
│   ├── Survival.java
│   └── Main.java
│
└── README.md

```
## Main Package

- `Main.java` - Entry point of the program that initializes the game and starts the main game loop.

## Core Package

- `Game.java` - Manages the main menu, mode selection, and overall game flow.
- `Battle.java` - Handles battle mechanics, turn-based combat system, and win/lose conditions.
- `Exorcist.java` - Manages the player's skills, inventory, and skill execution logic.
- `Vitals.java` - Stores and manages creature statistics including enums for game states.

## Creatures Package

- `Creature.java` - Abstract base class defining common properties and methods for all creatures.
- `Duwende.java` - Duwende creature implementation with specific starting vitals.
- `WhiteLady.java` - White Lady creature implementation with specific starting vitals.
- `Tiyanak.java` - Tiyanak creature implementation with specific starting vitals.
- `Kapre.java` - Kapre creature implementation with specific starting vitals.
- `Tikbalang.java` - Tikbalang creature implementation with specific starting vitals.
- `Tiktik.java` - Tiktik creature implementation with specific starting vitals.
- `Manananggal.java` - Manananggal creature implementation with specific starting vitals.
- `Sirena.java` - Sirena creature implementation with specific starting vitals.
- `Engkanto.java` - Engkanto creature implementation (final boss) with specific starting vitals.

## Modes Package

- `Story.java` - Implements story mode with sequential level progression and narrative elements.
- `Survival.java` - Implements survival mode with randomized creature encounters.

## Levels Package

- `Level.java` - Manages individual story levels including narrative, battles, and progression.
- `StoryUtils.java` - Utility class for text display, screen clearing, and story animations.
  
### How to Run the Program
Requirements
Java JDK 8 or later
Open your terminal in the `src/main` folder and run:
```
javac Main.java core/*.java creatures/*.java levels/*.java modes/*.java
```
Run the program using:
```
java Main
```

## 🎮 ┊ Object-oriented Principles

## 📦 1. Encapsulation

The program uses **private fields** and **public getter/setter methods** to protect internal data. Classes like `Vitals`, `Exorcist`, and `Battle` hide their internal state and provide controlled access through methods. For example, `soulFlux` and `channeling` in the `Vitals` class can only be modified through `setSoulFlux()` and `setChanneling()`, preventing external classes from breaking game logic.

```java
private double soulFlux;
public double getSoulFlux() { return soulFlux; }
public void setSoulFlux(double soulFlux) { this.soulFlux = soulFlux; }
```

---

## 🧬 2. Inheritance

All nine creatures extend the abstract `Creature` base class, inheriting common properties (`name`, `vitals`, `exorcist`) and methods (`getName()`, `getVitals()`, `showVitals()`). Each creature implements the abstract `setStartingVitals()` method to define unique starting statistics, eliminating code duplication while maintaining consistent structure.

```java
public abstract class Creature {
    protected abstract void setStartingVitals();
}

public final class Manananggal extends Creature {
    public Manananggal() {
        super("Manananggal");
        setStartingVitals();
    }
}
```

---

## 🔄 3. Polymorphism

The program treats different creature types uniformly through the `Creature` interface. The `Battle` class accepts any creature type, and arrays can hold mixed creature subclasses. In Survival mode, a random creature is selected at runtime and handled seamlessly without special cases for each type.

```java
Creature[] creatures = { new Duwende(), new WhiteLady(), new Manananggal() };
Creature encounter = creatures[random.nextInt(creatures.length)];
Battle battle = new Battle(encounter, exorcist);
```

---

## 🎭 4. Abstraction

The abstract `Creature` class defines contracts without dictating implementation. Complex game mechanics are hidden behind simple method calls—`battle.start()` hides battle logic, `exorcist.useSkill()` abstracts 15 different skills, and `Game` methods hide menu systems. The `Vitals` class uses enums for readable game states instead of raw integers.

```java
Game game = new Game();
game.displayIntro();
game.start();
```

---

<div align="center">

**💡 These OOP principles make Engkanto Encounter modular, maintainable, and ready for expansion**

</div>

## ⚙️ ┊ Main Menu Example Output
```
╔═══════════════════════════════════════╗
║ ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓ ║
║ ▓▓▓       ENGKANTO ENCOUNTER      ▓▓▓ ║
║ ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓ ║
╚═══════════════════════════════════════╝
╔═══════════════════════════════════════╗
║             MODE SELECT               ║
╚═══════════════════════════════════════╝
[1] Survival Mode
[2] Story Mode
[3] Exit
Enter your choice:
```

## 🗡️ ┊ Battle Example Output
```
The Tikbalang stands guard at the crossroads, confusing directions.

Aura Pulse: CORRUPTED     Consciousness: AWAKENED
Soul Flux: 80.00°         Ritual Ground: UNMARKED
Pyric Marks: 0            Spiritual Vision: VEILED
Essence: 1 Uncorrupted, 1 Possessed

The veil lifts; the creature's true form manifests before you.
[ 1] Draw Circle         [ 2] Essence Chamber     [ 3] Chant Prayer        [ 4] Heartbane           [ 5] Kepweng's Potion     
[ 6] Third Eye           [ 7] Burn Herbs          [ 8] Ember Rite          [ 9] Invoke Fire         [10] Holy Water
[11] Light Candle        [12] Spirit Bell         [13] Sprinkle Salt       [14] Garlic Blast        [15] Rosary

Choose a skill number to use (1-15) or 'E' to exit:
```

##  👨🏻‍💻 ┊ Contributors

<table>
<tr>
    <th> &nbsp; </th>
    <th> Name </th>
    <th> Role </th>
</tr>
<tr>
    <td><img src="static/manalogadiel.jpg" width="100" height="100"> </td>
    <td><strong>Gadiel Gospel L. Manalo</strong> <br/>
    <a href="https://github.com/manalogadiel" target="_blank">
    <img src="https://img.shields.io/badge/GitHub-%23121011.svg?logo=github&logoColor=white" alt="mmanalogadiel's GitHub">
        </a>
    </td>
    <td>Project Leader/System Architect</td>
</tr>
<tr>
    <td><img src="static/russcod3.jpg" width="100" height="100"> </td>
    <td><strong>Russel Mattew A. Tañedo</strong> <br/>
    <a href="https://github.com/russcod3" target="_blank">
    <img src="https://img.shields.io/badge/GitHub-%23121011.svg?logo=github&logoColor=blue" alt="russcod3's GitHub">
        </a>
    </td>
    <td>File Handling Specialist</td>
</tr>
<tr>
    <td><img src="static/sevi10096.jpg" width="100" height="100"> </td>
    <td><strong>Calvin Ives Joseph B. Trayco</strong> <br/>
    <a href="https://github.com/dsevi10096" target="_blank">
    <img src="https://img.shields.io/badge/GitHub-%23121011.svg?logo=github&logoColor=green" alt="sevi10096's GitHub">
        </a>
    </td>
    <td>Feature Developer</td>
</tr>
</table>

## 🤝🏻 ┊ Acknowledgment
We would like to express our gratitude Ms. Fatima Marie P. Agdon for her guidance throughout this project, introducing us to object-oriented programming and breaking down the four principles in a way that made sense. We appreciate all the time she invested in making sure we understood the material.
We're also grateful to our classmates who made this semester more enjoyable. The late-night coding sessions, debugging help, and shared frustrations and victories! made this project feel less overwhelming. Thank you for keeping things fun even when the code wasn't cooperating!

## 🚀 ┊ Future Enhancements
- High Score System for Survival Mode
- Level Checkpoints for Story Mode
- Expanded creature roster
- GUI version using JavaFX or Swing
- Improved balancing and AI behavior
---
# More Information
## Engkanto Encounter 👻
A development of a console application Strategy/Simulation game inspired by Filipino Mythical Creatures using Java.

Dive into the cursed world engulfed by powerful mythical creatures standing between you and their master - The Engkanto. 
Bestowed with skills of sorcery and divine prowess, you are the only hope left in these lands so make your choice. 
Strategically uncover all levels of the mysteries behind this lore (Story mode) or go straight to slaying waves of countless monsters (Survival mode)

# GAME: ENGKANTO ENCOUNTER
GAME THEME/GENRE : Myth/Strategy/Simulation

# ⚔️ Ritual Abilities and Items
💧 **Holy Water**
> Purifies the Ritual Ground to vanish signs or clues of the encountered Engkanto. Used to **finish off the exorcism**.

🧪 **Kepweng’s Potion**
> **Lowers Aura Pulse**. Only available when pulse is **Chaotic**.

⭕ **Draw Circle**
> **Bounds the ground** for a battle to settle. Unbounded ground allows the Creature to escape easily.

🕯️ **Light Candle**
> **Increases visibility** to the Creature.

👁️ **Third Eye**
> **Identifies the hidden Creature**. Use only when the Creature is **Unknown**.

🔔 **Spirit Bell**
> Makes the creature **unconscious** to use Ember Rite successfully.

🔥 **Ember Rite**
> Gains access to Special Skills and Heartbane. Use only when consciousness is **dormant**. Adds Pyric Mark count.

🫙 **Essence Chamber**
> A container to access Herbs that **increase Soul Flux** index.

🌿 **Burn Herbs**
> **Increases Soul Flux**. Keep it high for success.

💔 **Heart Bane**
> When Ember Rite succeeded, this may be accessible to **kill the core** (not a means to complete exorcism).

🙏 **Chant Prayer**
> Used after Pyric Marks/Enchanted Elements (Salt/Garlic). Decreases **Pyric Marks** and reduces **Channeling**.

🧂 **Sprinkle Salt**
> Decreases **uncorrupted aura**.

💥 **Garlic Blast**
> Decreases **Possession strength of aura** as well as **aura pulse**. Using this first is better.

🌋 **Invoke Fire**
> Reduces **Channeling** (less effective than Chant Prayer).

📿 **Rosary**
> Used when divine faith is wavering or falters.



