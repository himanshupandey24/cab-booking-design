package com.himanshu.cabbooking.strategies;

import com.himanshu.cabbooking.model.Cab;
import com.himanshu.cabbooking.model.Location;
import com.himanshu.cabbooking.model.Rider;
import lombok.NonNull;

import java.util.List;

public class DeafultCabMatchingStrategy implements CabMatchingStrategy{
    @Override
    public Cab matchCabToRider(@NonNull final Rider rider,
                               @NonNull final List<Cab> candidateCabs,
                               @NonNull final Location fromPoint,
                               @NonNull final Location toPoint) {
        if(candidateCabs.isEmpty())
            return null;

        return candidateCabs.get(0);
    }
}
