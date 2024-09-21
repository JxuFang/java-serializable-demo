package com.example.java.serializable.serialization;

import com.example.java.serializable.constant.SerializationTypeEnum;
import com.example.java.serializable.serialization.java.JavaSerialize;
import com.example.java.serializable.serialization.kryo.kryoSerialize;

import java.util.HashMap;
import java.util.Map;

public class SerializationContext {

    private final Map<SerializationTypeEnum, SerializationStrategy> strategyMap;

    {
        strategyMap = new HashMap<>();
        strategyMap.put(SerializationTypeEnum.JAVA, new JavaSerialize());
        strategyMap.put(SerializationTypeEnum.KRYO, new kryoSerialize());
    }

    public SerializationStrategy getStrategy(SerializationTypeEnum type) {
        return strategyMap.get(type);
    }

}
