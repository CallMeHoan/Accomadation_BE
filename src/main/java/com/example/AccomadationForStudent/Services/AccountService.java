package com.example.AccomadationForStudent.Services;

import com.example.AccomadationForStudent.Models.Account;
import com.example.AccomadationForStudent.Models.ResponseObject;
import com.example.AccomadationForStudent.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public ResponseEntity<ResponseObject> Validate(String username, String password) {
        Optional<Account> foundAccount = accountRepository.findAccountByUsernameAndPassword(username, password);
        if (foundAccount.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("200", "Login successfully", foundAccount)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("404", "Login unsuccessful", "")
            );
        }
    }
}
