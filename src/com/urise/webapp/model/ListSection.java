package com.urise.webapp.model;

import java.util.List;
import java.util.Objects;

public class ListSection extends AbstractSection {
    private final List<String> items;

    public ListSection(List<String> items) {
        Objects.requireNonNull(items, "items must not be null");
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }
}
