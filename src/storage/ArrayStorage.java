package storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        for(int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void update(Resume r) {
    }

    public void save(Resume r) {
        for(int i = 0; i < size; i++) {
            if(storage[i].getUuid().equals(r.getUuid())) {
                storage[size] = r;
                size++;
            }
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        int index = 0;
        for(int i = 0; i < size; i++) {
            if(storage[i].getUuid().equals(uuid)) {
                index = i;
                break;
            }
        }
        for(int i = index; i < size; i++) {
            if (i == size - 1) {
                storage[i] = null;
                size--;
            } else {
                storage[i] = storage[i+1];
            }
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}
