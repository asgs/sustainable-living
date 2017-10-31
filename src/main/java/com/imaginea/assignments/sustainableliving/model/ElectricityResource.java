package com.imaginea.assignments.sustainableliving.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(as = ElectricityResource.class)
public class ElectricityResource extends AbstractEnergyResource {

  private List<ResourceConsumption> consumptions;

  public ElectricityResource() {}

  @Override
  public ResourceConsumptionUnit getUnit() {
    return ResourceConsumptionUnit.WATTS;
  }
}
