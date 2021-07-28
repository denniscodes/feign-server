package com.example.server.server.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExtendedResponse extends SimpleResponse {
    private String title;
    private String text;

    public ExtendedResponse(String title, String text) {
        super(SUCCESS_STATUS, COMPLETE_CODE, "Created.");
        this.title = title;
        this.text = text;
    }
}
