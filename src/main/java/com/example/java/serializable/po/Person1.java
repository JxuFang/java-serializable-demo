package com.example.java.serializable.po;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Fang Jinxu
 * @Description:
 * @Date: 2024-09-18 19:38
 */
@Data
public class Person1 implements Serializable {
    private String name;
    private int age;
}