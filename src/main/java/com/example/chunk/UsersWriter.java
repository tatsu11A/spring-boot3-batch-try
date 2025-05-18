package com.example.springboot3batchtry.chunk;

import com.example.springboot3batchtry.entity.Users;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersWriter implements ItemWriter<Users> {
    @Override
    public void write(List<? extends Users> items) {
        items.forEach(user -> System.out.println("書き込み: " + user.getName()));
    }
}
