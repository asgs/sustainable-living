package com.imaginea.assignments.sustainableliving.model;

/** The end user who has a Home that they want to manage the energy consumption for. */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
  private String id;

  private String name;

  private Home home;

  private Reward reward;

  private List<SustainabilityGoal> goals;

  public User(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public User() {}

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Home getHome() {
    return home;
  }

  public void setHome(Home home) {
    this.home = home;
  }

  public Reward getReward() {
    return reward;
  }

  public void setReward(Reward reward) {
    this.reward = reward;
  }

  public List<SustainabilityGoal> getGoals() {
    return goals;
  }

  public void setGoals(List<SustainabilityGoal> goals) {
    this.goals = goals;
  }
}
