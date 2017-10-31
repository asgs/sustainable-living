package com.imaginea.assignments.sustainableliving.model;

/**
 * A common contract to represent an Energy Resource that is employed in a Home and that could be
 * tracked for efficiency.
 */
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
  ResourceConsumption getConsumptionDuring(long startTimeInEpoch, long endTimeInEpoch);

  /**
   * How much of the resource was consumed till date?
   *
   * @return Amount consumed.
   */
  ResourceConsumption getConsumptionDuring();

  class ResourceConsumption {
    private Double amount;
    private long startTimeInEpochMillis;
    private long endTimeInEpochMillis;

    public Double getAmount() {
      return amount;
    }

    public void setAmount(Double amount) {
      this.amount = amount;
    }

    public long getStartTimeInEpochMillis() {
      return startTimeInEpochMillis;
    }

    public void setStartTimeInEpochMillis(long startTimeInEpochMillis) {
      this.startTimeInEpochMillis = startTimeInEpochMillis;
    }

    public long getEndTimeInEpochMillis() {
      return endTimeInEpochMillis;
    }

    public void setEndTimeInEpochMillis(long endTimeInEpochMillis) {
      this.endTimeInEpochMillis = endTimeInEpochMillis;
    }
  }
}
