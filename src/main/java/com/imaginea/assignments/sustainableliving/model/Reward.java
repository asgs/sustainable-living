package com.imaginea.assignments.sustainableliving.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Reward {

  /**
   * What sort of badges have been granted to the user? "Most Energy Conserving Consumer!",
   * "Moderately conservative Consumer!", etc.,
   */
  private List<String> badges;

  /** Incentives in the form of USD awarded. */
  private Double incentives;
}
