package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    void doUpdate(Resume resume, Object uuid) {
        map.put((String) uuid, resume);
    }

    @Override
    void doSave(Resume resume, Object uuid) {
        map.put((String) uuid, resume);
    }

    @Override
    void doDelete(Object uuid) {
        map.remove(uuid);
    }

    @Override
    Resume doGet(Object uuid) {
        return map.get(uuid);
    }

    @Override
    Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    boolean isExist(Object uuid) {
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
