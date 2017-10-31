package com.imaginea.assignments.sustainableliving.model;

/**
 * A Pair representing a combination of start and end times to signify a period during which
 * something like (resource consumption) could be captured.
 */
public class TimePair {
  private long startTime;
  private long endTime;

  public TimePair(long startTime, long endTime) {
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public long getStartTime() {
    return startTime;
  }

  public long getEndTime() {
    return endTime;
  }
}
