package com.urise.webapp.model;

import java.util.Objects;

public class TextSection extends AbstractSection {
    private final String content;

    public TextSection(String content) {
        Objects.requireNonNull(content, "content must not be null");
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
