import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    void clear() {
        for(int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            }
            else {
                break;
            }
        }
        size = 0;
    }

    void save(Resume r) {
        for(int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                size++;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for(Resume i: storage) {
            if (i != null && i.uuid.equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    void delete(String uuid) {
        int count = 0;
        for(int i = 0; i < storage.length; i++) {
            if(storage[i] != null && storage[i].uuid.equals(uuid)) {
                count = i;
                break;
            }
        }
        for(int i = count; i < storage.length; i++) {
            if (i == storage.length-1) {
                storage[i] = null;
                size--;
            } else {
                storage[i] = storage[i+1];
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}
