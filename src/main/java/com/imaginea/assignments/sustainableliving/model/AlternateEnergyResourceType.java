package com.imaginea.assignments.sustainableliving.model;

/**
 * An Enum to represent the alternate Energy resources that could come handy in restricting the
 * usage of actual costlier resources.
 */
public enum AlternateEnergyResourceType {
  SOLAR(ResourceConsumptionUnit.WATTS),
  WIND(ResourceConsumptionUnit.WATTS),
  HYDRO(ResourceConsumptionUnit.WATTS),
  BIOGAS(ResourceConsumptionUnit.KILOGRAMS);

  private ResourceConsumptionUnit unit;

  AlternateEnergyResourceType(ResourceConsumptionUnit unit) {
    this.unit = unit;
  }
}
