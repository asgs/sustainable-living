package com.imaginea.assignments.sustainableliving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Entry point where all user requests will be received and delegated as appropriate. The following
 * options will be shown to the user.
 *
 * <p>1. Register a new user with their home details. 2. Track an existing user's energy
 * consumption. 3. Set an existing user's sustainability goals. 4. Evaluate an existing user's
 * energy consumption against their goals and provide incentives.
 */
public class EntryPoint {

  public static final String INVALID_INPUT_ERROR_MESSAGE =
      "Valid values are 1, 2, 3, 4 and 5. Try again, please.";
  public static final String UNIMPLEMENTED_MESSAGE = "Unimplemented yet.";

  public static void main(String[] args) throws IOException {
    printWelcomeBanner();
    BufferedReader inputStream = new BufferedReader(new InputStreamReader(System.in));
    String userInput = "";
    loop:
    while (userInput != null) {
      userInput = inputStream.readLine();
      int choice;
      try {
        choice = Integer.parseInt(userInput);
      } catch (NumberFormatException e) {
        System.err.println(INVALID_INPUT_ERROR_MESSAGE);
        continue;
      }
      switch (choice) {
        case 1:
          System.err.println(UNIMPLEMENTED_MESSAGE);
          break;
        case 2:
          System.err.println(UNIMPLEMENTED_MESSAGE);
          break;
        case 3:
          System.err.println(UNIMPLEMENTED_MESSAGE);
          break;
        case 4:
          System.err.println(UNIMPLEMENTED_MESSAGE);
          break;
        case 5:
          System.out.println("Thank you! Quitting..");
          break loop;
        default:
          System.err.println(INVALID_INPUT_ERROR_MESSAGE);
      }
    }
  }

  private static void printWelcomeBanner() {
    System.out.println("Hello! Welcome to Sustainable Living App!");
    System.out.println(
        "Please press to 1. Register as a new user with their home "
            + "details. 2. Track an existing user's energy\n"
            + " * consumption. 3. Set an existing user's sustainability goals. "
            + "4. Evaluate an existing user's\n"
            + " * energy consumption against their goals and provide incentives.");
    System.out.println("Press 5 to quit.");
  }
}
