package com.example.java.serializable;

import com.example.java.serializable.constant.DeserializationTypeEnum;
import com.example.java.serializable.constant.SerializationTypeEnum;
import com.example.java.serializable.deserialization.DeserializationContext;
import com.example.java.serializable.deserialization.DeserializationStrategy;
import com.example.java.serializable.po.Employee;
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
        Assertions.assertThrows(InvalidClassException.class, () -> deserializationStrategy.deserialize(personBytes, Person.class));
    }

    @Test
    void testIncreaseField() throws IOException, ClassNotFoundException {
        // test after increasing a field of Person class
        byte[] personBytes = Files.readAllBytes(Paths.get("src/test/resources/person.txt"));
        Person deserializedPerson = deserializationStrategy.deserialize(personBytes, Person.class);
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
        Assertions.assertThrows(InvalidClassException.class, () -> deserializationStrategy.deserialize(oneBytes, One.class));
    }

    @Test
    void testTransient() throws IOException, ClassNotFoundException {
        Employee employee = new Employee();
        employee.setName("tom");
        employee.setId("001");
        employee.setIncome(10000.0f);
        byte[] serializedEmployee = serializationStrategy.serialize(employee);

        Employee expected = new Employee();
        expected.setName("tom");
        expected.setId("001");
        Assertions.assertEquals(expected, deserializationStrategy.deserialize(serializedEmployee, Employee.class));
    }

}