package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);

    @Override
    protected void insertElement(Resume resume, int index) {
        int positionInsert = Math.abs(index + 1);
        System.arraycopy(storage, positionInsert, storage, positionInsert + 1, size - positionInsert);
        storage[positionInsert] = resume;
    }

    @Override
    protected void fillDeletedElement(int index) {
        if (size - 1 - index > 0) {
            System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
        }
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "dummy");
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
    }
}
