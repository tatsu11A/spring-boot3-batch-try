package com.example.springboot3batchtry;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot3BatchTryApplication implements CommandLineRunner {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot3BatchTryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		jobLauncher.run(job, new org.springframework.batch.core.JobParameters());
	}

}
