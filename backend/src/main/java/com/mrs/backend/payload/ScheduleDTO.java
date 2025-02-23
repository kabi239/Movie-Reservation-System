package com.mrs.backend.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {
    private Long scheduleId;
    private Long movieId;
    private Long auditoriumId;
    private String s_year;
    private String s_month;
    private String s_day;
    private String s_hour;
    private String s_minute;
}
