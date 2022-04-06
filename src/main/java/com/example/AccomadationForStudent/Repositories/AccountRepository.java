package com.example.AccomadationForStudent.Repositories;

import com.example.AccomadationForStudent.Models.Account;
import com.example.AccomadationForStudent.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> getAccount(String username, String password);
}
