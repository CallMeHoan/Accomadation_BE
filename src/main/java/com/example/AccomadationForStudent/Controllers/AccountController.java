package com.example.AccomadationForStudent.Controllers;

import com.example.AccomadationForStudent.Models.Account;
import com.example.AccomadationForStudent.Models.ResponseObject;
import com.example.AccomadationForStudent.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/accounts")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;
    @PostMapping("/login")
    ResponseEntity<ResponseObject> Validate(@RequestBody Account account) {
        return null;
    }
}
