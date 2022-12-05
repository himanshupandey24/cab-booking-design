package com.himanshu.cabbooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


@Getter
@AllArgsConstructor
@ToString
public class Location {
    private Double x;
    private Double y;

    public Double distance(Location location){
        return sqrt(pow(this.x - location.x,2) + pow(this.y - location.y,2));
    }
}
