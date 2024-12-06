package org.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleRequestDto {

    private String authorname;
    private String worktodo;
    private Long password;

}
