package org.example.schedule.service;

import org.example.schedule.dto.ScheduleRequestDto;
import org.example.schedule.dto.ScheduleResponsDto;
import org.example.schedule.entity.Schedule;
import org.example.schedule.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

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
}
