package com.mrs.backend.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditoriumDTO {
    private Long auditoriumId;
    private String name;
    private Integer capacity;
}
