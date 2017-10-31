package com.imaginea.assignments.sustainableliving.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.imaginea.assignments.sustainableliving.model.serdes.CustomEnergyResourceDeserializer;

/**
 * A common contract to represent an Energy Resource that is employed in a Home and that could be
 * tracked for efficiency.
 */
@JsonDeserialize(using = CustomEnergyResourceDeserializer.class)
public interface EnergyResource {
  /**
   * What unit can we measure its consumption in?
   *
   * @return ResourceConsumptionUnit
   */
  ResourceConsumptionUnit getUnit();

  /**
   * How much of the resource was consumed during the given time frame?
   *
   * @param startTimeInEpoch
   * @param endTimeInEpoch
   * @return Amount consumed.
   */
  Double getConsumptionDuring(long startTimeInEpoch, long endTimeInEpoch);

  /**
   * How much of the resource was consumed till date?
   *
   * @return Amount consumed.
   */
  Double getConsumptionDuring();
}
