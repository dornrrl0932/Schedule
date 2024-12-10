package org.example.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.schedule.dto.ScheduleRequestDto;
import org.example.schedule.dto.ScheduleResponsDto;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
public class Schedule {

    @Setter //변경해야 되는 값만 변경될 수 있도록 필드 위에 Setter를 사용
    private Long id;
    private String authorName;
    private String workTodo;
    private Long password;
    private String createdDateTime;
    private String modifyDateTime;

    public Schedule (String authorName, String workTodo, Long password) {
        this.authorName = authorName;
        this.workTodo = workTodo;
        this.password = password;
    }


    public Schedule(Long id, String authorName, String workTodo, Long password) {

        String dateTimeNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        this.id = id;
        this.authorName = authorName;
        this.workTodo = workTodo;
        this.password = password;
        this.createdDateTime = dateTimeNow;
        this.modifyDateTime = dateTimeNow;
    }


    public void updateTodo(String authorName, String workTodo) {
        this.authorName = authorName;
        this.workTodo = workTodo;
        this.modifyDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
