package com.learning.spring_deep_dive.entity.enums;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape=JsonFormat.Shape.OBJECT)
public enum UserStatus {

    ACTIVE ("A", "ATIVO"),
    INACTIVE ("I", "INATIVO"),
    PENDANT("P", "PENDANT");

    private String code;
    private String description;

    private UserStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonCreator
    public static UserStatus getByCode(String code) {
        return switch (code) {
            case "A" -> ACTIVE;
            case "I" -> INACTIVE;
            case "P" -> PENDANT;
            default -> null;
        };
    }
}
