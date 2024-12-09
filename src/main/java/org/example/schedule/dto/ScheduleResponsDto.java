package org.example.schedule.dto;

import lombok.Getter;
import org.example.schedule.entity.Schedule;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponsDto {

    private Long id;
    private String authorName;
    private String workTodo;
    private String createdDateTime;
    private String modifyDateTime;

    public ScheduleResponsDto(Schedule schedule) {
        this.id = schedule.getId();
        this.authorName = schedule.getAuthorName();
        this.workTodo = schedule.getWorkTodo();
        this.createdDateTime = schedule.getCreatedDateTime();
        this.modifyDateTime = schedule.getModifyDateTime();

    }

}
