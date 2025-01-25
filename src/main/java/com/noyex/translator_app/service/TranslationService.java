package com.noyex.translator_app.service;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translation;
import com.noyex.translator_app.client.TranslationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslationService {
    private final TranslationClient translationClient;

    @Autowired
    public TranslationService(TranslationClient translationClient) {
        this.translationClient = translationClient;
    }

    public String translateText(String text, String targetLanguage) {
        Translation translation = translationClient.getTranslate().translate(
                text,
                Translate.TranslateOption.targetLanguage(targetLanguage)
        );
        return translation.getTranslatedText();
    }
}