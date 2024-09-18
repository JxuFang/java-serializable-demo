package com.example.java.serializable.serialization;

import java.io.IOException;

public interface SerializationStrategy {

    byte[] serialize(Object obj) throws IOException;
}
