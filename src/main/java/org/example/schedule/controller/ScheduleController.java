package org.example.schedule.controller;

import org.example.schedule.dto.ScheduleRequestDto;
import org.example.schedule.dto.ScheduleResponsDto;
import org.example.schedule.entity.Schedule;
import org.example.schedule.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/todos")
public class ScheduleController {

    private final ScheduleService scheduleService;

    /*
    scheduleService를 사용하기 위해서는 생성자 주입을 꼭 해야한다.
     */
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }


    @PostMapping
    public ResponseEntity<ScheduleResponsDto> createtodo (@RequestBody ScheduleRequestDto requestDto) {

        //scheduleService 호출하기, 응답
        return new ResponseEntity<>(scheduleService.saveTodo(requestDto), HttpStatus.CREATED);
    }


    //id를 통해 일정 조회
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponsDto> lookupTodoId (@PathVariable Long id) {

        //scheduleService 호출하기, 응답
        return new ResponseEntity<>(scheduleService.findTodoId(id), HttpStatus.CREATED);
    }


    //작성자, 할 일 수정, 비밀번호 비교 필요/수정 시 수정일 표시
    @PatchMapping("id/{id}")
        public ResponseEntity<ScheduleResponsDto> updateTodo(@PathVariable Long id ,@RequestBody ScheduleRequestDto requestDto) {

        //scheduleService 호출하기, 응답
        return new ResponseEntity<>(scheduleService.updateTodo(id, requestDto.getAuthorName(), requestDto.getWorkTodo(),requestDto.getPassword()), HttpStatus.CREATED);
    }

    //삭제, 비밀번호 비교 필요
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo (@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {

        scheduleService.deleteTodo(id,requestDto.getPassword());


        return new ResponseEntity<>(HttpStatus.OK);
    }
}
