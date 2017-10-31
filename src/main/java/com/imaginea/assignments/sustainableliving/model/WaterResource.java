package com.imaginea.assignments.sustainableliving.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(as = WaterResource.class)
public class WaterResource extends AbstractEnergyResource {
  public WaterResource() {}

  @Override
  public ResourceConsumptionUnit getUnit() {
    return ResourceConsumptionUnit.LITRES;
  }
}
