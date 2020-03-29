package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage extends AbstractArrayStorage {

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = check(resume.getUuid());
        if (index != -1) {
            storage[index] = resume;
            System.out.println("Resume " + resume.getUuid() + " updated successfully");
        } else {
            System.out.println("Error, resume " + resume.getUuid() + " not found");
        }
    }

    public void save(Resume resume) {
        if (check(resume.getUuid()) != -1) {
            System.out.println("Resume " + resume.getUuid() + " already added");
        } else if (size == storage.length) {
            System.out.println("Storage resume is full");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    public void delete(String uuid) {
        if (check(uuid) != -1) {
            storage[check(uuid)] = storage[size - 1];
            storage[size - 1] = null;
            size--;
            System.out.println("Resume " + uuid + " deleted");
            return;
        }
        System.out.println("Resume " + uuid + " is not found");
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected int check(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}

