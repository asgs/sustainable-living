package com.imaginea.assignments.sustainableliving;

import com.imaginea.assignments.sustainableliving.database.HomeManager;
import com.imaginea.assignments.sustainableliving.database.SustainabilityGoalManager;
import com.imaginea.assignments.sustainableliving.database.UserManager;
import com.imaginea.assignments.sustainableliving.model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class UserInputProcessorTest {

  @Mock private UserManager userManager;
  @Mock private HomeManager homeManager;
  @Mock private SustainabilityGoalManager goalManager;

  private ArgumentCaptor<User> userCaptor;

  private UserInputProcessor processor;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    processor = new UserInputProcessor(userManager, homeManager, goalManager);
    userCaptor = ArgumentCaptor.forClass(User.class);
  }

  @Test(expected = UnsupportedOperationException.class)
  public void testHandleGoals() throws IOException {
    processor.handleGoals();
  }

  @Test
  public void testHandleUser() throws IOException {
    User user = new User("sdf", "dsfdf");
    processor.handleUserRegistration(user);
    verify(userManager, times(1)).registerUser(userCaptor.capture());
    assertThat(userCaptor.getValue()).isEqualTo(user);
  }
}
