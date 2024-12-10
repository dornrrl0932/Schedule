package org.example.schedule.service;

import org.example.schedule.dto.ScheduleRequestDto;
import org.example.schedule.dto.ScheduleResponsDto;
import org.example.schedule.entity.Schedule;
import org.example.schedule.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/*
ScheduleService를 구현한 구현체
 */
@Service
public class ScheduleServiceImpl implements ScheduleService{

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }


    @Override
    public ScheduleResponsDto saveTodo(ScheduleRequestDto requestDto) {

        //요청받은 데이터로 schedule 객체 생성
        Schedule schedule = new Schedule(requestDto.getAuthorName(), requestDto.getWorkTodo(), requestDto.getPassword());

        //DB에 저장하기
        Schedule savedTodo = scheduleRepository.seveTodo(schedule);

        return new ScheduleResponsDto(savedTodo);
    }

    /*

     */
    @Override
    public ScheduleResponsDto findTodoId(Long id) {

        //id를 통해 할일을 반환
        Schedule schedule = scheduleRepository.findTodoid(id);

        // NPE 방지
        if(schedule == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"id를 찾을 수 없습니다.");
        }

        return new ScheduleResponsDto(schedule);
    }

    @Override
    public ScheduleResponsDto updateTodo(Long id, String authorName, String workTodo, Long password) {
        //id를 통해 todo 조회
        Schedule schedule = scheduleRepository.findTodoid(id);

        //NPE 방지
        if (schedule == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"id를 찾을 수 없습니다.");
        }

        //필수값 검증(authorName, workTodo)
        if(authorName == null || workTodo == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"수정 할 내용을 작성해주세요.");
        }

        if(schedule.getPassword().equals(password)) {
            schedule.updateTodo(authorName,workTodo);
        }

        return new ScheduleResponsDto(schedule);
    }
}
