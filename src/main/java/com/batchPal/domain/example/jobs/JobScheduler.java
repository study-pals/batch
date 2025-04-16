package com.batchPal.domain.example.jobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class JobScheduler {
    private final JobLauncher jobLauncher;
    private final Job printMemberIdsJob;

    @Scheduled(fixedRate = 60_000)
    public void runPrintMemberIdsJob() throws Exception {
        JobParameters params = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();

        jobLauncher.run(printMemberIdsJob, params);
    }
}
