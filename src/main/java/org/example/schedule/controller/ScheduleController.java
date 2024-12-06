package org.example.schedule.controller;

import org.example.schedule.dto.ScheduleRequestDto;
import org.example.schedule.dto.ScheduleResponsDto;
import org.example.schedule.entity.Schedule;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/todos")
public class ScheduleController {

    private final Map<Long, Schedule> todoList = new HashMap<>();


    @PostMapping
    public ScheduleResponsDto createtodo (@RequestBody ScheduleRequestDto requestDto) {

        //id 생성
        Long todoid = todoList.isEmpty() ? 1 : Collections.max(todoList.keySet()) + 1;

        //날짜 생성
        LocalDateTime dateTime = LocalDateTime.now();

        //Schecule 객체 생성
        Schedule schedule = new Schedule(todoid,requestDto.getAuthorname(),requestDto.getWorktodo(),requestDto.getPassword(),dateTime);

        //todoList에 Schecule 넣어주기
        todoList.put(todoid,schedule);

        //리턴
        return new ScheduleResponsDto(schedule);

    }

}
