package com.hamsa.CoronaVirusStats.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class CoronaVirusLiveDetails {
    public String province;
    public String country;
    public double latitude;
    public double longitude;
    public int deathCount;
}
