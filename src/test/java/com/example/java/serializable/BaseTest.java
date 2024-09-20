package com.example.java.serializable;

import com.example.java.serializable.constant.DeserializationTypeEnum;
import com.example.java.serializable.constant.SerializationTypeEnum;
import com.example.java.serializable.deserialization.DeserializationContext;
import com.example.java.serializable.deserialization.DeserializationStrategy;
import com.example.java.serializable.po.One;
import com.example.java.serializable.po.Person;
import com.example.java.serializable.serialization.SerializationContext;
import com.example.java.serializable.serialization.SerializationStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InvalidClassException;
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
        Person person = new Person();
        person.setAge(10);
        person.setName("test");
        byte[] serializedPerson = serializationStrategy.serialize(person);
        Files.write(Paths.get("src/test/resources/person.txt"), serializedPerson);
    }

    @Test
    void testDiffSerialVersion_InvalidClass() throws IOException {
        // test after modifying serialVersionUID of Person class
        byte[] personBytes = Files.readAllBytes(Paths.get("src/test/resources/person.txt"));
        Assertions.assertThrows(InvalidClassException.class, () -> deserializationStrategy.deserialize(personBytes));
    }

    @Test
    void testIncreaseField() throws IOException, ClassNotFoundException {
        // test after increasing a field of Person class
        byte[] personBytes = Files.readAllBytes(Paths.get("src/test/resources/person.txt"));
        Person deserializedPerson = (Person) deserializationStrategy.deserialize(personBytes);
//        Assertions.assertEquals(new Person("test", 10, 0.0f), deserializedPerson);
    }

    @Test
    void testOne() throws IOException {
        One one = new One();
        one.setName("test");
        byte[] serializedOne = serializationStrategy.serialize(one);
        Files.write(Paths.get("src/test/resources/one.txt"), serializedOne);
    }

    @Test
    void testDiffSerialVersion_One_InvalidClass() throws IOException {
        // test after modifying serialVersionUID of One class
        byte[] oneBytes = Files.readAllBytes(Paths.get("src/test/resources/one.txt"));
        // nothing was thrown, the reason is that serialVersionUID wasn't changed. so serialVersionUID I defined is invalid
        Assertions.assertThrows(InvalidClassException.class, () -> deserializationStrategy.deserialize(oneBytes));
    }

}