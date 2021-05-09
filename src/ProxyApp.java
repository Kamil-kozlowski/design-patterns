import java.util.*;

public class ProxyApp {
    public static void main(String[] args) {
        UsernameAccessor fullAccessor = new UsernameAccessorImpl();
        UsernameAccessor proxyAccessor = new UsernameAccessorProxy();

        fullAccessor.accessUsernames(Gender.MALE);
        System.out.println("------");
        fullAccessor.accessUsernames(Gender.FEMALE);
        System.out.println("------");
        proxyAccessor.accessUsernames(Gender.FEMALE);
        System.out.println("------");
        proxyAccessor.accessUsernames(Gender.MALE);
    }
}

interface UsernameAccessor {
    void accessUsernames(Gender gender);
}

class UsernameAccessorImpl implements UsernameAccessor {

    @Override
    public void accessUsernames(Gender gender) {
        UsernamesStorage.usernames.get(gender).forEach(System.out::println);
    }
}

class UsernameAccessorProxy implements UsernameAccessor {

    UsernameAccessor usernameAccessor;

    public UsernameAccessorProxy() {
        this.usernameAccessor = new UsernameAccessorImpl();
    }

    //Can only view males
    @Override
    public void accessUsernames(Gender gender) {
        if (gender == Gender.FEMALE) {
            System.out.println("No access");
        } else {
            usernameAccessor.accessUsernames(gender);
        }
    }
}

class UsernamesStorage {
    static Map<Gender, Set<String>> usernames = new HashMap<>();

    static {
        usernames.put(Gender.MALE, generateRandomUserNames());
        usernames.put(Gender.FEMALE, generateRandomUserNames());
    }

    private static Set<String> generateRandomUserNames() {
        Set<String> names = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            names.add(UUID.randomUUID().toString());
        }
        return names;
    }
}
