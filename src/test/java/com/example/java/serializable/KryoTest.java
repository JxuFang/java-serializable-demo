package com.example.java.serializable;

import com.example.java.serializable.constant.DeserializationTypeEnum;
import com.example.java.serializable.constant.SerializationTypeEnum;
import com.example.java.serializable.deserialization.DeserializationContext;
import com.example.java.serializable.deserialization.DeserializationStrategy;
import com.example.java.serializable.po.kryo.Cat;
import com.example.java.serializable.serialization.SerializationContext;
import com.example.java.serializable.serialization.SerializationStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class KryoTest {


    private static SerializationStrategy serializationStrategy;

    private static DeserializationStrategy deserializationStrategy;

    @BeforeAll
    static void setup() {
        serializationStrategy = new SerializationContext().getStrategy(SerializationTypeEnum.KRYO);
        deserializationStrategy = new DeserializationContext().getStrategy(DeserializationTypeEnum.KRYO);
    }

    @Test
    void test() throws IOException, ClassNotFoundException {
        Cat cat = new Cat();
        cat.setName("kary");
        cat.setAge(2);
        byte[] serializedCat = serializationStrategy.serialize(cat);
        Assertions.assertEquals(cat, deserializationStrategy.deserialize(serializedCat, Cat.class));
    }
}