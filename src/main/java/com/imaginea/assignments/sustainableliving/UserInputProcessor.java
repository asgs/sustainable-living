package com.imaginea.assignments.sustainableliving;

import com.google.inject.Inject;
import com.imaginea.assignments.sustainableliving.database.HomeManager;
import com.imaginea.assignments.sustainableliving.database.SustainabilityGoalManager;
import com.imaginea.assignments.sustainableliving.database.UserManager;
import com.imaginea.assignments.sustainableliving.model.User;

import java.io.IOException;

public class UserInputProcessor {

  private UserManager userManager;
  private HomeManager homeManager;
  private SustainabilityGoalManager sustainabilityGoalManager;

  @Inject
  public UserInputProcessor(
      UserManager userManager,
      HomeManager homeManager,
      SustainabilityGoalManager sustainabilityGoalManager) {
    this.userManager = userManager;
    this.homeManager = homeManager;
    this.sustainabilityGoalManager = sustainabilityGoalManager;
  }

  public void handleUser(User user) throws IOException {
    userManager.handleUser(user);
  }

  public void generateHomeEnergyConsumptionReport() {
    System.out.println("Dummy userHome handling implementation.");
  }

  public void handleGoals() {
    System.out.println("Dummy userGoals implementation.");
  }
}
