package com.imaginea.assignments.sustainableliving;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class EntryPointTest {

  public static final String UTF_8 = "UTF-8";

  @Test
  public void testApp() throws IOException {
    String userOptions = "5\n";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(userOptions.getBytes(UTF_8));
    System.setIn(inputStream);

    EntryPoint.main(null);
  }

  @Test(expected = NumberFormatException.class)
  public void testAppWithError() throws IOException {
    String userOptions = "1\n";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(userOptions.getBytes(UTF_8));
    System.setIn(inputStream);
    EntryPoint.main(null);
    // NFE is expected because option 1 requires a number from the stream
    // which has already reached its end.
  }
}
