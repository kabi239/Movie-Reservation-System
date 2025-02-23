package com.mrs.backend.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrs.backend.exceptions.ResourceNotFoundException;
import com.mrs.backend.model.Auditorium;
import com.mrs.backend.payload.AuditoriumDTO;
import com.mrs.backend.repository.AuditoriumRepository;

@Service
public class AuditoriumService {

    @Autowired
    private AuditoriumRepository auditoriumRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AuditoriumDTO createAuditorium(AuditoriumDTO auditoriumDTO) {
        Auditorium auditorium = modelMapper.map(auditoriumDTO, Auditorium.class);
        Auditorium savedAuditorium = auditoriumRepository.save(auditorium);
        return modelMapper.map(savedAuditorium, AuditoriumDTO.class);
    }

    public List<AuditoriumDTO> getAllAuditorium() {
        List<Auditorium> auditoriums = auditoriumRepository.findAll();
        return auditoriums.stream().map(auditorium -> modelMapper.map(auditorium, AuditoriumDTO.class))
                .toList();
    }

    public AuditoriumDTO getAuditoriumById(Long id) {
        Auditorium auditorium = auditoriumRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Auditorium", "auditoriumId", id));
        return modelMapper.map(auditorium, AuditoriumDTO.class);
    }

    public void deleteAuditorium(Long id) {
        auditoriumRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Auditorium", "auditoriumId", id));
        auditoriumRepository.deleteById(id);
    }

    

}
