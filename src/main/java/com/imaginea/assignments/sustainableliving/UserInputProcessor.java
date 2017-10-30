package com.imaginea.assignments.sustainableliving;

import com.google.inject.Inject;
import com.imaginea.assignments.sustainableliving.database.HomeManager;
import com.imaginea.assignments.sustainableliving.database.SustainabilityGoalManager;
import com.imaginea.assignments.sustainableliving.database.UserManager;

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

  public void handleUser() {
    System.out.println("Dummy user handling implementation.");
  }

  public void handleUserHome() {
    System.out.println("Dummy userHome handling implementation.");
  }

  public void handleGoals() {
    System.out.println("Dummy userGoals implementation.");
  }
}
