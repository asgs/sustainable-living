package com.imaginea.assignments.sustainableliving.model;

public class AlternateResource implements EnergyResource {
  private AlternateEnergyResourceType type;

  public AlternateResource(AlternateEnergyResourceType type) {
    this.type = type;
  }

  public ResourceConsumptionUnit getUnit() {
    return null;
  }

  public Double getConsumptionDuring(long startTimeInEpoch, long endTimeInEpoch) {
    return null;
  }

  public Double getConsumptionDuring() {
    return null;
  }
}