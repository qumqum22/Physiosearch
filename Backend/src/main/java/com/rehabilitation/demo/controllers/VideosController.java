package com.rehabilitation.demo.controllers;

import com.rehabilitation.demo.repository.VideosRepository;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideosController {

    public VideosController(VideosRepository repository) {
    }
}
