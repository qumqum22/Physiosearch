package com.rehabilitation.demo.services;

import com.rehabilitation.demo.models.Rehabilitations;
import com.rehabilitation.demo.repository.RehabilitationsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RehabilitationsService {
    private final RehabilitationsRepository rehabilitationsRepository;

    public RehabilitationsService(RehabilitationsRepository rehabilitationsRepository) {
        this.rehabilitationsRepository = rehabilitationsRepository;
    }

    public List<Rehabilitations> getSpecializations() {
        return rehabilitationsRepository.findAll();
    }
}
