package com.example.AccomadationForStudent.Services;

import com.example.AccomadationForStudent.Models.Account;
import com.example.AccomadationForStudent.Models.Admin;
import com.example.AccomadationForStudent.Models.ResponseObject;
import com.example.AccomadationForStudent.Repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AdminService {
    private final AdminRepository adminRepository;
    @Autowired
    public AdminService(AdminRepository adminRepository)
    {
        this.adminRepository = adminRepository;
    }

    public ResponseEntity<ResponseObject> Validate(String code) {
        Optional<Admin> foundAdmin = adminRepository.findAdminByCode(code);
        if (foundAdmin.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("200", "Login successfully", foundAdmin)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("404", "Login failed", "")
            );
        }
    }


}
