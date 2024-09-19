package com.example.java.serializable;

import com.example.java.serializable.constant.DeserializationTypeEnum;
import com.example.java.serializable.constant.SerializationTypeEnum;
import com.example.java.serializable.deserialization.DeserializationContext;
import com.example.java.serializable.deserialization.DeserializationStrategy;
import com.example.java.serializable.po.Person;
import com.example.java.serializable.serialization.SerializationContext;
import com.example.java.serializable.serialization.SerializationStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Author: Fang Jinxu
 * @Description:
 * @Date: 2024-09-18 20:42
 */
class BaseTest {

    private static SerializationStrategy serializationStrategy;

    private static DeserializationStrategy deserializationStrategy;

    @BeforeAll
    static void setup() {
        serializationStrategy = new SerializationContext().getStrategy(SerializationTypeEnum.JAVA);
        deserializationStrategy = new DeserializationContext().getStrategy(DeserializationTypeEnum.JAVA);
    }

    @Test
    void testGenerateObjectFile() throws IOException {
        Person person = new Person("test", 10);
        byte[] serializedPerson = serializationStrategy.serialize(person);
        Files.write(Paths.get("src/test/resources/person.txt"), serializedPerson);
    }

    @Test
    void testDiffSerialVersion() {

    }
}