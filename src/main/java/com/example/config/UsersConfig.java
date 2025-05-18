package com.example.springboot3batchtry.config;

import com.example.springboot3batchtry.chunk.UsersProcessor;
import com.example.springboot3batchtry.chunk.UsersWriter;
import com.example.springboot3batchtry.entity.Users;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsersConfig {

    @Bean
    public Job usersJob(JobBuilderFactory jobBuilderFactory, Step usersStep) {
        return jobBuilderFactory.get("usersJob")
                .incrementer(new RunIdIncrementer())
                .start(usersStep)
                .build();
    }

    @Bean
    public Step usersStep(StepBuilderFactory stepBuilderFactory,
                          RepositoryItemReader<Users> reader,
                          UsersProcessor processor,
                          UsersWriter writer) {
        return stepBuilderFactory.get("usersStep")
                .<Users, Users>chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}
