
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class DatabaseConnection {

    private boolean isConnected;

    public void connect() {
        isConnected = true;
        System.out.println("Database connected.");
    }

    public void disconnect() {
        isConnected = false;
        System.out.println("Database disconnected.");
    }

    public boolean isConnected() {
        return isConnected;
    }
}

public class DatabaseConnectionTest {

    private DatabaseConnection databaseConnection;

    @BeforeEach
    public void setup() {
        databaseConnection = new DatabaseConnection();
        databaseConnection.connect();
    }

    @AfterEach
    public void tearDown() {
        databaseConnection.disconnect();
    }

    @Test
    public void testConnectionEstablished() {
        assertTrue(databaseConnection.isConnected(), "Database should be connected");
    }

    @Test
    public void testConnectionClosed() {
        databaseConnection.disconnect(); // Simulate closing the connection
        assertFalse(databaseConnection.isConnected(), "Database should be disconnected");
    }
}
