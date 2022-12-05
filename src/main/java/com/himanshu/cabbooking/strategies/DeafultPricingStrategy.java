package com.himanshu.cabbooking.strategies;

import com.himanshu.cabbooking.model.Location;

public class DeafultPricingStrategy implements PricingStrategy{

    public static final Double PER_KM_RATE = 10.0;
    @Override
    public Double findPrice(Location fromPoint, Location toPoint) {
        return fromPoint.distance(toPoint) * PER_KM_RATE;
    }
}
