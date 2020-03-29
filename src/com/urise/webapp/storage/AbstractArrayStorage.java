package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage{
    private static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public Resume get(String uuid) {
        int index = check(uuid);
        if (index == -1) {
            System.out.println("Resume " + uuid + " is not found");
            return null;
        }
        return storage[index];
    }

    public int size() {
        return size;
    }

    protected abstract int check(String uuid);
}
