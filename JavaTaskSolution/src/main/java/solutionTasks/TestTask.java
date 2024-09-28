package solutionTasks;

/*
* Доработайте метод/функцию таким образом,
 * чтобы она преобразовала слова, разделенные тире/подчеркиванием,
 * в верблюжий регистр. Первое слово в выходных данных должно быть написано с заглавной буквы,
 * только если исходное слово было написано с заглавной буквы (так называемый верхний
 * регистр Camel, также часто называемый регистром Pascal).
 * Следующие слова всегда следует писать с заглавной буквы.

Examples
"the-stealth-warrior" gets converted to "theStealthWarrior"

"The_Stealth_Warrior" gets converted to "TheStealthWarrior"

"The_Stealth-Warrior" gets converted to "TheStealthWarrior"

*/
public class TestTask {
    public static void main(String[] args) {
        System.out.println(lineModeration("The_Stealth-Warrior"));
        System.out.println(lineModeration("The_Stealth-Warrior"));
        System.out.println(lineModeration("the-stealth-warrior"));

    }

    public static String lineModeration(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);

        for (int i = 0; i < stringBuilder.length(); i++) {
            char current = stringBuilder.charAt(i);
            if (current == '-' || current == '_') {
                stringBuilder.deleteCharAt(i);
//            получить заглавную букву после - тире
                char nextLetter = stringBuilder.charAt(i + 1);
                Character.toUpperCase(nextLetter);
                stringBuilder.setCharAt(i + 1, nextLetter);
            }
        }


        return stringBuilder.toString();
    }
//        for (int i = 0; i < stringBuilder.length(); i++) {
////            char current = stringBuilder.charAt(i);
//
//            if (stringBuilder.charAt(i) == '-') {
//                stringBuilder.deleteCharAt(stringBuilder.charAt(i));
//            }
//        }


}
