

import java.util.regex.*;

public class ValidateIP {
    public static void main(String[] args) {
        String ipAddress = "192.168.1.1";
        String regex = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ipAddress);

        if (matcher.matches()) {
            System.out.println(ipAddress + " is a valid IPv4 address.");
        } else {
            System.out.println(ipAddress + " is not a valid IPv4 address.");
        }
    }
}

