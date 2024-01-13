package com.pragra.learning.guestbookserviceaug2023.services;

import com.pragra.learning.guestbookserviceaug2023.entity.GuestEntity;
import com.pragra.learning.guestbookserviceaug2023.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public List<GuestEntity> getAllGuests() {
        return guestRepository.findAll();
    }

    public GuestEntity addGuest(GuestEntity guestEntity) {
        // Guest is parent class, if (cascade = CascadeType.ALL) then we don't have to write save for other tables
        return guestRepository.save(guestEntity);
    }

    public Optional<GuestEntity> getGuestById(Integer id) { return  guestRepository.findById(id); }

    public ResponseEntity<?> getGuestByName(String name) {
        return new ResponseEntity<GuestEntity>(HttpStatus.OK) ;
    }

    public Optional<GuestEntity> updateGuest(GuestEntity guestEntity, Integer id) {
        Optional<GuestEntity> guest = getGuestById(id);
        if(guest.isPresent()) {
            return Optional.of(addGuest(guestEntity));
        }

        return Optional.empty();
    }

    public Optional<GuestEntity> deleteGuest(Integer id) {
        Optional<GuestEntity> guest = getGuestById(id);
        if(guest.isPresent()) {
            guestRepository.deleteById(id);
            return guest;
        }

        return Optional.empty();
    }

}