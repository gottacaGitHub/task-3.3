import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, List<User>> userMap = new HashMap<>();

        int i = 1;
        while (i <= 5) {
            try {
                System.out.println("Введите имя пользователя " + i);
                String name = scanner.nextLine();
                System.out.println("Введите возраст пользователя " + i);
                Integer age = scanner.nextInt();
                scanner.nextLine();

                User user = new User(name, age);

                userMap.computeIfAbsent(age, k -> new ArrayList<>()).add(user);
                i++;
            }
            catch (Exception ignored) {
            }

        }

        System.out.println("Введите требуемый возраст");
        Integer requiredAge = scanner.nextInt();
        scanner.nextLine();

        if (userMap.containsKey(requiredAge)) {
            List<User> usersRequiredAge = userMap.get(requiredAge);
            usersRequiredAge.sort(Comparator.comparing(User::getName));

            for (User user : usersRequiredAge) {
                System.out.println(user);
            }
        } else {
            System.out.println("Пользователь с возрастом '" + requiredAge + "' не найден");
        }

        scanner.close();
    }
}
