package com.example.springboot3batchtry.config;

import com.example.springboot3batchtry.listener.JobCompletionNotificationListener;
import com.example.springboot3batchtry.tasklet.SampleTasklet;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing  // ← ここを有効にする

public class BatchConfig {

    @Bean
    public SampleTasklet sampleTasklet() {
        return new SampleTasklet();
    }

    @Bean
    public Job sampleJob(JobBuilderFactory jobBuilderFactory,
                         Step sampleStep,
                         JobCompletionNotificationListener listener) {
        return jobBuilderFactory.get("sampleJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(sampleStep)
                .end()
                .build();
    }

    @Bean
    public Step sampleStep(StepBuilderFactory stepBuilderFactory, SampleTasklet sampleTasklet) {
        return stepBuilderFactory.get("sampleStep")
                .tasklet(sampleTasklet)
                .build();
    }

    @Bean
    public JobCompletionNotificationListener listener() {
        return new JobCompletionNotificationListener();
    }
}
