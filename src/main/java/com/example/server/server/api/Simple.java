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
    @GetMapping("status500")
    public ResponseEntity<SimpleResponse> getServerErrorStatus() {
        return new ResponseEntity<>(new SimpleResponse("SVR-ERROR", "/status500", "Internal error."), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("status501")
    public ResponseEntity<SimpleResponse> getNotImplementedStatus() {
        return new ResponseEntity<>(new SimpleResponse("SVR-ERROR", "/status501", "Not implemented."), HttpStatus.NOT_IMPLEMENTED);
    }
    @GetMapping("status502")
    public ResponseEntity<SimpleResponse> getGatewayErrorStatus() {
        return new ResponseEntity<>(new SimpleResponse("SVR-ERROR", "/status502", "Bad gateway."), HttpStatus.BAD_GATEWAY);
    }
    @GetMapping("status503")
    public ResponseEntity<SimpleResponse> getServiceUnavailableStatus() {
        return new ResponseEntity<>(new SimpleResponse("SVR-ERROR", "/status503", "Server unavailable."), HttpStatus.SERVICE_UNAVAILABLE);
    }

}
