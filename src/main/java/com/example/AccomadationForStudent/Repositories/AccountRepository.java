package com.example.AccomadationForStudent.Repositories;

import com.example.AccomadationForStudent.Models.Account;
import com.example.AccomadationForStudent.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT a FROM Account a WHERE a.username = ?1 and a.password = ?2")
    Optional<Account> findAccountByUsernameAndPassword(String username, String password);

    Optional<Account> findAccountByUsername(String username);
}
