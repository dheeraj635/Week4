

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PasswordValidator {
    // Method to validate password strength
    public boolean isValid(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasUpper = false;
        boolean hasDigit = false;
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            }
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }
        return hasUpper && hasDigit;
    }
}

public class PasswordValidatorTest {
    private PasswordValidator validator;

    @BeforeEach
    public void setup() {
        validator = new PasswordValidator();
    }

    @Test
    public void testValidPasswords() {
        assertTrue(validator.isValid("Password1"), "Password1 should be valid");
        assertTrue(validator.isValid("Secure123"), "Secure123 should be valid");
    }

    @Test
    public void testInvalidPasswords() {
        assertFalse(validator.isValid("short1"), "Too short, should be invalid");
        assertFalse(validator.isValid("nouppercase1"), "Missing uppercase, should be invalid");
        assertFalse(validator.isValid("NoDigitsHere"), "Missing digit, should be invalid");
        assertFalse(validator.isValid(""), "Empty string should be invalid");
        assertFalse(validator.isValid(null), "Null input should be invalid");
    }
}
