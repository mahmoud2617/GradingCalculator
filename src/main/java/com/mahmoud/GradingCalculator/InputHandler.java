package com.mahmoud.GradingCalculator;

import java.util.Scanner;

public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public int handle(int numOfChoices) {
        String input;
        int value;

        do {
            System.out.print("---> ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                return 0;
            } else {
                try {
                    value = Integer.parseInt(input);
                    if (value >= 1 && value <= numOfChoices) {
                        break;
                    }
                } catch (Exception ignored) {
                }
            }

            System.out.println("\nInvalid Input. Please try again (q to quit).");

        } while (true);

        return value;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void closeScanner() {
        scanner.close();
    }
}
