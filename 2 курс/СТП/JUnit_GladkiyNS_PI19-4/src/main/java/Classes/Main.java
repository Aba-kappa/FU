package Classes;

public class Main {
    public static void main(String[] args) {
        new User("Никита", 19, Gender.MALE);
        new User("Даниил", 23, Gender.MALE);
        new User("Дмитрий", 54, Gender.MALE);
        new User("Елизавета", 75, Gender.FEMALE);
        new User("Юлия", 36, Gender.FEMALE);


        System.out.println("Все пользователи:");
        User.getAllUsers().forEach(System.out::println);
        System.out.println("------------------------------------------------");
        System.out.println("Все пользователи мужчины");
        User.getAllUsers(Gender.MALE).forEach(System.out::println);
        System.out.println("------------------------------------------------");
        System.out.println("Все пользователи женщины");
        User.getAllUsers(Gender.FEMALE).forEach(System.out::println);
        System.out.println("------------------------------------------------");
        System.out.println("Кол-во всех пользователей: " + User.getHowManyUsers());
        System.out.println("Кол-во всех пользователей мужчин: " + User.getHowManyUsers(Gender.MALE));
        System.out.println("Кол-во всех пользователей женщин: " + User.getHowManyUsers(Gender.FEMALE));
        System.out.println("------------------------------------------------");
        System.out.println("Общий возраст всех пользователей: " + User.getAllAgeUsers());
        System.out.println("Общий возраст всех пользователей мужчин:" + User.getAllAgeUsers(Gender.MALE));
        System.out.println("Общий возраст всех пользователей женщин: " + User.getAllAgeUsers(Gender.FEMALE));
        System.out.println("------------------------------------------------");
        System.out.println("Средний возраст всех пользователей: " + User.getAverageAgeOfAllUsers());
        System.out.println("Средний возраст всех пользователей мужчин: " + User.getAverageAgeOfAllUsers(Gender.MALE));
        System.out.println("Средний возраст всех пользователей женщин: " + User.getAverageAgeOfAllUsers(Gender.FEMALE));
        System.out.println("------------------------------------------------");
    }

}
