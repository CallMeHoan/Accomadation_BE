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

@RestController
@RequestMapping(path = "api/v1/Accommodations")
public class AccommodationController {
    private AccommodationService accommodationService;
    @Autowired
    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findAccommodationByID(@PathVariable long id) {
        return accommodationService.findAccommodationByID(id);
    }
    @PostMapping("/add-accommodations")
    public ResponseEntity<ResponseObject> addAccommodation(@RequestBody Accommodation accommodation){
        return accommodationService.addAccommodation(accommodation);
    }
}
