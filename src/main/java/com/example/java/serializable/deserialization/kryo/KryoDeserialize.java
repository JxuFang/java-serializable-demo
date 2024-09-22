package com.example.java.serializable.deserialization.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.example.java.serializable.deserialization.DeserializationStrategy;

import java.io.IOException;

public class KryoDeserialize implements DeserializationStrategy {

    private final ThreadLocal<Kryo> kryoThreadLocal = ThreadLocal.withInitial(() -> new Kryo());

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> clazz) throws IOException, ClassNotFoundException {
        Kryo kryo = kryoThreadLocal.get();
        kryo.register(clazz);
        try (Input input = new Input(bytes)) {
            return kryo.readObject(input, clazz);
        }
    }
}