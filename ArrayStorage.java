/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for(int i = 0; i < storage.length; i++) {
            if (storage[i] != null) storage[i] = null;
            else break;
        }
    }

    void save(Resume r) {
        for(int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for(Resume i: storage) {
            if (i != null && i.uuid == uuid)
                return i;
        }
        return null;
    }

    void delete(String uuid) {
        int count = 0;
        for(int i = 0; i < storage.length; i++) {
            if(storage[i] != null && storage[i].uuid == uuid) {
                count = i;
                break;
            }
        }
        for(int i = count; i < storage.length-1; i++) {
            storage[i] = storage[i + 1];
            storage[i + 1] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] newstorage = new Resume[size()];
        for(int i = 0; i < newstorage.length; i++) {
            newstorage[i] = storage[i];
        }
        return newstorage;
    }

    int size() {
        int count = 0;
        for(int i = 0; i < storage.length; i++) {
            if (storage[i] != null) count++;
            else break;
        }
        return count;
    }
}
