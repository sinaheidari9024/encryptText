package com.example.example.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class Text {
    public Text(String text) {
        this.text = text;
    }

    private String text;
    private UUID id;
}
