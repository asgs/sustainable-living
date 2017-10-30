package com.imaginea.assignments.sustainableliving.model;

/** The end user who has a Home that they want to manage the energy consumption for. */
public class User {
  private Long id;

  private String name;

  private Reward reward;

  public User(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Reward getReward() {
    return reward;
  }

  public void setReward(Reward reward) {
    this.reward = reward;
  }
}