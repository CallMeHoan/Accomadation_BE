package com.example.AccomadationForStudent.Repositories;

import com.example.AccomadationForStudent.Models.Account;
import com.example.AccomadationForStudent.Models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findAdminByCode(String code);
}
