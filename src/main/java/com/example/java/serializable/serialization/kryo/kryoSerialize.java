package com.example.java.serializable.serialization.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import com.example.java.serializable.serialization.SerializationStrategy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class kryoSerialize implements SerializationStrategy {

    @Override
    public byte[] serialize(Object obj) throws IOException {
        Kryo kryo = new Kryo();
        kryo.register(obj.getClass());
        try (Output output = new Output(new ByteArrayOutputStream())){
            kryo.writeObject(output, obj);
            return output.toBytes();
        }
    }
}