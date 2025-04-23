

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

class PerformanceTestUtils {

    public String longRunningTask() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3); // Simulate a task that takes 3 seconds
        return "Task Completed";
    }
}

public class PerformanceTestUtilsTest {

    private PerformanceTestUtils performanceTestUtils = new PerformanceTestUtils();

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS) // Test will fail if the task takes more than 2 seconds
    public void testLongRunningTask() throws InterruptedException {
        String result = performanceTestUtils.longRunningTask();
        assertEquals("Task Completed", result, "The task should complete successfully.");
    }
}
