package org.example.schedule.controller;

import org.example.schedule.dto.ScheduleRequestDto;
import org.example.schedule.dto.ScheduleResponsDto;
import org.example.schedule.entity.Schedule;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/todos")
public class ScheduleController {

    private final Map<Long, Schedule> todoList = new HashMap<>();


    @PostMapping
    public ScheduleResponsDto createtodo (@RequestBody ScheduleRequestDto requestDto) {

        //id 생성
        Long todoid = todoList.isEmpty() ? 1 : Collections.max(todoList.keySet()) + 1;

        //Schecule 객체 생성
        Schedule schedule = new Schedule(todoid,requestDto.getAuthorName(),requestDto.getWorkTodo(),requestDto.getPassword());

        //todoList에 Schecule 넣어주기
        todoList.put(todoid,schedule);

        //리턴
        return new ScheduleResponsDto(schedule);

    }


    //조건에 해당하는 일정 전부 조회_작성자
    @GetMapping("name/{authorname}")
    public  ScheduleResponsDto looupTodoName (@PathVariable String authorname) {

        //schedule 객체 만들기
        Schedule schedule = todoList.get(authorname);

        //리턴
        return new ScheduleResponsDto(schedule);
    }


//    //조건에 해당하는 일정 전부 조회_날짜
//    @GetMapping("/{createdDateTime}")
//    public  ScheduleResponsDto looupTodoDate (@PathVariable String createdDateTime) {
//
//        List<ScheduleResponsDto> responsList = new ArrayList<>();
//
//        for (Schedule schedule : todoList.get()
//
//
//        //리턴
//        return responsList;
//    }

//    //조건에 해당하는 일정 전부 조회
//    @GetMapping("/{authorname},{createdDateTime}")
//    public  ScheduleResponsDto looupTodoAll (@PathVariable String authorname, String createdDateTime) {
//
//        //schedule 객체 만들기
//        Schedule schedule = todoList.get(authorname);
//
//        //리턴
//        return new ScheduleResponsDto(schedule);
//    }


    //id를 통해 일정 조회
    @GetMapping("/{id}")
    public ScheduleResponsDto lookupTodoId (@PathVariable Long id) {

        //받아온 id로 todo 조회
        Schedule schedule = todoList.get(id);

        //리턴
        return new ScheduleResponsDto(schedule);
    }

    //작성자, 할 일 수정, 비밀번호 비교 필요/수정 시 수정일 표시
    @PatchMapping("id/{id}")
        public ScheduleResponsDto updateTodo(@PathVariable Long id ,@RequestBody ScheduleRequestDto dto) {

        Schedule schedule = todoList.get(id);

        if(schedule.getPassword().equals(dto.getPassword())) {
            schedule.updateTodo(dto);
        }

        return new ScheduleResponsDto(schedule);
    }

    //삭제, 비밀번호 비교 필요
    @DeleteMapping("/{id}")
    public void deleteTodo (@PathVariable Long id, @RequestBody ScheduleRequestDto dto) {

        Schedule schedule = todoList.get(id);

        if(schedule.getPassword().equals(dto.getPassword())) {
            todoList.remove(id);
        }
    }
}
