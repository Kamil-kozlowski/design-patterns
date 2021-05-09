import java.util.*;

public class FlyweightApp {
    public static void main(String[] args) {
        User u1 = UserCreator.create(Gender.MALE, "Gdynia");
        u1.introduce();
        User u2 = UserCreator.create(Gender.MALE, "Gdansk");
        u2.introduce();
        User u3 = UserCreator.create(Gender.FEMALE, "Gdynia");
        u3.introduce();
        User u4 = UserCreator.create(Gender.FEMALE, "Gdynia");
        u4.introduce();
        User u5 = UserCreator.create(Gender.FEMALE, "Gdansk");
        u5.introduce();
        User u6 = UserCreator.create(Gender.MALE, "Gdynia");
        u6.introduce();

        System.out.println("Registry size: " + UserTypeFactory.getRegistrySize()); // Expected 4
    }
}

class UserCreator {

    //Factory Method 1
    static User create(Gender gender, String city) {
        return new User(UserTypeFactory.getUserType(gender, city));
    }
}

class User {
    private final UserType type;

    public User(UserType type) {
        this.type = type;
    }

    void introduce() {
        System.out.println("Hello, I'm a " + type.getGenderString() + " from " + type.getCity());
    }
}

// Flyweight class
class UserType {
    private final Gender gender;
    private final String city;

    public UserType(Gender gender, String city) {
        this.gender = gender;
        this.city = city;
    }

    public String getGenderString() {
        return gender.getLowerCase();
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserType userType = (UserType) o;
        return gender == userType.gender && Objects.equals(city, userType.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, city);
    }
}

enum Gender {
    MALE, FEMALE;

    String getLowerCase() {
        return this.name().toLowerCase();
    }
}

class UserTypeFactory {

    static HashMap<String, UserType> userTypesRegistry = new HashMap<>();

    // Factory Method 2
    static UserType getUserType(Gender gender, String city) {
        String key = generateKey(gender, city);
        UserType userType = userTypesRegistry.get(key);
        if (userType == null) {
            userType = new UserType(gender, city);
            userTypesRegistry.put(key, userType);
        }
        return userType;
    }

    static int getRegistrySize() {
        return userTypesRegistry.size();
    }

    private static String generateKey(Gender gender, String city) {
        return gender.getLowerCase() + "-" + city;
    }
}