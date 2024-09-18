package com.example.java.serializable.deserialization;

import com.example.java.serializable.constant.DeserializationTypeEnum;
import com.example.java.serializable.deserialization.java.JavaDeserialize;

import java.util.HashMap;
import java.util.Map;

public class DeserializationContext {

    private final Map<DeserializationTypeEnum, DeserializationStrategy> strategyMap;

    {
        strategyMap = new HashMap<>();
        strategyMap.put(DeserializationTypeEnum.JAVA, new JavaDeserialize());
    }

    public DeserializationStrategy getStrategy(DeserializationTypeEnum type) {
        return strategyMap.get(type);
    }

}
