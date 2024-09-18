package com.example.java.serializable.deserialization.java;

import com.example.java.serializable.deserialization.DeserializationStrategy;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class JavaDeserialize implements DeserializationStrategy {

    @Override
    public Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes))) {
            return ois.readObject();
        }
    }
}
