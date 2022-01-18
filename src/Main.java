import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        StringBuilder str = new StringBuilder();
        str.append("+79261232233");
        str.append("+79263213322");
        str.insert(str.indexOf("+",1), " "); // 12
        str.insert(str.indexOf(" "), " mymail@gmail.com");

        Pattern pattern1 = Pattern.compile("\\+\\d{7}");
        Matcher matcher1 = pattern1.matcher(str);
        String phones = matcher1.replaceAll("+7 *** *** ");
        System.out.println(phones);

        String[] strings = str.toString().split(" ");
        Pattern pattern2 = Pattern.compile("([a-z0-9_\\.-]+)@([a-z0-9_\\.-]+)\\.([a-z\\.]{2,6})");

        for (String s:strings) {
            Matcher matcher2 = pattern2.matcher(s);
            if (matcher2.matches()) {
                System.out.println(s.replaceAll("(?<=.)[^@](?=[^@]*?[^@]@)|(?:(?<=@.)|(?!^)\\G(?=[^@]*$)).(?=.*[^@]\\.)", "*"));

            }
        }
    }
}
