package com.batchPal.domain.example.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "username", nullable = false, unique = true, length = 255)
    private String username;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "nickname", nullable = false, unique = true, length = 255)
    private String nickname;

    @Column(name = "birthday", nullable = true, columnDefinition = "DATE")
    private LocalDate birthday;

    @Column(name = "position", nullable = true, length = 255)
    private String position;

    @Column(name = "image_url", nullable = true, length = 255)
    private String imageUrl;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDate createdAt;
}
