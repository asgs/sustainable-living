package com.imaginea.assignments.sustainableliving.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractEnergyResource implements EnergyResource {

  private Map<TimePair, ResourceConsumption> consumptions = new HashMap<>();

  @Override
  public Double getConsumptionDuring(long startTimeInEpoch, long endTimeInEpoch) {
    return consumptions.get(new TimePair(startTimeInEpoch, endTimeInEpoch)).getAmount();
  }

  @Override
  public Double getConsumptionDuring() {
    return consumptions.values().stream().collect(Collectors.summingDouble(rc -> rc.getAmount()));
  }

  public void setConsumption(Double consumptionAmount, long startTime, long endTime) {
    consumptions.put(
        new TimePair(startTime, endTime),
        new ResourceConsumption(consumptionAmount, startTime, endTime));
  }

  class ResourceConsumption {
    private Double amount;
    private long startTimeInEpochMillis;
    private long endTimeInEpochMillis;

    public ResourceConsumption(Double amount) {
      this.amount = amount;
    }

    public ResourceConsumption(
        Double amount, long startTimeInEpochMillis, long endTimeInEpochMillis) {
      this(amount);
      this.startTimeInEpochMillis = startTimeInEpochMillis;
      this.endTimeInEpochMillis = endTimeInEpochMillis;
    }

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
