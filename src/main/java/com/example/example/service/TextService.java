package com.example.example.service;

import java.util.UUID;

public interface TextService {
    UUID shorteningText(String text);

    Object decrypt(UUID id);
}
