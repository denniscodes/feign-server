package com.example.server.server.model;

public interface ApiResponse {
    public static final String SUCCESS_STATUS = "SUCCESS";
    public static final String ERROR_STATUS = "ERROR";

    public static final String COMPLETE_CODE = "COMPLETE";
    public static final String PENDING_CODE = "PENDING";

    String getStatus();
    String getCode();
    String getReason();
}
