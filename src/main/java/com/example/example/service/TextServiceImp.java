package com.example.example.service;

import com.example.example.domain.Text;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class TextServiceImp implements TextService {

    public static ArrayList<Text> listOfText = new ArrayList<>();

    public UUID shorteningText(String text) {
        Text newText = new Text(text);
        UUID id = UUID.randomUUID();
        newText.setId(id);
        boolean existed;
        while (true) {
            existed = listOfText.stream().anyMatch(s -> s.getId().equals(id));
            if (!existed) {
                listOfText.add(newText);
                break;
            }
        }
        return id;
    }

    public Object decrypt(UUID id) {
        Text text = listOfText.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);

        if (text != null && text.getText().length() > 4) {
            String firstOfText = text.getText().substring(0, 4);
            if (firstOfText.equals("http")) {
                return new RedirectView(text.getText());
            } else {
                return text.getText();
            }
        }
        return null;
    }
}
