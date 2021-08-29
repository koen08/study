package com.koen.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericResponse<T> {
    private long errorId;
    private String errorMessage;
    T responseData;

    public GenericResponse(T responseData) {
        errorId = 0;
        this.responseData = responseData;
    }

    public GenericResponse(long errorId, String errorMessage) {
        this.errorMessage = errorMessage;
        this.errorId = errorId;
    }
}
