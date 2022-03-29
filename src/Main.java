import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Программа ищет в тескте аббревиатуры вида: "Б.Б.Б.Б." (где Б - буква) и предлагает пользователю самому ввести строку для замены.
 *
 * @author     Sergey Nikolaev
 */
public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder("Flew in from Miami Beach B.O.A.C.\n" +
                                                        "Didn't get to bed last night\n" +
                                                        "On the way the paper bag was on my knee\n" +
                                                        "Man, I had a dreadful flight\n" +
                                                        "\n" +
                                                        "I'm back in the U.S.S.R.\n" +
                                                        "You don't know how lucky you are\n" +
                                                        "Back in the U.S.S.R.");
        stringBuilder.append(" (Yeah!)\n");
        stringBuilder.insert(stringBuilder.indexOf("\nBack in the U.S.S.R."), ", boy");
        System.out.println("Было:\n" + stringBuilder);

        Pattern p = Pattern.compile("([A-Za-z_]\\.){4}");
        Matcher m = p.matcher(stringBuilder);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(m.find()){
            String findString = m.group();
            System.out.println("Найдена аббревиатура: " + findString + "\nВведите чем заменить");
            String s = reader.readLine();
            do {
                stringBuilder.replace(stringBuilder.indexOf(findString), stringBuilder.indexOf(findString) + 8, s);
            } while (stringBuilder.indexOf(findString) > -1);
            m = p.matcher(stringBuilder);
        }
        reader.close();
        System.out.println("\nСтало:\n" + stringBuilder);
    }
}
