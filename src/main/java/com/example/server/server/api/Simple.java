package com.example.server.server.api;

import com.example.server.server.model.SimpleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Simple {
    @GetMapping
    public ResponseEntity<SimpleResponse> getSimpleStatus() {
        return new ResponseEntity<SimpleResponse>(new SimpleResponse("Hello, world."), HttpStatus.OK);
    }
}
