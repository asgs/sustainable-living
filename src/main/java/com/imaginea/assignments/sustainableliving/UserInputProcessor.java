package com.imaginea.assignments.sustainableliving;

import com.google.inject.Inject;
import com.imaginea.assignments.sustainableliving.database.HomeManager;
import com.imaginea.assignments.sustainableliving.database.SustainabilityGoalManager;
import com.imaginea.assignments.sustainableliving.database.UserManager;
import com.imaginea.assignments.sustainableliving.model.User;

import java.io.IOException;

/**
 * This is more of a facade to all of the operations that would be performed on the behalf of the
 * user.
 */
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

  public void handleUserRegistration(User user) throws IOException {
    userManager.registerUser(user);
  }

  public void generateHomeEnergyConsumptionReport(String userId) throws IOException {
    userManager.generateReportAsyncly(userId);
  }

  public void handleGoals() {
    throw new UnsupportedOperationException();
  }
}
