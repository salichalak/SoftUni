package Telephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    private static final String PHONE_REGEX = "^[0-9]+$";
    private static final String URL_REGEX = "^\\D+$";

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        Pattern pattern = Pattern.compile(PHONE_REGEX, Pattern.MULTILINE);
        StringBuilder out = new StringBuilder();

        for (String number : this.numbers) {
            if (this.hasMatch(number, pattern)) {
                out.append(String.format("Calling... %s%n", number));
            } else {
                out.append(String.format("Invalid number!%n"));
            }
        }
        return out.toString();
    }

    @Override
    public String browse() {
        Pattern pattern = Pattern.compile(URL_REGEX, Pattern.MULTILINE);
        StringBuilder out = new StringBuilder();

        for (String url : this.urls) {
            if (this.hasMatch(url, pattern)) {
                out.append(String.format("Browsing: %s!", url));
            } else {
                out.append("Invalid URL!");
            }
            out.append(System.lineSeparator());
        }
        return out.toString();
    }


    private boolean hasMatch(String input, Pattern pattern) {
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}