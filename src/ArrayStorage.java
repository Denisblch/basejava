import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    void clear() {
        for(int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        for(int i = 0; i < storage.length; i++) {
            storage[i] = r;
            size++;
            break;
        }
    }

    Resume get(String uuid) {
        for(Resume i: storage) {
            if (i.uuid.equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    void delete(String uuid) {
        int index = 0;
        for(int i = 0; i < size; i++) {
            if(storage[i].uuid.equals(uuid)) {
                index = i;
                break;
            }
        }
        for(int i = index; i < size; i++) {
            if (i == size) {
                storage[i] = null;
                size--;
            } else {
                storage[i] = storage[i+1];
            }
        }
    }

    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}
