package com.pragra.learning.guestbookserviceaug2023.services;

import com.pragra.learning.guestbookserviceaug2023.dto.User;
import com.pragra.learning.guestbookserviceaug2023.entity.GuestEntity;
import com.pragra.learning.guestbookserviceaug2023.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;

    public List<GuestEntity> getAllGuests() {
        return guestRepository.findAll();
    }

    public GuestEntity addGuest(GuestEntity guestEntity) {
        // Guest is parent class, if (cascade = CascadeType.ALL) then we don't have to write save for other tables

        /* Through restTemplate */
        //User user = restTemplate.getForObject("http://localhost:9090/restTemplate/user/" + guestEntity.getUserName(), User.class);

        User user = getGithubUser(guestEntity.getUserName());
        guestEntity.setAvatar_url(user.getAvatar_url());
        return guestRepository.save(guestEntity);
    }

    private User getGithubUser(String userName) {
        return webClient.get()
                .uri("http://localhost:9090/restTemplate/user/{userName}", userName)
                .retrieve()
                .bodyToMono(User.class)
                .block();
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