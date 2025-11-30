package levels;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class StoryUtils {
    
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    public static boolean displayText(Scanner scanner, String text, int delay, boolean skipEffect) {
        clearScreen();
        
        if (skipEffect) {
            System.out.println(text);
        } else {
            char[] chars = text.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                System.out.print(chars[i]);
                System.out.flush();
                if (delay > 0 && i < chars.length - 1) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(delay);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
            System.out.println(); 
        }
        
        System.out.print("Press enter to continue...");
        String input = scanner.nextLine();
        
        return input.equalsIgnoreCase("s");
    }
}