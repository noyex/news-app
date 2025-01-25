package com.noyex.translator_app.client;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;

public class TranslationClient {
    private final Translate translate;

    public TranslationClient(String apiKey) {
        this.translate = TranslateOptions.newBuilder()
                .setApiKey(apiKey)
                .build()
                .getService();
    }

    public Translate getTranslate() {
        return translate;
    }
}