package com.example.server.server.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SimpleResponse {
    private String status = "SUCCESS";
    private String code = "OK";
    private String reason;

    public SimpleResponse(String status, String code, String reason) {
        this.status = status;
        this.code = code;
        this.reason = reason;
    }

    public SimpleResponse(String reason) {
        this.reason = reason;
    }
}
