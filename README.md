# Engkanto Encounter 👻
A development of a console application Strategy/Simulation game inspired by Filipino Mythical Creatures using Java.

Dive into the cursed world engulfed by powerful mythical creatures standing between you and their master - The Engkanto. 
Bestowed with skills of sorcery and divine prowess, you are the only hope left in these lands so make your choice. 
Strategically uncover all levels of the mysteries behind this lore (Story mode) or go straight to slaying waves of countless monsters (Survival mode)

# GAME: ENGKANTO ENCOUNTER
GAME THEME/GENRE : Myth/Strategy/Simulation

SAMPLE ONSCREEN LAYOUT (Prototype):
```
A flying Manananggal has been identified on the roof.
	Aura Pulse: Chaotic		Consciousness: Awakened
	Soul Flux: 108°			 Ritual Ground: Bounded
	Pyric Marks: 0			 Spiritual Vision: Visible
	
Pulse is rapid.
Soul is slowly Heating up.
The creature is channeling its energy.

You’ve used light candles, the spirit is Crystal Clear.
	
[Draw Circle]	[Essence Chamber]	[Chant Prayer]	[Heartbane]	[Kepweng’s Potion]
[Third Eye]	[Burn Herbs]	[Ember Rite]	[Invoke Fire]	[Holy Water]
[Light Candle]	[Spirit Bell]	[Sprinkle Salt]	[Garlic Blast]	[FORFEIT]
```
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
> Decreases **Possession strength of aura**. Using this first is better.

🌋 **Invoke Fire**
> Reduces **Channeling** (less effective than Chant Prayer).

🚪 **Forfeit**
> Immediately ends the encounter.

# STRUCTURE (Prototype):
```
#Starting text of hidden and visible Creature
	#Vitals of the Creature
Aura Pulse: Chaotic		Consciousness: Awakened
	Soul Flux: 108°			Ritual Ground: Bounded
	Pyric Marks: 0			Spiritual Vision: Visible
	#May include Aura: 2 Uncorrupted, 1 Possessed (depends on the creature)
	
#Some important clues
Pulse is rapid.
Soul is slowly Heating up.
The creature is channeling its energy.

#Basically what you did
You’ve used light candles, the spirit is Crystal Clear.

#Skills/Equipments, currently…
[Draw Circle]	[Essence Chamber]	[Chant Prayer]	[Heartbane]	[Kepweng’s Potion]
[Third Eye]	[Burn Herbs]	[Ember Rite]	[Invoke Fire]	[Holy Water]
[Light Candle]	[Spirit Bell]	[Sprinkle Salt]	[Garlic Blast]	[FORFEIT]
```


