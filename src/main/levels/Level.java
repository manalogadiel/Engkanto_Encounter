package levels;

import core.Battle;
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

    public void play(Scanner scanner, int delay) {
        boolean skipNext = false; 

        for (String line : storyLines) {
            skipNext = StoryUtils.displayText(scanner, line, delay, skipNext);
        }

        Battle battle = new Battle(creature);
        battle.start();

        StoryUtils.displayText(scanner, shardText, delay, false);
    }
}