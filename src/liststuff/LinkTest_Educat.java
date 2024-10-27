package liststuff;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class LinkTest_Educat {

  private Link<String> aLink;

  @BeforeEach
  public void setUp() {
    aLink = new Link<>("ocarina");
  }

  @AfterEach
  public void tearDown() {
    aLink = null;
  }

  @Test
  public void testConstructor() {
    assertNull(aLink.getAfter());
    assertNull(aLink.getBefore());
    assertEquals("ocarina", aLink.getItem());
  }

  @Test
  public void testLinkage() {
    Link<String> otherLink = new Link<>("shield");
    aLink.setAfter(otherLink);
    otherLink.setBefore(aLink);
    assertEquals(otherLink, aLink.getAfter());
    assertNull(aLink.getBefore());
    assertEquals("ocarina", aLink.getItem());
    assertNull(otherLink.getAfter());
    assertEquals(aLink, otherLink.getBefore());
    assertEquals("shield", otherLink.getItem());
  }
}
