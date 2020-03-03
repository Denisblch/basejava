/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];

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
            if (i != null && i.uuid.equals(uuid))
                return i;
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
        for(int i = count; i < storage.length-1; i++) {
            storage[i] = storage[i + 1];
            storage[i + 1] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] news = new Resume[size()];
        if (news.length >= 0)
            System.arraycopy(storage, 0, news, 0, news.length);
        return news;
    }

    int size() {
        int count = 0;
        for(Resume i :storage) {
            if (i != null) count++;
            else break;
        }
        return count;
    }
}
