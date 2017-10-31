package com.imaginea.assignments.sustainableliving.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AlternateResource extends AbstractEnergyResource {
  private AlternateEnergyResourceType type;

  public AlternateResource(AlternateEnergyResourceType type) {
    this.type = type;
  }

  public AlternateResource() {}

  @Override
  public ResourceConsumptionUnit getUnit() {
    return type.getUnit();
  }
}
