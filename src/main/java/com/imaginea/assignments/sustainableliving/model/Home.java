package com.imaginea.assignments.sustainableliving.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Represents a User's Home fitted with various energy resources consumed by the User and other
 * meta-data to qualify in the context of Sustainable Living.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Home {
  private String name;
  private Double sustainabilityScore;
  private List<EnergyResource> resources;

  public Home(String name, List<EnergyResource> resources) {
    this.name = name;
    this.resources = resources;
  }

  public Double getSustainabilityScore() {
    return sustainabilityScore;
  }

  public void setSustainabilityScore(Double sustainabilityScore) {
    this.sustainabilityScore = sustainabilityScore;
  }
}
