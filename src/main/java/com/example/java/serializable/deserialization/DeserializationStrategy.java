package com.example.java.serializable.deserialization;

import java.io.IOException;

public interface DeserializationStrategy {

    Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException;
}
