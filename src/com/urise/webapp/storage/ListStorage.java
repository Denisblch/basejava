package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> resumeList = new ArrayList<>();

    @Override
    void doUpdate(Resume resume, Object searchKey) {
        resumeList.set((Integer) searchKey, resume);
    }

    @Override
    void doSave(Resume resume, Object searchKey) {
        resumeList.add(resume);
    }

    @Override
    void doDelete(Object searchKey) {
        resumeList.remove(((Integer) searchKey).intValue());
    }

    @Override
    Resume doGet(Object searchKey) {
        return resumeList.get((Integer) searchKey);
    }

    @Override
    Object getSearchKey(String uuid) {
        for (int i = 0; i < resumeList.size(); i++) {
            if (resumeList.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    public void clear() {
        resumeList.clear();
    }

    @Override
    public List<Resume> doGetAll() {
        return new ArrayList<>(resumeList);
    }

    @Override
    public int size() {
        return resumeList.size();
    }
}
