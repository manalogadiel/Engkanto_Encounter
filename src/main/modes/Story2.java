package modes;

import core.Battle;
import creatures.*;
import java.util.Scanner;
import levels.*;

public class Story2 {
    private final Scanner scanner;
    private final int delay = 40;

    private final Creature[] creatures = {
            new Duwende(), new WhiteLady(), new Engkanto(),
            new Kapre(), new Manananggal(), new Tiyanak(),
            new Tikbalang(), new Sirena(), new Tiktik()
    };

    private final Level[] levels = {
            // LEVEL 1 - Duwende
            new Level(new String[]{
                    "As you enter the Mirkwood forest, a small figure steps out of a hollow log.",
                    "Duwende: Hoy tao, muntik mo nang maapakan ang aking punso!",
                    "As he pointed to a mound of dirt on the ground.",
                    "You noticed a glowing shard, sticking out of that mound.",
                    "You: Akin na ang hiyas na iyan!",
                    "Duwende: Peste! kunin mo kung kaya mo."
            }, creatures[0], "Duwende: Sige kunin mo. Pero ngayong hawak mo na yan, mamamataan ka na ng iba at siguradong di na tatagal ang buhay mo.\nYou obtained a ring's shard (1/8)."),

            // LEVEL 2 - Sirena
            new Level(new String[]{
                    "As you continue your journey, you stop by a lake to drink some water.",
                    "As you drink, a figure rises from the water, humming a lullaby with her godly voice.",
                    "Sirena: Tao, naglalakas-loob kang uminom sa aking tubig na para bang pagmamay-ari mo ito.",
                    "You: Hindi mo pagmamay-ari ang ilog na ito. Bumalik ka na sa pinanggalingan mo at itigil ang paghihimagsik sa lugar na ito!",
                    "While conversing, you noticed a shard gleaming among her scales.",
                    "Sirena: Tinitingnan mo ba ang napakaganda kong hiyas?",
                    "You: Ibigay mo sa akin iyan, kung hindi ay pwersahan ko yang kukunin mula sa'yo!",
                    "Sirena: Subukan mo!"
            }, creatures[7], "Sirena: Nakaligtas ka sa pagkakataong ito.\nYou obtained a ring's shard (2/8)."),

            // LEVEL 3 - Tiyanak
            new Level(new String[]{
                    "You carry on with your quest after a short break, then suddenly you hear a loud cry.",
                    "???: MAMA! MAMA!",
                    "You: Sanggol ba yun? anong ginagawa ng sanggol sa ganitong lugar at sa ganitong oras?",
                    "You finally found the source of those cries, it was an infant lying down on a stone as it cries for its mother.",
                    "You: Baby, tahan na, baka marinig tayo ng mga lamang lupa!"
            }, creatures[5], "You: Muntik mo na akong malinlang!\nYou obtained a ring's shard (3/8)."),

            // LEVEL 4 - Kapre
            new Level(new String[]{
                    "After 3 consecutive battles against forces of evil, it's time to take a proper rest.",
                    "While laying down beneath an acacia tree, piping hot ashes fell on your cheeks. You screamed in agony.",
                    "You: Aray! Tubig! Tubig!",
                    "You looked up and saw a towering Kapre smoking a cigar.",
                    "Kapre: Ikaw ba ang pumaslang sa tiyanak?!",
                    "You: Oo, at ikaw na ang isusunod ko."
            }, creatures[3], "Kapre: Ito bang hiyas ang pakay mo? Sige sa'yo na, tutal wala na akong lakas para panghawakan yan.\nYou obtained a ring's shard (4/8)."),

            // LEVEL 5 - Tiktik
            new Level(new String[]{
                    "You continued to pursue your mission until you arrived in the baryo in the middle of Mirkwood forest.",
                    "The baryo is empty, all of the locals have left due to the actions of the evil creatures.",
                    "Then suddenly, you heard a loud cry coming from a house.",
                    "Lady: AHHHH!!",
                    "You: Bakit di ka pa umaalis sa lugar na ito?",
                    "Lady: Hinihintay ko dumating ang asawa ko, sabi niya kase mangingisda muna siya sa ilog para may pagkain kaming mababaon.",
                    "You: Galing ako sa ilog, at wala akong nakitang tao doon.",
                    "Lady: Jusko po ang asawa ko, baka nahila na siya ng sirena!",
                    "Lady: Aray! Manganganak na yata ako!",
                    "A loud crash on the roof suddenly interrupted your conversation.",
                    "You: Diyan ka lang, ako na ang bahala.",
                    "Tiktik: HAHAHA. Dalawang tao at isang sariwang sanggol ang paparating. Mukhang mabubusog ako ngayong gabi ah!",
                    "You: Lumayas ka dito, huwag mong papakealaman ang babaeng iyon at ang anak niya!",
                    "Tiktik: Papalag kaba? Sige, pagkatapos kitang kainin, isusunod ko naman yung dalawa sa loob bilang pang himagas. HAHAHA!"
            }, creatures[8], "Tiktik: Hindi to maaari, tao ka lang!\nYou: Akin na itong hiyas na hawak mo.\nLady: Maraming salamat sa pag protekta sa akin at sa aking sanggol.\nYou: Bilisan nyo, umalis na kayo sa baryong ito.\nYou obtained a ring's shard (5/8)."),

            // LEVEL 6 - Manananggal
            new Level(new String[]{
                    "After the woman left with her baby, you began to search the baryo, making sure that no one else had stayed behind.",
                    "As you seek through the village, you notice something flying over you, observing your every action.",
                    "You: Magpakita ka, Manananggal! alam kong nandiyan ka!",
                    "Manananggal: KEKEKEK! Ang lakas ng loob mo na hamunin ako! Hindi porket natalo mo si Tiktik ay kaya mo na rin ako! KEKEKEK!",
                    "You: Kahit gaano ka pa kalakas, parehas lang kayo ng kahahantungan ng Tiktik na iyon, kaya naman ilabas mo na ang hiyas!",
                    "Manananggal: KEKEKEK! Gusto mo ang hiyas? Edi kunin mo sakin kung kaya mo! KEKEKEK!"
            }, creatures[4], "Manananggal: Ang pakpak ko! Anong ginawa mo sa pakpak ko! AHHHHHHHH!\nYou obtained a ring's shard (6/8)."),

            // LEVEL 7 - White Lady
            new Level(new String[]{
                    "Your quest still stands, you are now travelling in a path made by the locals. Then suddenly, you heard echoes of a voice.",
                    "???: Tulong - long - long ......",
                    "You: Ano yun? Nasan ka?",
                    "You saw a woman in a white dress standing still in the middle of the path.",
                    "Then you approached and urged her to get out of Mirkwood immediately.",
                    "You saw her face, covered in blood, her eyes red, and her skin, pale like a corpse's.",
                    "She took a hold of your neck and tried to choke you to death.",
                    "White Lady: LALAKE! ISA PANG LALAKE? PAPATAYIN KO LAHAT NG LALAKE SA MUNDONG ITO!"
            }, creatures[1], "White Lady: Hindi ako titigil hangga't hindi namamatay lahat ng lalake!\nYou: Ikaw pala ang pumatay sa asawa ng buntis na babaeng iyon. Akin na ang hiyas na ito.\nYou obtained a ring's shard (7/8)."),

            // LEVEL 8 - Tikbalang
            new Level(new String[]{
                    "You: Isang hiyas na lamang, magkakaroon na ako ng pagkakataon na harapin ang Engkanto.",
                    "THUD… thud… THUD",
                    "Something suddenly tackled you, forcing you to get thrown on the ground.",
                    "You: A-aray ko! Ano yun!",
                    "THUD… thud… THUD",
                    "Another tackle comes charging towards you, but this time you managed to dodge it.",
                    "Tikbalang: NEIGHHHH!! Mahinang nilalang! Ako na ang tatapos sayo! NEIGHHHH!",
                    "You: Nasa'yo ang huling hiyas, tama ba?!",
                    "Tikbalang: Oo, at mananatili ito sa'kin!"
            }, creatures[6], "Tikbalang: Engkanto! patawarin mo ang kahinaan namin!\nYou obtained a ring's shard (8/8).")
    };

    
    public Story2() {
        this.scanner = new Scanner(System.in);
    }

    public void start() throws InterruptedException {
        StoryUtils.clearScreen();
        System.out.println("Quick Tip: Use [s + enter] to skip animation...");
        Thread.sleep(1000);
        StoryUtils.clearScreen();
        System.out.println("Quick Tip: Use [s + enter] to skip animation..");
        Thread.sleep(1000);
        StoryUtils.clearScreen();
        System.out.println("Quick Tip: Use [s + enter] to skip animation.");
        Thread.sleep(1000);
        StoryUtils.clearScreen();
        

        // Story intro
        String[] introLines = {
            "Long ago, the Engkanto forged the Ring of Dominion. This relic gave him power to command any creature of the supernatural realm.",
            "To conquer the human world, he shattered the ring into seven shards and gave one to each of his loyal creatures.",
            "Each shard amplifies their nature, gives them new overwhelming powers, and binds them to the Engkanto's will.",
            "These creatures are not guardians.",
            "They are his generals - vicious, hungry, territorial, and proud enemies of humankind.",
            "You must kill each one, take their shard, and forge your way into the Engkanto's lair before its too late."
        };
        
        boolean skipNext = false;
        for (String line : introLines) {
            skipNext = StoryUtils.displayText(scanner, line, delay, skipNext);
        }

        // Play all levels
        for (int i = 0; i < levels.length; i++) {
            System.out.println("\nLEVEL " + (i + 1) + "\n");
            levels[i].play(scanner, delay); 
        }

        // Final battle
        System.out.println("\nFINAL BOSS\n");
        Battle finalBattle = new Battle(creatures[2]);
        finalBattle.start();

        String[] endingLines = {
            "After Battle:",
            "The Engkanto collapses to the ground.",
            "The twisted forest begins to settle, the shadows retreating.",
            "The ring in your hand pulses one last time until it turns into just a regular old beaten ring."
        };
        
        skipNext = false;
        for (String line : endingLines) {
            skipNext = StoryUtils.displayText(scanner, line, delay, skipNext);
        }
    }
}