
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListManager {

    public void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    public void removeElement(List<Integer> list, int element) {
        list.remove(Integer.valueOf(element));
    }

    public int getSize(List<Integer> list) {
        return list.size();
    }
}

public class ListManagerTest {

    private ListManager listManager;
    private List<Integer> list;

    @BeforeEach
    public void setup() {
        listManager = new ListManager();
        list = new ArrayList<>();
    }

    @Test
    public void testAddElement() {
        listManager.addElement(list, 10);
        listManager.addElement(list, 20);
        assertTrue(list.contains(10), "List should contain 10");
        assertTrue(list.contains(20), "List should contain 20");
    }

    @Test
    public void testRemoveElement() {
        list.add(10);
        list.add(20);
        listManager.removeElement(list, 10);
        assertFalse(list.contains(10), "List should not contain 10 after removal");
        assertTrue(list.contains(20), "List should still contain 20");
    }

    @Test
    public void testGetSize() {
        assertEquals(0, listManager.getSize(list), "Initial list size should be 0");
        listManager.addElement(list, 5);
        listManager.addElement(list, 15);
        assertEquals(2, listManager.getSize(list), "List size should be 2 after adding 2 elements");
        listManager.removeElement(list, 5);
        assertEquals(1, listManager.getSize(list), "List size should be 1 after removing 1 element");
    }
}

