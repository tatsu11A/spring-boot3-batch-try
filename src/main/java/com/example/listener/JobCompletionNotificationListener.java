package com.example.springboot3batchtry.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class JobCompletionNotificationListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("=== �W���u�J�n: " + jobExecution.getJobInstance().getJobName() + " ===");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("=== �W���u�I��: " + jobExecution.getStatus() + " ===");
    }
}
