package org.example.schedule.repository;

import org.example.schedule.entity.Schedule;

public interface ScheduleRepository {

    Schedule seveTodo(Schedule schedule);

    Schedule findTodoid(Long id);

}
