package com.example.AccomadationForStudent.Controllers;

import com.example.AccomadationForStudent.Models.Accommodation;
import com.example.AccomadationForStudent.Models.ResponseObject;
import com.example.AccomadationForStudent.Models.User;
import com.example.AccomadationForStudent.Repositories.UserRepository;
import com.example.AccomadationForStudent.Services.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/accommodations")
public class AccommodationController {
    private final AccommodationService accommodationService;

    @Autowired
    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }
    @GetMapping
    public ResponseEntity<ResponseObject> getAllAccommodations(){
        return accommodationService.getAllAccommodations();
    }
    @GetMapping(path="{id}")
    public ResponseEntity<ResponseObject> findAccommodationByID(@PathVariable long id) {
        return accommodationService.findAccommodationByID(id);
    }
    @PostMapping
    public ResponseEntity<ResponseObject> addAccommodation(@RequestBody Accommodation accommodation){
        return accommodationService.addAccommodation(accommodation);
    }
    @PutMapping(path="{id}")
    public ResponseEntity<ResponseObject> updateAccommodation(@PathVariable("id") Long id,  @RequestBody Accommodation newAccommodation){
        return accommodationService.updateAccommodation(newAccommodation, id);
    }
    @DeleteMapping(path="{id}")
    public ResponseEntity<ResponseObject> deleteAccommodation(@PathVariable("id") Long id){
        return accommodationService.deleteAccommodation(id);
    }
}
