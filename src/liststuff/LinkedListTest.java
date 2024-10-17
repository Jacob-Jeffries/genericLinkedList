package liststuff;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class LinkedListTest<E> {

  private LinkedList<E> aList;

  @BeforeEach
  public void setUp() {
    // Uses inherited constructor from Object to null-out variables.
    aList = new LinkedList<E>();
  }

  @AfterEach
  public void tearDown() {
    aList = null;
  }

  @Test
  public void testConstructor() {
    assertTrue(aList.isEmpty());
    assertNull(aList.getFirst());
    assertNull(aList.getLast());
    assertEquals(0, aList.sizeRecursive(aList.getFirst()));
    assertNull(aList.get(0));
  }

  @Test
  public void testAddFirst() {
    aList.addFirst("mi");
    assertFalse(aList.isEmpty());
    assertEquals(1, aList.sizeRecursive(aList.getFirst()));
    assertEquals("mi", aList.get(0));

    aList.addFirst("re");
    assertFalse(aList.isEmpty());
    assertEquals(2, aList.sizeRecursive(aList.getFirst()));
    assertEquals("re", aList.get(0));
    assertEquals("mi", aList.get(1));

    aList.addFirst("do");
    assertFalse(aList.isEmpty());
    assertEquals(3, aList.sizeRecursive(aList.getFirst()));
    assertEquals("do", aList.get(0));
    assertEquals("re", aList.get(1));
    assertEquals("mi", aList.get(2));
  }

  @Test
  public void testAddLast() {
    aList.addLast("do");
    assertFalse(aList.isEmpty());
    assertEquals(1, aList.sizeRecursive(aList.getFirst()));
    assertEquals("do", aList.get(0));

    aList.addLast("re");
    assertFalse(aList.isEmpty());
    assertEquals(2, aList.sizeRecursive(aList.getFirst()));
    assertEquals("do", aList.get(0));
    assertEquals("re", aList.get(1));

    aList.addLast("mi");
    assertFalse(aList.isEmpty());
    assertEquals(3, aList.sizeRecursive(aList.getFirst()));
    assertEquals("do", aList.get(0));
    assertEquals("re", aList.get(1));
    assertEquals("mi", aList.get(2));
  }

  @Test
  public void testRemoveFirst() {
    aList.addLast("do");
    aList.addLast("re");
    aList.addLast("mi");

    String note = aList.removeFirst();
    assertEquals("do", note);
    assertFalse(aList.isEmpty());
    assertEquals(2, aList.sizeRecursive(aList.getFirst()));
    assertEquals("re", aList.get(0));
    assertEquals("mi", aList.get(1));

    note = aList.removeFirst();
    assertEquals("re", note);
    assertFalse(aList.isEmpty());
    assertEquals(1, aList.sizeRecursive(aList.getFirst()));
    assertEquals("mi", aList.get(0));

    note = aList.removeFirst();
    assertEquals("mi", note);
    assertTrue(aList.isEmpty());
    assertEquals(0, aList.sizeRecursive(aList.getFirst()));
    assertNull(aList.get(0));
  }

  @Test
  public void testRemoveLast() {
    aList.addLast("do");
    aList.addLast("re");
    aList.addLast("mi");

    String note = aList.removeLast();
    assertEquals("mi", note);
    assertFalse(aList.isEmpty());
    assertEquals(2, aList.sizeRecursive(aList.getFirst()));
    assertEquals("do", aList.get(0));
    assertEquals("re", aList.get(1));

    note = aList.removeLast();
    assertEquals("re", note);
    assertFalse(aList.isEmpty());
    assertEquals(1, aList.sizeRecursive(aList.getFirst()));
    assertEquals("do", aList.get(0));

    note = aList.removeLast();
    assertEquals("do", note);
    assertTrue(aList.isEmpty());
    assertEquals(0, aList.sizeRecursive(aList.getFirst()));
    assertNull(aList.get(0));
  }

  // Extra Credit
  @Test
  public void testAdd(){
    // do
    aList.addLast("re");
    // mi
    aList.addLast("la");
    aList.addLast("ti");
    // do

    //Test for adding at index: 0 - addFirst("do")
    String result = aList.add(0,"do");
    assertEquals("do", result);
    assertEquals(4, aList.sizeRecursive(aList.getFirst()));
    assertEquals("do", aList.get(0));
    assertEquals("re", aList.get(1));

    result = aList.add(2, "mi");
    assertEquals("mi", result);
    assertEquals(5, aList.sizeRecursive(aList.getFirst()));
    assertEquals("re", aList.get(1));
    assertEquals("mi", aList.get(2));
    assertEquals("la", aList.get(3));

    //Test for adding at index:6 - addLast("do")
    result = aList.add(5, "do");
    assertEquals("do", result);
    assertEquals(6, aList.sizeRecursive(aList.getFirst()));
    assertEquals("do", aList.get(0));
    assertEquals("re", aList.get(1));
    assertEquals("mi", aList.get(2));
    assertEquals("la", aList.get(3));
    assertEquals("ti", aList.get(4));
    assertEquals("do", aList.get(5));

    result = aList.add(-1, "oops");
    assertNull(result);
    assertEquals(6, aList.sizeRecursive(aList.getFirst()));
    assertEquals("do", aList.get(0));
    assertEquals("re", aList.get(1));
    assertEquals("mi", aList.get(2));
    assertEquals("la", aList.get(3));
    assertEquals("ti", aList.get(4));
    assertEquals("do", aList.get(5));

    result = aList.add(10, "oops");
    assertNull(result);
    assertEquals(6, aList.sizeRecursive(aList.getFirst()));
    assertEquals("do", aList.get(0));
    assertEquals("re", aList.get(1));
    assertEquals("mi", aList.get(2));
    assertEquals("la", aList.get(3));
    assertEquals("ti", aList.get(4));
    assertEquals("do", aList.get(5));
  }

  // Extra Credit
  @Test
  public void testRemove(){
    aList.addLast("do");
    aList.addLast("re");
    aList.addLast("mi");
    aList.addLast("la");
    aList.addLast("ti");
    aList.addLast("do");

    String result = aList.remove(0);
    assertEquals("do",result);
    assertEquals("re", aList.get(0));
    assertEquals(5, aList.sizeRecursive(aList.getFirst()));
    assertEquals("re", aList.get(0));
    assertEquals("mi", aList.get(1));
    assertEquals("la", aList.get(2));
    assertEquals("ti", aList.get(3));
    assertEquals("do", aList.get(4));

    result = aList.remove(4);
    assertEquals("do", result);
    assertEquals(4, aList.sizeRecursive(aList.getFirst()));
    assertEquals("re", aList.get(0));
    assertEquals("mi", aList.get(1));
    assertEquals("la", aList.get(2));
    assertEquals("ti", aList.get(3));

    result = aList.remove(2);
    assertEquals("la", result);
    assertEquals(3, aList.sizeRecursive(aList.getFirst()));
    assertEquals("re", aList.get(0));
    assertEquals("mi", aList.get(1));
    assertEquals("ti", aList.get(2));

    result = aList.remove(-1);
    assertNull(result);
    assertEquals("re", aList.get(0));
    assertEquals("mi", aList.get(1));
    assertEquals("ti", aList.get(2));

    result = aList.remove(10);
    assertNull(result);
    assertEquals("re", aList.get(0));
    assertEquals("mi", aList.get(1));
    assertEquals("ti", aList.get(2));
  }

  // Edge Case Tests
  @Test
  public void testEdgeCases() {

    // We are returning null as an out of bounds error.
    assertNull(aList.get(-1));
    aList.addFirst("do");
    assertNull(aList.get(1));
    aList.removeFirst();
    assertNull(aList.removeFirst());
    assertNull(aList.removeLast());
  }
}
