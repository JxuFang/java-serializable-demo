package com.example.java.serializable.deserialization;

import java.io.IOException;

public interface DeserializationStrategy {

    <T> T deserialize(byte[] bytes, Class<T> clazz) throws IOException, ClassNotFoundException;
}
