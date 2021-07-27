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
    @GetMapping("status404")
    public ResponseEntity<SimpleResponse> getNotFoundStatus() {
        return new ResponseEntity<>(new SimpleResponse("REQ-ERROR", "/status404", "Not found."), HttpStatus.NOT_FOUND);
    }
    @GetMapping("status401")
    public ResponseEntity<SimpleResponse> getNotAuthorizedStatus() {
        return new ResponseEntity<>(new SimpleResponse("REQ-ERROR", "/status401", "Not authorized."), HttpStatus.valueOf(401));
    }
    @GetMapping("status501")
    public ResponseEntity<SimpleResponse> getServerErrorStatus() {
        return new ResponseEntity<>(new SimpleResponse("Server error."), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
