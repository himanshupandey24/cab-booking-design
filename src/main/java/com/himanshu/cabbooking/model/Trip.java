package com.himanshu.cabbooking.model;


import lombok.NonNull;
import lombok.ToString;

@ToString
public class Trip {

    private Rider rider;
    private Cab cab;
    private TripStatus tripStatus;
    private Double price;
    private Location fromPoint;
    private Location toPoint;

    public Trip(@NonNull final Rider rider,
                @NonNull final Cab cab,
                @NonNull final Double price,
                @NonNull final Location fromPoint,
                @NonNull final Location toPoint) {

        this.rider = rider;
        this.cab = cab;
        this.price = price;
        this.fromPoint = fromPoint;
        this.toPoint = toPoint;
    }

    public void endTrip() {
        this.tripStatus = TripStatus.FINISHED;
    }
}
