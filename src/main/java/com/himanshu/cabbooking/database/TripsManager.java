package com.himanshu.cabbooking.database;

import com.himanshu.cabbooking.model.Trip;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TripsManager {

    public static final Double MAX_ALLOWED_TRIP_MATCHING_DISTANCE = 10.0;
    private Map<String, List<Trip>> tripsRegister = new HashMap<>();
    private CabsManager cabsManager;
    private RidersManager ridersManager;

}
