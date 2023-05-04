package com.epam.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "post")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "serial")
    private Long id;

    @NotNull
    @Min(1)
    @Column(nullable = false)
    private Long authorId;

    @NotBlank
    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private LocalDateTime postedAt;
}
