package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage<String> {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    void doUpdate(Resume resume, String uuid) {
        map.put(uuid, resume);
    }

    @Override
    void doSave(Resume resume, String uuid) {
        map.put(uuid, resume);
    }

    @Override
    void doDelete(String uuid) {
        map.remove(uuid);
    }

    @Override
    Resume doGet(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    boolean isExist(String uuid) {
        return map.containsKey(uuid);
    }

    @Override
    List<Resume> doCopyAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public int size() {
        return map.size();
    }
}
