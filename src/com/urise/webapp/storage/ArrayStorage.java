package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage {
    private Resume[] storage = new Resume[1000];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        if (check(resume.getUuid()) != -1) {
            storage[check(resume.getUuid())] = resume;
            System.out.println("Resume updated successfully");
        } else {
            System.out.println("Error, resume not found");
        }
    }

    public void save(Resume resume) {
        if (check(resume.getUuid()) != -1) {
            System.out.println("Resume already added");
        } else {
            if (size == storage.length) {
                System.out.println("Storage resume is full");

            } else {
                storage[size] = resume;
                size++;
                System.out.println("Resume " + resume.getUuid() + " added to storage");
            }
        }
    }

    public Resume get(String uuid) {
        if (check(uuid) != -1) {
            System.out.println("Resume is found");
            return storage[check(uuid)];
        }
        return null;
    }

    public void delete(String uuid) {
        if (check(uuid) != -1) {
            storage[check(uuid)] = storage[size - 1];
            storage[size - 1] = null;
            size--;
            System.out.println("Resume " + uuid + " deleted");
            return;
        }
        System.out.println("Resume is not found");
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int check(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}

