package com.example.java.serializable.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class One implements Serializable {

    // not declared 'private static final long'
    private static long serialVersionUID = 2L;

    private String name;
}
