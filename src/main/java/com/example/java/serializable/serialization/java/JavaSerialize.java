package com.example.java.serializable.serialization.java;

import com.example.java.serializable.serialization.SerializationStrategy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class JavaSerialize implements SerializationStrategy {
    @Override
    public byte[] serialize(Object obj) throws IOException, SecurityException{
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)){
            objectOutputStream.writeObject(obj);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
