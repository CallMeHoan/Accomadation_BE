package com.example.AccomadationForStudent.Services;

import com.example.AccomadationForStudent.Models.Accommodation;
import com.example.AccomadationForStudent.Models.ResponseObject;
import com.example.AccomadationForStudent.Models.User;
import com.example.AccomadationForStudent.Repositories.AccommodationRepository;
import com.example.AccomadationForStudent.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationService {

    private final AccommodationRepository accommodationRepository;

    @Autowired
    public AccommodationService(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    public ResponseEntity<ResponseObject> addAccommodation(Accommodation accommodation){
        return  ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("200", "Add accommodation successfully", accommodationRepository.save(accommodation))
        );
    }
    public ResponseEntity<ResponseObject> findAccommodationByID(long id){
        Optional<Accommodation> optionalAccommodation = accommodationRepository.findById(id);
        if(optionalAccommodation.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("200", "Get accommodation detail successfully", optionalAccommodation)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("404", "Cannot found this accommodation by Id: " + id, "")
            );
        }
    }
    public ResponseEntity<ResponseObject> updateAccomadation(Accommodation newAccomadation, Long id){
        Optional<Accommodation> updateAccommodation = accommodationRepository.findById(id)
                .map(accommodation -> {
                   accommodation.setName(newAccomadation.getName());
                   accommodation.setAddress(newAccomadation.getAddress());
                   accommodation.setArea(newAccomadation.getArea());
                   accommodation.setAvailable(newAccomadation.getAvailable());
                   accommodation.setFloor(newAccomadation.getFloor());
                   accommodation.setDescription(newAccomadation.getDescription());
                   accommodation.setPeople(newAccomadation.getPeople());
                   accommodation.setToilets(newAccomadation.getToilets());
                   accommodation.setWifi_Access(newAccomadation.isWifi_Access());
                   accommodation.setPrice(newAccomadation.getPrice());
                   accommodation.setRooms(newAccomadation.getRooms());
                   return accommodationRepository.save(accommodation);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("200", "Update Accomadation successfully", updateAccommodation)
        );
    }
}
