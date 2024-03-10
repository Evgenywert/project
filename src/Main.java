import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.print("Введите выражение (например, 2 + 3): ");
                String input = scanner.nextLine();

                String result = calculate(input);
                System.out.println("Результат: " + result);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }


    static String calculate(String input) {
        try {
            String[] tokens = input.split(" ");
            if (tokens.length != 3) {
                throw new IllegalArgumentException("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)\n");
            }

            int num1 = Integer.parseInt(tokens[0]);
            int num2 = Integer.parseInt(tokens[2]);
            String operator = tokens[1];

            validateNumbers(num1, num2);

            int result = performOperation(num1, num2, operator);
            return String.valueOf(result);
        } catch (IllegalArgumentException e) {
            if (input.matches("^[0-9]+$")) {
                throw new IllegalArgumentException("throws Exception //т.к. строка не является математической операцией\n");
            } else {
                throw e;
            }
        }
    }

    static void validateNumbers(int num1, int num2) {
        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new IllegalArgumentException("Числа должны быть от 1 до 10 включительно");
        }
    }

    static int performOperation(int num1, int num2, String operator) {
        switch (operator) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/": return num1 / num2;
            default: throw new IllegalArgumentException("Неподдерживаемая операция");
        }
    }
}
