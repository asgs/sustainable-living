package com.imaginea.assignments.sustainableliving.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WaterResource implements EnergyResource {
  public ResourceConsumptionUnit getUnit() {
    return ResourceConsumptionUnit.LITRES;
  }

  public Double getConsumptionDuring(long startTimeInEpoch, long endTimeInEpoch) {
    return null;
  }

  public Double getConsumptionDuring() {
    return null;
  }
}
