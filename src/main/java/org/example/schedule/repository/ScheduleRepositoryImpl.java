package org.example.schedule.repository;

import org.example.schedule.entity.Schedule;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
ScheduleRepository 구현한 구현체
 */
@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository{

    private final Map<Long, Schedule> todoList = new HashMap<>();

    @Override
    public Schedule seveTodo(Schedule schedule) {

        //id 생성
        Long todoid = todoList.isEmpty() ? 1 : Collections.max(todoList.keySet()) + 1;

        //setter를 통해 id값이 생성
        schedule.setId(todoid);

        todoList.put(todoid, schedule);

        return schedule;
    }

    /*
    전달받은 id값에 해당하는 할 일은 반환
     */
    @Override
    public Schedule findTodoid(Long id) {
        return todoList.get(id);
    }

    /*
    전달받은 id값에 해당하는 할 일을 삭제
     */
    @Override
    public void deleteTodo(Long id) {
        todoList.remove(id);
    }
}
