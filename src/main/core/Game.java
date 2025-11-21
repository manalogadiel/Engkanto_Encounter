package core;

import java.util.Scanner;
import modes.Survival;

public class Game {
    Survival survival = new Survival();
    public void start() {
        printBanner();
        showMenu();
    }

    private void printBanner() {
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║ ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓ ║");
        System.out.println("║ ▓▓▓       ENGKANTO ENCOUNTER      ▓▓▓ ║");
        System.out.println("║ ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓ ║");
        System.out.println("╚═══════════════════════════════════════╝");
    }

    private void showMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
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
                        case 2 -> System.out.println("Starting Story Mode...");
                        case 3 -> System.out.println("Exiting game. Goodbye!");
                        default -> System.out.println("Invalid choice! Please select 1-3.");
                    }
                } catch (InterruptedException e) {
                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }
        }
    }  

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }   
}
