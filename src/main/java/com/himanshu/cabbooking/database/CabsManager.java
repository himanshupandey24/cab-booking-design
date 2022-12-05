package com.himanshu.cabbooking.database;

import com.himanshu.cabbooking.exceptions.CabAlreadyExistsException;
import com.himanshu.cabbooking.exceptions.CabNotFoundException;
import com.himanshu.cabbooking.model.Cab;
import com.himanshu.cabbooking.model.Location;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CabsManager {

    Map<String,Cab> cabsRegister = new HashMap<>();

    public void createCab(@NonNull final Cab cab){
        if(cabsRegister.containsKey(cab.getId()))
            throw new CabAlreadyExistsException();

        cabsRegister.put(cab.getId(),cab);
    }

    public Cab getCab(@NonNull final String cabId){
        if(!cabsRegister.containsKey(cabId))
            throw new CabNotFoundException();

        return cabsRegister.get(cabId);
    }

    public void updateCabLocation(@NonNull final String cabID, @NonNull final Location newLocation){
        if(!cabsRegister.containsKey(cabID))
            throw new CabNotFoundException();

        cabsRegister.get(cabID).setCurrentLocation(newLocation);
    }

    public void updateCarAvailability(@NonNull final String cabId, @NonNull final Boolean newAvailability){
        if(!cabsRegister.containsKey(cabId))
            throw new CabNotFoundException();

        cabsRegister.get(cabId).setIsAvailable(newAvailability);
    }

    public List<Cab> getCabs(@NonNull final Location fromPoint, @NonNull final Double distance){
        List<Cab> result = new ArrayList<>();
        for(Cab cab : cabsRegister.values()){
            if(cab.getIsAvailable() && cab.getCurrentLocation().distance(fromPoint) <= distance)
                result.add(cab);
        }

        return result;
    }



}
