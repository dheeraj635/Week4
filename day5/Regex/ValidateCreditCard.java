

import java.util.regex.*;

public class ValidateCreditCard {
    public static void main(String[] args) {
        String visaCard = "4111111111111111";      
        String masterCard = "5111111111111111";   
        String invalidCard = "41111111111111";    

        String regex = "^(4\\d{15}|5\\d{15})$";

        
        validateCard(visaCard, regex);
        
        validateCard(masterCard, regex);
        
        validateCard(invalidCard, regex);
    }

    public static void validateCard(String cardNumber, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cardNumber);

        if (matcher.matches()) {
            System.out.println(cardNumber + " is a valid credit card number.");
        } else {
            System.out.println(cardNumber + " is not a valid credit card number.");
        }
    }
}

