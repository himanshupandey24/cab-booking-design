package com.himanshu.cabbooking.strategies;

import com.himanshu.cabbooking.model.Cab;
import com.himanshu.cabbooking.model.Location;
import com.himanshu.cabbooking.model.Rider;

import java.util.List;

public interface CabMatchingStrategy {
    Cab matchCabToRider(Rider rider, List<Cab> candidateCabs, Location fromPoint, Location toPoint);
}
