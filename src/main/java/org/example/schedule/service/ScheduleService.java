package org.example.schedule.service;

import org.example.schedule.dto.ScheduleRequestDto;
import org.example.schedule.dto.ScheduleResponsDto;

public interface ScheduleService {

    ScheduleResponsDto saveTodo(ScheduleRequestDto requestDto);

    ScheduleResponsDto findTodoId(Long id);

    ScheduleResponsDto updateTodo(Long id, String authorName, String workTodo, Long Password);

    void deleteTodo(Long id, Long password);
}
