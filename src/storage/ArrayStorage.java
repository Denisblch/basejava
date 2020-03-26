package storage;
import com.urise.webapp.model.Resume;
import java.util.Arrays;

public class ArrayStorage {
    private Resume[] storage = new Resume[1000];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size,null);
        size = 0;
    }

    public void update(Resume r) {
        if(check(r)){
            System.out.println("Storage of resume changed successfully");
        }
        else {
            System.out.println("Error, resume not found");
        }
    }

    public void save(Resume r) {
        if(!check(r) && size < storage.length) {
            storage[size] = r;
            size++;
            System.out.println("Resume " + r.getUuid() + " added to storage");
        }
        else{
            System.out.println("Storage resume is full");
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
        for(int i = 0; i < size; i++) {
            if(storage[i].getUuid().equals(uuid)) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                System.out.println("Resume deleted");
            }
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private boolean check(Resume r){
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(r)) {
                storage[i] = r;
                return true;
            }
        }
        return false;
    }
}
