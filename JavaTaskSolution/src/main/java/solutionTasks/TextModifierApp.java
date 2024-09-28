package solutionTasks;

import java.util.Scanner;
/*
* Пример ввода:
генрих1  играет+2   л-июбит0школу
Пример вывода:
генрих играет! илюбитшколу 3

Пример ввода №2:
Я ю-лбю-л джаву   всем сердцем+
Пример вывода:
Я люблю джаву всем сердцем!
*/


public class TextModifierApp {
    public static void main(String[] args) {
        String modifiedText = textModifier();
        System.out.println(modifiedText);
    }

    public static String textModifier() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст:");
        String inputText = scanner.nextLine();

        // Шаг 1: Убираем лишние пробелы
        StringBuilder sb = new StringBuilder();
        boolean lastCharWasSpace = false;

        for (char ch : inputText.toCharArray()) {
            if (ch == ' ') {
                if (!lastCharWasSpace) {
                    sb.append(ch);
                }
                lastCharWasSpace = true;
            } else {
                sb.append(ch);
                lastCharWasSpace = false;
            }
        }

        // Шаг 2: Обработка знака минус (-)
        StringBuilder sbWithSwaps = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            char current = sb.charAt(i);
            if (current == '-' && i > 0 && i < sb.length() - 1) {
                // Меняем местами символы слева и справа от минуса
                sbWithSwaps.setCharAt(sbWithSwaps.length() - 1, sb.charAt(i + 1));
                sbWithSwaps.append(sb.charAt(i - 1));
                i++; // Пропускаем следующий символ после минуса
            } else {
                sbWithSwaps.append(current);
            }
        }

        // Шаг 3: Замена плюсов (+) на восклицательные знаки
        StringBuilder sbWithReplacements = new StringBuilder();
        for (char ch : sbWithSwaps.toString().toCharArray()) {
            if (ch == '+') {
                sbWithReplacements.append('!');
            } else {
                sbWithReplacements.append(ch);
            }
        }

        // Шаг 4: Удаление цифр и подсчет их суммы
        int sumOfDigits = 0;
        StringBuilder finalResult = new StringBuilder();

        for (char ch : sbWithReplacements.toString().toCharArray()) {
            if (Character.isDigit(ch)) {
                sumOfDigits += Character.getNumericValue(ch);
            } else {
                finalResult.append(ch);
            }
        }

        // Если сумма цифр больше 0, добавляем её в конец строки
        if (sumOfDigits > 0) {
            finalResult.append(" ").append(sumOfDigits);
        }
        return finalResult.toString().trim();
    }
}