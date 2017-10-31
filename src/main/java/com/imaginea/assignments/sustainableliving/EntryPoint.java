package com.imaginea.assignments.sustainableliving;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.imaginea.assignments.sustainableliving.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Entry point where all user requests will be received, processed and delegated as appropriate. The
 * following options will be shown to the user.
 *
 * <p>1. Register a new user with their home details. 2. Track an existing user's energy
 * consumption. 3. Set an existing user's sustainability goals. 4. Evaluate an existing user's
 * energy consumption against their goals and provide incentives.
 */
public class EntryPoint {

  public static final String INVALID_INPUT_ERROR_MESSAGE =
      "Valid values are 1, 2, 3, 4 and 5. Try again, please.";
  public static final String UNIMPLEMENTED_MESSAGE = "Unimplemented yet.";
  public static final String EXIT_MESSAGE = "Thank you! Quitting..";

  public static void main(String[] args) throws IOException {
    printWelcomeBanner();
    EntryPoint app = new EntryPoint();
    app.handleUserInput();
  }

  private void handleUserInput() throws IOException {
    BufferedReader inputStream = new BufferedReader(new InputStreamReader(System.in));
    String userInput = "";
    loop:
    while (userInput != null) {
      userInput = inputStream.readLine();
      UserInputProcessor inputProcessor = getInputProcessorInstance();
      switch (userInput) {
        case "1":
          inputProcessor.handleUser(buildUserDetails(inputStream));
          break;
        case "2":
          inputProcessor.generateHomeEnergyConsumptionReport();
          break;
        case "3":
          inputProcessor.handleGoals();
          break;
        case "4":
          System.err.println(UNIMPLEMENTED_MESSAGE);
          break;
        case "5":
          System.out.println(EXIT_MESSAGE);
          break loop;
        default:
          System.err.println(INVALID_INPUT_ERROR_MESSAGE);
      }
    }
  }

  private User buildUserDetails(BufferedReader reader) throws IOException {
    System.out.println("Enter your name.");
    User user = new User(UUID.randomUUID().toString(), reader.readLine());
    System.out.println("Enter your House name.");
    String houseName = reader.readLine();
    System.out.println("Enter the number of Energy resources in use at Home");
    Integer resourceCount = Integer.parseInt(reader.readLine());
    System.out.println(
        "For each of the resource, enter the type of the "
            + "energy resource on its own line. For electricity, press 1; for "
            + "LPG, press 2; for Water, press 3.");
    int i = resourceCount;
    List<EnergyResource> resources = new ArrayList<>();
    while (i > 0) {
      String type = reader.readLine();
      switch (type) {
        case "1":
          resources.add(new ElectricityResource());
          i--;
          break;
        case "2":
          resources.add(new LpgResource());
          i--;
          break;
        case "3":
          resources.add(new WaterResource());
          i--;
          break;
        default:
          System.err.println("Incorrect resource type! Try again, please.");
      }
    }
    Home home = new Home(houseName, resources);
    user.setHome(home);
    return user;
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

  private UserInputProcessor getInputProcessorInstance() {
    Injector injector = Guice.createInjector(new SlModule());
    return injector.getInstance(UserInputProcessor.class);
  }
}
