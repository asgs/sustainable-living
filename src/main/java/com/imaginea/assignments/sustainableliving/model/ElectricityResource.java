package com.imaginea.assignments.sustainableliving.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ElectricityResource extends AbstractEnergyResource {

  private List<ResourceConsumption> consumptions;

  @Override
  public ResourceConsumptionUnit getUnit() {
    return ResourceConsumptionUnit.WATTS;
  }
}
