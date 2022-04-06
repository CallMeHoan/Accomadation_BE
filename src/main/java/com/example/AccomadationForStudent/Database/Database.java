package com.example.AccomadationForStudent.Database;

import com.example.AccomadationForStudent.Models.Accommodation;
import com.example.AccomadationForStudent.Models.User;
import com.example.AccomadationForStudent.Repositories.AccommodationRepository;
import com.example.AccomadationForStudent.Repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase (UserRepository userRepository, AccommodationRepository accommodationRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                User userA = new User("Hoan Ne", "17/09/2001", "0794676336", "Male", "hoanne@gmail.com");
                User userB = new User("Dat Ne", "17/09/2001", "0917124123", "Male", "datne@gmail.com");
                Accommodation accommodation = new Accommodation("Nhatro1",  "Còn trống", 2, true, 2, 1, 30.0, "123/10", 1000000.1, 3, 3);
                logger.info("insert data:" + userRepository.save(userA));
                logger.info("insert data:" + userRepository.save(userB));
                logger.info("insert data:" + accommodationRepository.save(accommodation));
            }
        };
    }
}
