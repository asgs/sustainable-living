package com.imaginea.assignments.sustainableliving.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SustainabilityGoal {

  private AlternateResource alternateEnergySourceToUse;
  private Double cutDownUsageBy;

  public AlternateResource getAlternateEnergySourceToUse() {
    return alternateEnergySourceToUse;
  }

  public void setAlternateEnergySourceToUse(AlternateResource alternateEnergySourceToUse) {
    this.alternateEnergySourceToUse = alternateEnergySourceToUse;
  }

  public Double getCutDownUsageBy() {
    return cutDownUsageBy;
  }

  public void setCutDownUsageBy(Double cutDownUsageBy) {
    this.cutDownUsageBy = cutDownUsageBy;
  }
}
