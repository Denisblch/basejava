package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractArrayStorageTest {
    private Storage storage;
    private static final String UUID_1 = "uuid1";
    private Resume resume_1 = new Resume(UUID_1);
    private static final String UUID_2 = "uuid2";
    private Resume resume_2 = new Resume(UUID_2);
    private static final String UUID_3 = "uuid3";
    private Resume resume_3 = new Resume(UUID_3);
    private static final String UUID_4 = "uuid4";
    private Resume resume_4 = new Resume(UUID_4);

    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(resume_1);
        storage.save(resume_2);
        storage.save(resume_3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void update() {
        Resume new_resume = new Resume(UUID_3);
        storage.update(new_resume);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.get("1337");
    }

    @Test
    public void save() {
        storage.save(resume_4);
        assertSize(4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(resume_1);
    }

    @Test(expected = StorageException.class)
    public void saveIsFull() {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException oe) {
            Assert.fail("ERROR: Overflow");
        }
        storage.save(new Resume());
    }

    @Test
    public void delete() {
        storage.delete(UUID_1);
        assertSize(storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete("1337");
    }

    @Test
    public void get() {
        assertGet(resume_1);
        assertGet(resume_2);
        assertGet(resume_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("1337");
    }

    @Test
    public void getAll() {
        Resume[] array = storage.getAll();
        Assert.assertEquals(3, array.length);
        Assert.assertEquals(resume_1, array[0]);
        Assert.assertEquals(resume_2, array[1]);
        Assert.assertEquals(resume_3, array[2]);
    }

    @Test
    public void size() {
        assertSize(3);
    }

    private void assertSize(int size) {
        Assert.assertEquals(size, storage.size());
    }

    private void assertGet(Resume resume) {
        Assert.assertEquals(resume, storage.get(resume.getUuid()));
    }
}