package com.mahmoud.GradingCalculator;

public class Main {
    public static void main(String[] args) {
        int convertFrom, convertTo;
        String[] result;

        MenuHandler menuHandler = new MenuHandler();
        InputHandler inputHandler = new InputHandler();

        menuHandler.convertFromPrintStatements();
        convertFrom = inputHandler.handle(3);

        if (convertFrom != 0) {
            menuHandler.convertToPrintStatements(convertFrom);
            convertTo = inputHandler.handle(2);

            result = menuHandler.convertToHandler(convertFrom - 1, convertTo - 1);

            if (result[1].isEmpty()) {
                System.out.println("\nInvalid Grade!");
            } else {
                System.out.println("\nYour " + result[0] + " is: '" + result[1] + "'");
            }
        }

        System.out.println("\n*** *** ***");

        inputHandler.closeScanner();
    }
}
