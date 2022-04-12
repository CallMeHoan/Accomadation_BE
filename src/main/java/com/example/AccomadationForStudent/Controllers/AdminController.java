package com.example.AccomadationForStudent.Controllers;

import com.example.AccomadationForStudent.Models.Admin;
import com.example.AccomadationForStudent.Models.ResponseObject;
import com.example.AccomadationForStudent.Repositories.AdminRepository;
import com.example.AccomadationForStudent.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/admin")
public class AdminController {
    private final AdminRepository adminRepository ;
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminRepository adminRepository, AdminService adminService) {
        this.adminRepository = adminRepository;
        this.adminService = adminService;
    }

    @GetMapping("/login")
        //Validate
    ResponseEntity<ResponseObject> Validate(@RequestBody Admin admin){
        return adminService.Validate(admin.getCode());
    }
    @PostMapping("/inputCode")
        //InputCode
    void inputCode(@RequestBody Admin admin)
    {
        adminRepository.save(admin);
    }

}
