package com.mrs.backend.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    @NotBlank(message = "Title is required")
    @Size(max = 50)
    @Column(name = "title")
    private String title;

    @NotBlank(message = "Description is required")
    @Size(max = 500)
    @Column(name = "description")
    private String description;

    @NotBlank(message = "Poster image is required")
    @Column(name = "poster_image")
    private String posterImage;

    @NotNull(message = "Genre is required")
    @Column(name = "genre")
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @NotBlank(message = "Rating is required")
    @Column(name = "rating")
    private String rating;

    @NotBlank(message = "Duration is required")
    @Column(name = "duration")
    private String duration;

    @NotNull(message = "Language is required")
    @Column(name = "language")
    @Enumerated(EnumType.STRING)
    private Language language;

    @OneToMany(mappedBy = "movie")
    private List<Schedules> schedules;
    
}
