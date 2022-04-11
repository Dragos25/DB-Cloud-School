import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //Create a stream with 3 users
        Integer userCount=10;
        Stream<User> users = Stream.generate(() -> User.createUser()).limit(userCount);
        ArrayList<User> userList = (ArrayList<User>) users.collect(Collectors.toList());
        userList.stream().forEach(System.out::println);

        //Filter users with age < 18
        userList.stream().filter(u -> u.getAge()<18).forEach(System.out::println);

        //Double users’ age
        System.out.println("Doubled ages:");
        userList.stream().map( u -> {
            u.setAge(u.getAge()*2);
            return u;
        }).forEach(System.out::println);

        //Print the last element of the stream
        System.out.println("\nLast element of stream:");
        userList.stream().reduce((first, second) -> second).ifPresent(System.out::println);

        //Find the person with the smallest age and the one with the greatest age
        System.out.println("\nYoungest user:");
        userList.stream().min(Comparator.comparing(User::getAge)).ifPresent(System.out::println);
        System.out.println("\nOldest user:");
        userList.stream().max(Comparator.comparing(User::getAge)).ifPresent(System.out::println);

        //Remove duplicates from the list
        System.out.println("\nDistinct values:");
        List<User> distinctList = userList.stream().distinct().collect(Collectors.toList());
        distinctList.stream().forEach(System.out::println);

        //Filter users with age > 30, transform their names to uppercase and sort them descending by age
        System.out.println("\nFilter users with age > 30, transform their names to uppercase and sort them descending by age");
        userList.stream().filter(u -> u.getAge()>30).map(u -> {
            u.setName(u.getName().toUpperCase());
            return u;
        }).sorted().forEach(System.out::println);
    }
}
