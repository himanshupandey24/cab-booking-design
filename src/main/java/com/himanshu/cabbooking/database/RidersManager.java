package com.himanshu.cabbooking.database;

import com.himanshu.cabbooking.exceptions.RiderAlreadyExistException;
import com.himanshu.cabbooking.exceptions.RiderNotFoundException;
import com.himanshu.cabbooking.model.Rider;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class RidersManager {
    Map<String, Rider> ridersRegister = new HashMap<>();
    public void createRider(@NonNull final Rider rider){
        if(ridersRegister.containsKey(rider.getId()))
            throw new RiderAlreadyExistException();

        ridersRegister.put(rider.getId(), rider);
    }

    public Rider getRider(@NonNull final String riderId){
        if(!ridersRegister.containsKey(riderId))
            throw new RiderNotFoundException();

        return ridersRegister.get(riderId);
    }
}
