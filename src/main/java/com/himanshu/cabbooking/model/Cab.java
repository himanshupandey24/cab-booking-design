package com.himanshu.cabbooking.model;


import lombok.Getter;
import lombok.Setter;

@Getter
public class Cab {
    private String id;
    private String driverName;

   @Setter
   private Trip currentTrip;
   @Setter
    private Location currentLocation;
   @Setter
    private Boolean isAvailable;

    public Cab(String id, String driverName) {
        this.id = id;
        this.driverName = driverName;
        this.isAvailable = true;
    }


    @Override
    public String toString() {
        return "Cab{" +
                "id='" + id + '\'' +
                ", driverName='" + driverName + '\'' +
                ", currentTrip=" + currentTrip +
                ", currentLocation=" + currentLocation +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
