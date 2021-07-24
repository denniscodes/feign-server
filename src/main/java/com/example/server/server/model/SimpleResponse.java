package com.example.server.server.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SimpleResponse {
    private String status = "SUCCESS";
    private String code = "OK";
    private String reason;

    public SimpleResponse(String reason) {
        this.reason = reason;
    }
}
