package liststuff;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class LinkedListTest_Educat {
  private LinkedList<String> aList;

  @BeforeEach
  public void setUp() {
    aList = new LinkedList<String>();
  }

  @AfterEach
  public void tearDown() {
    aList = null;
  }

  @Test
  public void testConstructor() {
    assertTrue(aList.isEmpty());
    assertEquals(0, aList.sizeIterative());
    assertNull(aList.get(0));
  }

  @Test
  public void testAddFirst() {
    aList.addFirst("mi");
    assertFalse(aList.isEmpty());
    assertEquals(1, aList.sizeIterative());
    assertEquals("mi", aList.get(0));
    aList.addFirst("re");
    assertFalse(aList.isEmpty());
    assertEquals(2, aList.sizeIterative());
    assertEquals("re", aList.get(0));
    assertEquals("mi", aList.get(1));
    aList.addFirst("do");
    assertFalse(aList.isEmpty());
    assertEquals(3, aList.sizeIterative());
    assertEquals("do", aList.get(0));
    assertEquals("re", aList.get(1));
    assertEquals("mi", aList.get(2));
  }

  @Test
  public void testAddLast() {
    aList.addLast("do");
    assertFalse(aList.isEmpty());
    assertEquals(1, aList.sizeIterative());
    assertEquals("do", aList.get(0));
    aList.addLast("re");
    assertFalse(aList.isEmpty());
    assertEquals(2, aList.sizeIterative());
    assertEquals("do", aList.get(0));
    assertEquals("re", aList.get(1));
    aList.addLast("mi");
    assertFalse(aList.isEmpty());
    assertEquals(3, aList.sizeIterative());
    assertEquals("do", aList.get(0));
    assertEquals("re", aList.get(1));
    assertEquals("mi", aList.get(2));
  }

  // XC write a test for add(int index, String item)

  @Test
  public void testRemoveFirst() {
    aList.addLast("do");
    aList.addLast("re");
    aList.addLast("mi");
    String note = aList.removeFirst();
    assertEquals("do", note);
    assertFalse(aList.isEmpty());
    assertEquals(2, aList.sizeIterative());
    assertEquals("re", aList.get(0));
    assertEquals("mi", aList.get(1));
    note = aList.removeFirst();
    assertEquals("re", note);
    assertFalse(aList.isEmpty());
    assertEquals(1, aList.sizeIterative());
    assertEquals("mi", aList.get(0));
    note = aList.removeFirst();
    assertEquals("mi", note);
    assertTrue(aList.isEmpty());
    assertEquals(0, aList.sizeIterative());
  }

  @Test
  public void testRemoveLast() {
    aList.addLast("do");
    aList.addLast("re");
    aList.addLast("mi");
    String note = aList.removeLast();
    assertEquals("mi", note);
    assertFalse(aList.isEmpty());
    assertEquals(2, aList.sizeIterative());
    assertEquals("do", aList.get(0));
    assertEquals("re", aList.get(1));
    note = aList.removeLast();
    assertEquals("re", note);
    assertFalse(aList.isEmpty());
    assertEquals(1, aList.sizeIterative());
    assertEquals("do", aList.get(0));
    note = aList.removeLast();
    assertEquals("do", note);
    assertTrue(aList.isEmpty());
    assertEquals(0, aList.sizeIterative());
  }

  @Test
  public void testEdgeCases() {
    assertNull(aList.get(-1));
    aList.addFirst("do");
    assertNull(aList.get(1));
    aList.removeFirst();
    assertNull(aList.removeFirst());
    assertNull(aList.removeLast());

  }
}
