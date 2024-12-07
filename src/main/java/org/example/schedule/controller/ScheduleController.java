package org.example.schedule.controller;

import org.example.schedule.dto.ScheduleRequestDto;
import org.example.schedule.dto.ScheduleResponsDto;
import org.example.schedule.entity.Schedule;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

        //작성 날짜, 생성
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeNow = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm시 ss초");
        String todayTimeNow = dateTime.format(dateTimeNow);

        //Schecule 객체 생성
        Schedule schedule = new Schedule(todoid,requestDto.getAuthorname(),requestDto.getWorktodo(),requestDto.getPassword(),todayTimeNow);

        //todoList에 Schecule 넣어주기
        todoList.put(todoid,schedule);

        //리턴
        return new ScheduleResponsDto(schedule);

    }

    @GetMapping("/{id}")
    public ScheduleResponsDto lookupTodoId (@PathVariable Long id) {

        //받아온 id로 todo 조회
        Schedule schedule = todoList.get(id);

        //리턴
        return new ScheduleResponsDto(schedule);
    }

}
