package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public abstract class AbstractStorageTest {
    protected Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final Resume resume_1;
    private static final String UUID_2 = "uuid2";
    private static final Resume resume_2;
    private static final String UUID_3 = "uuid3";
    private static final Resume resume_3;
    private static final String UUID_4 = "uuid4";
    private static final Resume resume_4;

    static {
        resume_1 = new Resume(UUID_1, "Name1");
        resume_2 = new Resume(UUID_2, "Name2");
        resume_3 = new Resume(UUID_3, "Name3");
        resume_4 = new Resume(UUID_4, "Name4");
    }

    protected AbstractStorageTest(Storage storage) {
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
        Resume newResume = new Resume(UUID_3, "Update Name");
        storage.update(newResume);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.get(resume_4.getUuid());
    }

    @Test
    public void save() {
        storage.save(resume_4);
        assertSize(4);
        assertGet(resume_4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(resume_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_1);
        assertSize(storage.size());
        assertGet(resume_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(resume_4.getUuid());
    }

    @Test
    public void get() {
        assertGet(resume_1);
        assertGet(resume_2);
        assertGet(resume_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get(resume_4.getUuid());
    }

    @Test
    public void getAllSorted() {
        List<Resume> expectedResumes = Arrays.asList(resume_1, resume_2, resume_3);storage.getAllSorted();
        assertEquals(3, storage.size());
        assertEquals(expectedResumes, storage.getAllSorted());
    }

    @Test
    public void size() {
        assertSize(3);
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }
}