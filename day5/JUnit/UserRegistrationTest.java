
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserRegistration {
    public void registerUser(String username, String email, String password) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long");
        }
        // Assume user is registered successfully (no actual storage logic here)
    }
}

public class UserRegistrationTest {
    private UserRegistration registration;

    @BeforeEach
    public void setup() {
        registration = new UserRegistration();
    }

    @Test
    public void testValidUserRegistration() {
        assertDoesNotThrow(() -> registration.registerUser("john", "john@example.com", "secure123"),
                "Valid user should not throw exception");
    }

    @Test
    public void testEmptyUsername() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> registration.registerUser("", "john@example.com", "secure123"));
        assertEquals("Username cannot be empty", ex.getMessage());
    }

    @Test
    public void testInvalidEmail() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> registration.registerUser("john", "johnexample.com", "secure123"));
        assertEquals("Invalid email format", ex.getMessage());
    }

    @Test
    public void testShortPassword() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> registration.registerUser("john", "john@example.com", "123"));
        assertEquals("Password must be at least 6 characters long", ex.getMessage());
    }
}
