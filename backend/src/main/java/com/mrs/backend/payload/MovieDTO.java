package com.mrs.backend.payload;

import com.mrs.backend.model.Language;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    private Long movieId;
    private String title;
    private String description;
    private String posterImage;
    private String genre;
    private String rating;
    private String duration;
    private Language language;
}
