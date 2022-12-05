package com.himanshu.cabbooking.strategies;

import com.himanshu.cabbooking.model.Location;

public interface PricingStrategy {
    Double findPrice(Location fromPoint, Location toPoint);
}
