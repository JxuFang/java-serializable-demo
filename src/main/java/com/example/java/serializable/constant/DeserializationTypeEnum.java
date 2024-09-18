package com.example.java.serializable.constant;

import lombok.Getter;

@Getter
public enum DeserializationTypeEnum {
    JAVA(0),

    PROTO_BUFFER(1)
    ;

    private final int type;

    DeserializationTypeEnum(int type) {
        this.type = type;
    }
}
