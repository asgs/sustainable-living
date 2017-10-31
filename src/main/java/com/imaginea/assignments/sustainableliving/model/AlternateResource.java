package com.imaginea.assignments.sustainableliving.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AlternateResource implements EnergyResource {
  private AlternateEnergyResourceType type;

  public AlternateResource(AlternateEnergyResourceType type) {
    this.type = type;
  }

  @Override
  public ResourceConsumptionUnit getUnit() {
    return null;
  }

  @Override
  public ResourceConsumption getConsumptionDuring(long startTimeInEpoch, long endTimeInEpoch) {
    return null;
  }

  @Override
  public ResourceConsumption getConsumptionDuring() {
    return null;
  }
}
