package com.batchPal.domain.example.jobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.batchPal.global.config.TransactionManagerConfig;

@Configuration
public class PrintMemberIdJobConfig {
    private final JobRepository jobRepository;
    private final PrintMemberIdsTasklet tasklet;
    private final PlatformTransactionManager transactionManager;

    public PrintMemberIdJobConfig(
            JobRepository jobRepository,
            @Qualifier(TransactionManagerConfig.DOMAIN_TRANSACTION_MANAGER)
                    PlatformTransactionManager transactionManager,
            PrintMemberIdsTasklet tasklet) {

        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
        this.tasklet = tasklet;
    }

    @Bean
    public Job printMemberIdsJob() {
        return new JobBuilder("printMemberIdsJob", jobRepository)
                .start(printMemberIdsStep())
                .build();
    }

    @Bean
    public Step printMemberIdsStep() {
        return new StepBuilder("printMemberIdsStep", jobRepository)
                .tasklet(tasklet, transactionManager)
                .build();
    }
}
