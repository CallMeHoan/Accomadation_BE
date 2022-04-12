package com.example.AccomadationForStudent.Services;

import com.example.AccomadationForStudent.Models.Accommodation;
import com.example.AccomadationForStudent.Models.ResponseObject;
import com.example.AccomadationForStudent.Models.User;
import com.example.AccomadationForStudent.Repositories.AccommodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AccommodationService {

    private final AccommodationRepository accommodationRepository;

    @Autowired
    public AccommodationService(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }
    // Post
    public ResponseEntity<ResponseObject> addAccommodation(Accommodation accommodation){
        return  ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("200", "Add accommodation successfully", accommodationRepository.save(accommodation))
        );
    }
    // Get
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
    // Put
    @Transactional
    public ResponseEntity<ResponseObject> updateAccommodation(Accommodation newAccommodation, Long id){
        boolean exists = accommodationRepository.existsById(id);
        if(!exists){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("404", "Cannot found this accommodation by Id: " + id, "")
            );
        }
        else {
            Optional<Accommodation> updateAccommodation = accommodationRepository.findById(id)
                    .map(accommodation -> {
                        accommodation.setName(newAccommodation.getName());
                        accommodation.setAddress(newAccommodation.getAddress());
                        accommodation.setArea(newAccommodation.getArea());
                        accommodation.setAvailable(newAccommodation.getAvailable());
                        accommodation.setFloor(newAccommodation.getFloor());
                        accommodation.setDescription(newAccommodation.getDescription());
                        accommodation.setPeople(newAccommodation.getPeople());
                        accommodation.setToilets(newAccommodation.getToilets());
                        accommodation.setWifi_Access(newAccommodation.isWifi_Access());
                        accommodation.setPrice(newAccommodation.getPrice());
                        accommodation.setRooms(newAccommodation.getRooms());
                        return accommodationRepository.save(accommodation);
                    });
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("200", "Update accommodation successfully", updateAccommodation)
            );
        }
    }
    // Delete
    public ResponseEntity<ResponseObject> deleteAccommodation(Long id) {
        boolean exists = accommodationRepository.existsById(id);
        if(!exists){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("404", "Cannot found this accommodation by Id: " + id, "")
            );
        }
        else{
            accommodationRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("200", "Delete accommodation by Id: " + id + "successfully", "")
            );
        }
    }

    public ResponseEntity<ResponseObject> getAllAccommodations() {
        List<Accommodation> accommodationList = accommodationRepository.findAll();
        if (accommodationList.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("200", "Get all user successfully", accommodationList)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("404", "Cannot found any user", "")
            );
        }
    }
}
