package com.example.spring.repeat.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionConstants {
    UNEXPECTED_EXCEPTION("UNEXPECTED_EXCEPTION", "Unexpected exception occurred"),
    HTTP_METHOD_IS_NOT_CORRECT("HTTP_METHOD_IS_NOT_CORRECT", "Http method is not correct"),
    CITY_NOT_FOUND("CITY_NOT_FOUND", "City is not found"),
    DIVISION_NOT_FOUND("DIVISION_NOT_FOUND", "Division is not found"),
    POLICE_STATION_NOT_FOUND("POLICE_STATION_NOT_FOUND", "Police station not found"),
    REGION_NOT_FOUND("REGION_NOT_FOUND", "Region is not found");

    private final String code;
    private final String message;

    public String getMessage(String id) {
        if ((this == CITY_NOT_FOUND || this == DIVISION_NOT_FOUND
                || this == REGION_NOT_FOUND || this == POLICE_STATION_NOT_FOUND) && id != null) {
            return String.format("%s (ID: %s)", this.message, id);
        }
        return this.message;
    }
}
