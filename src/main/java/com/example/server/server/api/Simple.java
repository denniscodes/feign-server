package com.example.server.server.api;

import com.example.server.server.model.ApiResponse;
import com.example.server.server.model.ExtendedResponse;
import com.example.server.server.model.SimpleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.sleep;

@RestController
@Slf4j
public class Simple {
    public static final Integer MAX_DELAY = 10;

    private Map<Integer, ApiResponse> responses = new HashMap<>();

    @PostConstruct
    public void initMap() {
        responses.put(200, new ExtendedResponse("Hello In There", "Modern depression."));
        responses.put(404, new SimpleResponse("REQ-ERROR", "/status404", "Not found."));
        responses.put(401, new SimpleResponse("REQ-ERROR", "/status401", "Not authorized."));
        responses.put(500, new SimpleResponse("SVR-ERROR", "/status500", "Internal error."));
        responses.put(501, new SimpleResponse("SVR-ERROR", "/status501", "Not implemented."));
        responses.put(502, new SimpleResponse("SVR-ERROR", "/status502", "Bad gateway."));
        responses.put(503, new SimpleResponse("SVR-ERROR", "/status503", "Server unavailable."));
    }
    @RequestMapping(value="/", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getAnyStatus(@RequestParam(value = "status", defaultValue = "200") Integer status) {
        if (status == null) return new ResponseEntity<>(responses.get(Integer.valueOf(200)), HttpStatus.OK);
        ApiResponse response = responses.get(status);
        if (response == null) {
            response = new SimpleResponse(ApiResponse.ERROR_STATUS,
                    ApiResponse.COMPLETE_CODE, String.format("Unexpected status code %d", status));
            status = HttpStatus.BAD_REQUEST.value();
        }

        return new ResponseEntity<ApiResponse>(response, HttpStatus.valueOf(status));
    }

    @RequestMapping(value="/delay", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getSuccessWithDelay(@RequestParam(value = "delay", defaultValue = "5") Integer delay) {
        if (delay < 1 || delay > MAX_DELAY) {
            return new ResponseEntity<>(new SimpleResponse(ApiResponse.ERROR_STATUS, "Parameter error.",
                    String.format("Delay must be between 1 and %d seconds.",  MAX_DELAY)),
                    HttpStatus.BAD_REQUEST);
        }

        try {
            sleep(delay*1000);
        } catch (InterruptedException e) {
            return new ResponseEntity<>(new SimpleResponse(ApiResponse.ERROR_STATUS, e.getClass().getSimpleName(), e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new SimpleResponse(ApiResponse.SUCCESS_STATUS, "OK", "Timeout expired."), HttpStatus.OK);
    }
}
