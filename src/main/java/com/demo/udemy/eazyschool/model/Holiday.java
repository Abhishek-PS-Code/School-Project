package com.demo.udemy.eazyschool.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Type;
@Data
public class Holiday {

    private final String day;
    private final String reason;
    private final Type type;

    public enum Type{
        FESTIVAL, FEDERAL
    }
}
