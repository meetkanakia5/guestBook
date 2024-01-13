package com.pragra.learning.guestbookserviceaug2023.controller;

import com.pragra.learning.guestbookserviceaug2023.entity.GuestEntity;
import com.pragra.learning.guestbookserviceaug2023.services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    GuestService guestService;

    @GetMapping
    public List<GuestEntity> getAllGuest() {
        return guestService.getAllGuests();
    }

    @GetMapping("/{id}")
    public Optional<GuestEntity> getGuestById(@PathVariable int id) {
        return guestService.getGuestById(id);
    }

    @PostMapping
    public ResponseEntity<GuestEntity> getGuestDetails(@RequestBody GuestEntity guestEntity) {
        guestService.addGuest(guestEntity);
        return new ResponseEntity<>(guestEntity, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Object updateGuest(@RequestBody GuestEntity guestEntity, @PathVariable Integer id) {
        Optional<GuestEntity> optionalGuestEntity = guestService.updateGuest(guestEntity, id);
        if(optionalGuestEntity.isEmpty()) return ResponseEntity.noContent().header("Error Message", "No Data Found ");
        return new ResponseEntity<>(guestEntity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public Optional<GuestEntity> deleteGuest(@PathVariable Integer id) {
        return guestService.deleteGuest(id);
    }
}