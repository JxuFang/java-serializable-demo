package com.example.java.serializable;

import com.example.java.serializable.constant.DeserializationTypeEnum;
import com.example.java.serializable.constant.SerializationTypeEnum;
import com.example.java.serializable.deserialization.DeserializationContext;
import com.example.java.serializable.deserialization.DeserializationStrategy;
import com.example.java.serializable.po.Person;
import com.example.java.serializable.po.Person1;
import com.example.java.serializable.serialization.SerializationContext;
import com.example.java.serializable.serialization.SerializationStrategy;


public class Main {

    public static void main(String[] args) {
        SerializationContext serializationContext = new SerializationContext();
        DeserializationContext deserializationContext = new DeserializationContext();
        test(serializationContext.getStrategy(SerializationTypeEnum.JAVA), deserializationContext.getStrategy(DeserializationTypeEnum.JAVA));
    }

    private static void test(SerializationStrategy serializationStrategy, DeserializationStrategy deserializationStrategy) {
        Person person = new Person("test", 10);
        try {
            byte[] serializedPerson = serializationStrategy.serialize(person);
            Person deserializedPerson = (Person) deserializationStrategy.deserialize(serializedPerson);
            System.out.println(deserializedPerson);
        } catch (Exception e) {
            System.out.println("failed");
            e.printStackTrace();
        }
    }

}
