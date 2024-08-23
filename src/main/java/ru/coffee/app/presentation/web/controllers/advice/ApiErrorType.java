package ru.coffee.app.presentation.web.controllers.advice;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ApiErrorType {
    @JsonProperty("validation")
    VALIDATION,
    @JsonProperty("business")
    BUSINESS,
    @JsonProperty("system")
    SYSTEM;
    private ApiErrorType(){

    }
}