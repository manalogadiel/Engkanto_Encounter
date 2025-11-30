package core;

import java.util.Scanner;
import modes.*;

public class Game {
    Survival survival = new Survival();
    Story2 story = new Story2();
    private boolean exitTriggered = false;
    private final Scanner scanner = new Scanner(System.in); // Create ONE scanner

    public boolean isExitTriggered() {
        return exitTriggered;
    }
    
    public void start() {
        try (scanner) {
            while (!exitTriggered) {
                clearScreen();
                printBanner();
                showMenu();
            }
            // Close scanner only when game ends
        }
    }

    private void printBanner() {
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║ ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓ ║");
        System.out.println("║ ▓▓▓       ENGKANTO ENCOUNTER      ▓▓▓ ║");
        System.out.println("║ ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓ ║");
        System.out.println("╚═══════════════════════════════════════╝");
    }

    private void showMenu() {
        int choice;
        
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║             MODE SELECT               ║");
        System.out.println("╚═══════════════════════════════════════╝");
        System.out.println("[1] Survival Mode");
        System.out.println("[2] Story Mode");
        System.out.println("[3] Exit");
        System.out.print("Enter your choice: ");
        
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            scanner.nextLine(); 
            clearScreen();
            try {
                switch (choice) {
                    case 1 -> {
                        System.out.println("Starting Survival Mode.");
                        Thread.sleep(800);
                        clearScreen();
                        System.out.println("Starting Survival Mode..");
                        Thread.sleep(800);
                        clearScreen();
                        System.out.println("Starting Survival Mode...");
                        Thread.sleep(800);
                        clearScreen();
                        survival.start();
                    }
                    case 2 -> {
                        System.out.println("Starting Story Mode...");
                        Thread.sleep(800);
                        clearScreen();
                        story.start();
                    }
                    case 3 -> {
                        System.out.println("Exiting game. Goodbye!");
                        exitTriggered = true;
                    }
                    default -> { 
                        System.out.println("Invalid choice! Please select 1-3.");
                        waitForEnter();
                    }
                }
            } 
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } else {
            System.out.println("Invalid input! Please enter a number.");
            scanner.nextLine(); 
            waitForEnter();
        }
    }

    public void waitForEnter() {
        System.out.print("Press Enter to continue...");
        scanner.nextLine(); 
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }   
}