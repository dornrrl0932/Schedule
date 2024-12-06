package org.example.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Schedule {

    private Long id;
    private String Authorname;
    private String worktodo;
    private Long password;
    private LocalDateTime createdDateTime;

}
