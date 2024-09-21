package com.example.java.serializable.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private static String company = "google";

    private String id;

    private String name;

    private transient float income;
}