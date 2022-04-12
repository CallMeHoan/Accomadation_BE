package com.example.AccomadationForStudent.Services;

import com.example.AccomadationForStudent.Models.Account;
import com.example.AccomadationForStudent.Models.ResponseObject;
import com.example.AccomadationForStudent.Models.User;
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

    public ResponseEntity<ResponseObject> Register(Account newAccount) {
        Optional<Account> foundAccount = accountRepository.findAccountByUsername(newAccount.getUsername());
        if (foundAccount.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("409", "Username already exists", "")
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("200", "Registered", accountRepository.save(newAccount))
            );
        }
    }

    //Note: Update by username. Only update password, userID and role. Unable to update username.
    public ResponseEntity<ResponseObject> Update(Account account) {
        Optional<Account> foundAccount = accountRepository.findAccountByUsername(account.getUsername());
        if (foundAccount.isPresent()) {
            foundAccount.map(updateAccount -> {
                        updateAccount.setPassword(account.getPassword());
                        updateAccount.setUserID(account.getUserID());
                        updateAccount.setRole(account.getRole());
                        return accountRepository.save(updateAccount);
                    });
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("200", "Update user successfully", foundAccount)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("404", "Username not found", "")
            );
        }
    }

    //Note: Delete by username, and have to validate the account before deleting.
    public ResponseEntity<ResponseObject> Delete(Account account){
        Optional<Account> foundAccount = accountRepository.findAccountByUsernameAndPassword(account.getUsername(), account.getPassword());
        if (foundAccount.isPresent()) {
            accountRepository.deleteById(foundAccount.get().getId());
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("200", "Delete account successfully", "")
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("404", "Account not found", "")
            );
        }
    }
}
