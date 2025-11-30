package levels;

import core.Battle;
import core.Exorcist;
import core.Game;
import creatures.Creature;
import java.util.Scanner;

public class Level {
    private final String[] storyLines;
    private final Creature creature;
    private final String shardText;

    public Level(String[] storyLines, Creature creature, String shardText) {
        this.storyLines = storyLines;
        this.creature = creature;
        this.shardText = shardText;
    }

    public boolean play(Scanner scanner, int delay) {
        boolean skipNext = false; 
        Exorcist storyExorcist = new Exorcist();
        boolean storyLost = false;
        boolean returnToMenu = false;
        boolean userExitedGame = false;

        for (String line : storyLines) {
            skipNext = StoryUtils.displayText(scanner, line, delay, skipNext);
        }
        while (!storyLost && !returnToMenu && !userExitedGame) {
            storyExorcist.resetForBattle();
            Battle battle = new Battle(creature, storyExorcist);
            battle.start();

            if (battle.didUserExit()) {
                System.out.println("Exiting level...");
                userExitedGame = true;
                returnToMenu = true;
            }
            else if (storyExorcist.getGameLose()) {
                displayDefeatMessage(creature.getName());
                Game game = new Game();
                game.waitForEnter();
                game.clearScreen();
                System.out.println("What would you like to do?");
                System.out.println("[1] Try again");
                System.out.println("[2] Exit game");
                System.out.print("Choose an option: ");
                
                String choice = scanner.nextLine().trim();
                
                if (choice.equals("2")) {
                    System.out.println("Thanks for playing! The creatures continue to terrorize the world...");
                    returnToMenu = true;
                }
                // If choice is "1" or anything else, loop continues and battle restarts
                if (returnToMenu) {
                    System.out.println("RESTARTING LEVEL...");
                }
                
            }
            else {
                StoryUtils.displayText(scanner, shardText, delay, false);
                storyLost = true; 
            }
        }
        return storyLost && !returnToMenu && !userExitedGame;
    }

    private void displayDefeatMessage(String creatureName) {
        switch (creatureName.toLowerCase()) {
            case "duwende" -> {
                System.out.println("\nThe Duwende laughs mockingly as you fall.");
                System.out.println("\"Hah! Akala mo kaya mo ako? Babalik ako sa aking punso!\"");
            }
            case "white lady" -> {
                System.out.println("\nThe White Lady's cold hands drain your life force.");
                System.out.println("\"Isa ka na namang lalaking natalo! Wala kayong kwenta!\"");
            }
            case "engkanto" -> {
                System.out.println("\nThe Engkanto stands triumphant over your defeated body.");
                System.out.println("\"Mahina ka pa para harapin ang hari ng mga lamang-lupa!\"");
            }
            case "kapre" -> {
                System.out.println("\nThe Kapre blows smoke on your unconscious body.");
                System.out.println("\"Hmph! Dapat di ka na nagpakita ng tapang na di mo naman kaya.\"");
            }
            case "manananggal" -> {
                System.out.println("\nThe Manananggal feasts on your defeat.");
                System.out.println("\"KEKEKEK! Sabi sayo eh! Mas malakas ako kesa kay Tiktik!\"");
            }
            case "tiyanak" -> {
                System.out.println("\nThe Tiyanak reveals its true form as you fall.");
                System.out.println("\"MAMA! MAMA! Natalo ko siya! GUSTO KO PA NG DUGONG TAO!\"");
            }
            case "tikbalang" -> {
                System.out.println("\nThe Tikbalang tramples over your defeated body.");
                System.out.println("\"NEIGHHHH!! Dapat di ka na naglakas-loob na humarap sa akin!\"");
            }
            case "sirena" -> {
                System.out.println("\nThe Sirena drags your unconscious body to the depths.");
                System.out.println("\"Ang bango-bango mo! Gagawin kitang alay sa ilog!\"");
            }
            case "tiktik" -> {
                System.out.println("\nThe Tiktik prepares to feast on you.");
                System.out.println("\"HAHAHA! Sariwang laman! Busog na busog ako ngayong gabi!\"");
            }
            default -> System.out.println("\nThe " + creatureName + " stands victorious over your defeat.");
        }
    }
}