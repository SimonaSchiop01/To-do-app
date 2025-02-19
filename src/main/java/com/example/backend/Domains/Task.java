package com.example.backend.Domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task extends BaseEntity {

    @Column(length=50)
    private String status;

    @Column(nullable = false, length=50)
    private String title;

    @Column(nullable = false, length=200)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
