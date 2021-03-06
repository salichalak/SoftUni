package SetsAndMapsAdvancedExercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        LinkedHashSet<String> usernames = new LinkedHashSet<>();

        for (int i = 1; i <= count; i++) {
            String currentUsername = scanner.nextLine();

            usernames.add(currentUsername);
        }

        usernames.forEach(System.out::println);
    }
}