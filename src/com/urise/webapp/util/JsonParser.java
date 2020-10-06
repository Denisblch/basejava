package com.urise.webapp.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.urise.webapp.model.AbstractSection;

import java.io.Reader;
import java.io.Writer;

public class JsonParser {

    private static Gson GSON = new GsonBuilder().registerTypeAdapter(AbstractSection.class,
            new JsonSectionAdapter()).create();

    public static <T> T read(Reader reader, Class<T> cls) {
        return GSON.fromJson(reader, cls);
    }

    public static <T> void write(T obj, Writer writer) {
        GSON.toJson(obj, writer);
    }

    public static <T> T read(String content, Class<T> cls) {
        return GSON.fromJson(content, cls);
    }

    public static <T> String write(T obj) {
        return GSON.toJson(obj);
    }

    public static <T> String write(T obj, Class<T> cls) {
        return GSON.toJson(obj, cls);
    }
}
