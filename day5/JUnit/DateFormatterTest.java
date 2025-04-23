
import static org.junit.jupiter.api.Assertions.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateFormatter {
    
    public String formatDate(String inputDate) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        inputFormat.setLenient(false);
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = inputFormat.parse(inputDate);
        return outputFormat.format(date);
    }
}

public class DateFormatterTest {
    private DateFormatter formatter;

    @BeforeEach
    public void setup() {
        formatter = new DateFormatter();
    }

    @Test
    public void testValidDateFormatting() throws ParseException {
        assertEquals("31-12-2023", formatter.formatDate("2023-12-31"), "Should format to dd-MM-yyyy");
        assertEquals("01-01-2024", formatter.formatDate("2024-01-01"), "Should format to dd-MM-yyyy");
    }

    @Test
    public void testInvalidDateThrowsException() {
        assertThrows(ParseException.class, () -> formatter.formatDate("2023-13-01"), "Invalid month should throw exception");
        assertThrows(ParseException.class, () -> formatter.formatDate("invalid-date"), "Invalid format should throw exception");
        assertThrows(ParseException.class, () -> formatter.formatDate("2023/12/31"), "Wrong delimiter should throw exception");
    }
}
