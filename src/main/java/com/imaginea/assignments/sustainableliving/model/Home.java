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

  public Home() {}

  public Double getSustainabilityScore() {
    return sustainabilityScore;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<EnergyResource> getResources() {
    return resources;
  }

  public void setResources(List<EnergyResource> resources) {
    this.resources = resources;
  }

  public void setSustainabilityScore(Double sustainabilityScore) {
    this.sustainabilityScore = sustainabilityScore;
  }
}
