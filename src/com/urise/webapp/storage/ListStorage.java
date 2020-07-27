package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {
    private List<Resume> resumeList = new ArrayList<>();

    @Override
    public void doUpdate(Resume resume, Integer searchKey) {
        resumeList.set(searchKey, resume);
    }

    @Override
    public void doSave(Resume resume, Integer searchKey) {
        resumeList.add(resume);
    }

    @Override
    public void doDelete(Integer searchKey) {
        resumeList.remove((searchKey).intValue());
    }

    @Override
    public Resume doGet(Integer searchKey) {
        return resumeList.get(searchKey);
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < resumeList.size(); i++) {
            if (resumeList.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public boolean isExist(Integer searchKey) {
        return searchKey != null;
    }

    @Override
    public void clear() {
        resumeList.clear();
    }

    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(resumeList);
    }

    @Override
    public int size() {
        return resumeList.size();
    }
}
