

public class UsernameValidator {
    public static void main(String[] args) {
        String[] usernames = {"user_123", "123user", "us", "UserName_01"};

        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";

        for (String username : usernames) {
            if (username.matches(regex)) {
                System.out.println(username + " → Valid");
            } else {
                System.out.println(username + " → Invalid");
            }
        }
    }
}

