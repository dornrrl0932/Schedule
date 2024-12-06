package org.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponsDto {
    private Long id;
    private String worktodo;
    private String Authorname;
    private LocalDateTime createdDateTime;

}
