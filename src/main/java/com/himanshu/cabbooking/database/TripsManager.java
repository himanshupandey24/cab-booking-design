package com.himanshu.cabbooking.database;

import com.himanshu.cabbooking.exceptions.NoCabsAvailableException;
import com.himanshu.cabbooking.exceptions.TripNotFoundException;
import com.himanshu.cabbooking.model.Cab;
import com.himanshu.cabbooking.model.Location;
import com.himanshu.cabbooking.model.Rider;
import com.himanshu.cabbooking.model.Trip;
import com.himanshu.cabbooking.strategies.CabMatchingStrategy;
import com.himanshu.cabbooking.strategies.PricingStrategy;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TripsManager {

    public static final Double MAX_ALLOWED_TRIP_MATCHING_DISTANCE = 10.0;
    private Map<String, List<Trip>> tripsRegister = new HashMap<>();
    private CabsManager cabsManager;
    private RidersManager ridersManager;
    private CabMatchingStrategy cabMatchingStrategy;
    private PricingStrategy pricingStrategy;

    public TripsManager(CabsManager cabsManager,
                        RidersManager ridersManager,
                        CabMatchingStrategy cabMatchingStrategy,
                        PricingStrategy pricingStrategy) {
        this.cabsManager = cabsManager;
        this.ridersManager = ridersManager;
        this.cabMatchingStrategy = cabMatchingStrategy;
        this.pricingStrategy = pricingStrategy;
    }

    public void createTrip(@NonNull final Rider rider,
                           @NonNull final Location fromPoint,
                           @NonNull final Location toPoint){

        final List<Cab> closeByCabs = cabsManager.getCabs(fromPoint, MAX_ALLOWED_TRIP_MATCHING_DISTANCE);

        final List<Cab> closeByAvailableCabs = closeByCabs
                .stream()
                .filter(cab -> cab.getCurrentTrip() == null)
                .collect(Collectors.toList());

        final Cab selectedCab = cabMatchingStrategy.matchCabToRider(rider, closeByAvailableCabs, fromPoint, toPoint);

        if(selectedCab == null)
            throw new NoCabsAvailableException();

        final Double price = pricingStrategy.findPrice(fromPoint, toPoint);
        final Trip newTrip = new Trip(rider, selectedCab, price, fromPoint, toPoint);

        if(!tripsRegister.containsKey(rider.getId()))
            tripsRegister.put(rider.getId(), new ArrayList<>());

        tripsRegister.get(rider.getId()).add(newTrip);
        selectedCab.setCurrentTrip(newTrip);
    }


    public List<Trip> tripHistory(@NonNull final Rider rider){
        return tripsRegister.get(rider.getId());
    }

    public void endTrip(@NonNull final Cab cab){
        if(cab.getCurrentTrip() == null)
            throw new TripNotFoundException();

        cab.getCurrentTrip().endTrip();
        cab.setCurrentTrip(null);
    }
}
