package com.imaginea.assignments.sustainableliving.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LpgResource implements EnergyResource {
  @Override
  public ResourceConsumptionUnit getUnit() {
    return ResourceConsumptionUnit.LITRES;
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
