package com.example.example.contoller;

import com.example.example.service.TextService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/text")
public class TextController {

    private final TextService textService;

    public TextController(TextService textService) {
        this.textService = textService;
    }

    @PostMapping("/encrypt")
    public UUID encryptText(@RequestBody String text){
        return textService.shorteningText(text);
    }

    @GetMapping("/decrypt/{id}")
    public Object decryptIf(@PathVariable UUID id){
        return textService.decrypt(id);
    }

}
