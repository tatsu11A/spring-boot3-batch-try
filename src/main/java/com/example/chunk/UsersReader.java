package com.example.springboot3batchtry.chunk;

import com.example.springboot3batchtry.entity.Users;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class UsersReader {

    @Bean
    public RepositoryItemReader<Users> reader(UserRepository userRepository) {
        RepositoryItemReader<Users> reader = new RepositoryItemReader<>();
        reader.setRepository(userRepository);
        reader.setMethodName("findAll");
        reader.setSort(Collections.singletonMap("id", Sort.Direction.ASC));
        return reader;
    }
}
