

import java.util.regex.*;

public class ValidateSSN {
    public static void main(String[] args) {
        String ssn = "123-45-6789";  // Example SSN input

        // Regex pattern for validating SSN
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ssn);
        
        if (matcher.matches()) {
            System.out.println("\"" + ssn + "\" is valid");
        } else {
            System.out.println("\"" + ssn + "\" is invalid");
        }
    }
}

