package com.example.server.server.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SimpleResponse implements ApiResponse {
    private String status = SUCCESS_STATUS;
    private String code = COMPLETE_CODE;
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
