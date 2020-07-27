package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage<String> {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    public void doUpdate(Resume resume, String uuid) {
        map.put(uuid, resume);
    }

    @Override
    public void doSave(Resume resume, String uuid) {
        map.put(uuid, resume);
    }

    @Override
    public void doDelete(String uuid) {
        map.remove(uuid);
    }

    @Override
    public Resume doGet(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    public boolean isExist(String uuid) {
        return map.containsKey(uuid);
    }

    @Override
    public List<Resume> doCopyAll() {
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
