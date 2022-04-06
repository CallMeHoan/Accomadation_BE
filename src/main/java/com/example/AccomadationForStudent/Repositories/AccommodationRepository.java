package com.example.AccomadationForStudent.Repositories;

import com.example.AccomadationForStudent.Models.Accommodation;
import com.example.AccomadationForStudent.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

}
