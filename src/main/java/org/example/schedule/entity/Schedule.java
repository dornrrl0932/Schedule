package org.example.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.schedule.dto.ScheduleRequestDto;
import org.example.schedule.dto.ScheduleResponsDto;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
public class Schedule {

    private Long id;
    private String authorName;
    private String workTodo;
    private Long password;
    private String createdDateTime;
    private String modifyDateTime;

    public Schedule(Long id, String authorName, String workTodo, Long password) {
        String dateTimeNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.id = id;
        this.authorName = authorName;
        this.workTodo = workTodo;
        this.password = password;
        this.createdDateTime = dateTimeNow;
        this.modifyDateTime = dateTimeNow;
    }


    public void updateTodo(ScheduleRequestDto dto) {
        this.authorName = dto.getAuthorName();
        this.workTodo = dto.getWorkTodo();
        this.modifyDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
