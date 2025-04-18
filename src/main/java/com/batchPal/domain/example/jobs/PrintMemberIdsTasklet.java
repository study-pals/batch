package com.batchPal.domain.example.jobs;

import java.util.List;

import lombok.NonNull;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

import com.batchPal.domain.example.dao.MemberRepository;
import com.batchPal.domain.example.entity.Member;

@Component
@RequiredArgsConstructor
public class PrintMemberIdsTasklet implements Tasklet {

    private final MemberRepository memberRepository;

    @Override
    public RepeatStatus execute(@NonNull StepContribution contribution, @NonNull ChunkContext chunkContext) {
        List<Long> ids = memberRepository.findAll().stream().map(Member::getId).toList();

        System.out.println("📢 All Member IDs: " + ids);
        return RepeatStatus.FINISHED;
    }
}
