package com.example.java.serializable.serialization;

import com.example.java.serializable.constant.SerializationTypeEnum;
import com.example.java.serializable.serialization.java.JavaSerialize;

import java.util.HashMap;
import java.util.Map;

public class SerializationContext {

    private final Map<SerializationTypeEnum, SerializationStrategy> strategyMap;

    {
        strategyMap = new HashMap<>();
        strategyMap.put(SerializationTypeEnum.JAVA, new JavaSerialize());
    }

    public SerializationStrategy getStrategy(SerializationTypeEnum type) {
        return strategyMap.get(type);
    }

}
