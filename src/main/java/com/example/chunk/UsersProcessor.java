package com.example.springboot3batchtry.chunk;

import com.example.springboot3batchtry.entity.Users;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class UsersProcessor implements ItemProcessor<Users, Users> {
    @Override
    public Users process(Users item) {
        item.setName(item.getName().toUpperCase());
        return item;
    }
}
