package org.example.schedule.dto;

import lombok.Getter;
import org.example.schedule.entity.Schedule;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponsDto {

    private Long id;
    private String authorname;
    private String worktodo;
    private LocalDateTime createdDateTime;

    public ScheduleResponsDto(Schedule schedule) {
        this.id = schedule.getId();
        this.authorname = schedule.getAuthorname();
        this.worktodo = schedule.getWorktodo();
        this.createdDateTime = schedule.getCreatedDateTime();
    }

}
