import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Data
public class User implements Comparable<User>{
    private static Integer currentId=0;
    private Integer id;
    private String name;
    private Integer age;

    public static User createUser(){
        User user = new User();
        user.setId(currentId++);
        Random random = new Random();
        user.setAge(random.nextInt(65));
        user.setName(getRandomName());
        return user;
    }

    public static String getRandomName(){
        List<String> names = Arrays.asList("Andrei", "Alexandru", "Gabriel", "Ionut", "Stefan", "Maria", "Elena", "Ioana", "Andreea");
        Random random = new Random();
        return names.get(random.nextInt(names.size()));
    }

    @Override
    public int compareTo(User o) {
        return this.getAge()-o.getAge();
    }
}
