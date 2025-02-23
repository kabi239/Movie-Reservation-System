package com.mrs.backend.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrs.backend.exceptions.ResourceNotFoundException;
import com.mrs.backend.model.Schedules;
import com.mrs.backend.payload.ScheduleDTO;
import com.mrs.backend.repository.ScheduleRepository;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ScheduleDTO createSchedule(ScheduleDTO scheduleDTO) {
        Schedules schedule = modelMapper.map(scheduleDTO, Schedules.class);
        schedule = scheduleRepository.save(schedule);
        return modelMapper.map(schedule, ScheduleDTO.class);
    }

    public List<ScheduleDTO> getAllSchedules() {
        List<Schedules> schedules = scheduleRepository.findAll();
        return schedules.stream().map(schedule -> modelMapper.map(schedule, ScheduleDTO.class)).toList();
    }

    public ScheduleDTO getScheduleById(Long id) {
        Schedules schedule = scheduleRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Schedule", "sheduleId", id));
        return modelMapper.map(schedule, ScheduleDTO.class);
    }

    public void deleteSchedule(Long id) {
        Schedules schedule = scheduleRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Schedule", "sheduleId", id));
        scheduleRepository.delete(schedule);
    }


}
