package com.imaginea.assignments.sustainableliving.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LpgResource extends AbstractEnergyResource {
  @Override
  public ResourceConsumptionUnit getUnit() {
    return ResourceConsumptionUnit.LITRES;
  }
}
