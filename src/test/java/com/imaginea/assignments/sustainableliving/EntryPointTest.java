package com.imaginea.assignments.sustainableliving;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class EntryPointTest {

  @Test
  public void testApp() throws IOException {
    String userOptions = "1\n2\n3\n4\n5\n";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(userOptions.getBytes("UTF-8"));
    System.setIn(inputStream);

    EntryPoint.main(null);
    assertTrue(inputStream.available() == 0);
    System.setIn(System.in);
  }
}
