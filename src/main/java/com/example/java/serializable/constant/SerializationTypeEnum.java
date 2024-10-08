package com.example.java.serializable.constant;


import lombok.Getter;

@Getter
public enum SerializationTypeEnum {
    JAVA(0),

    KRYO(1)
    ;

    private final int type;

    SerializationTypeEnum(int type) {
        this.type = type;
    }
}
