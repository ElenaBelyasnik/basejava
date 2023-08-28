package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage  {
    protected static final int STORAGE_LIMIT = 10_000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void nativeUpdate(Resume r, Object key) {
            storage[(Integer) key] = r;
    }

    @Override
    public void nativeSave(Resume r, Object key) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            insertElement(r, (int) key);
            size++;
        }
    }

    @Override
    public Resume nativeGet(Object key) {
        return storage[(Integer) key];
    }

    @Override
    public void nativeDelete(Object key) {
            size--;
            fillDeletedElement((int) key);
            storage[size] = null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }


    public int size() {
        return size;
    }

    @Override
    protected boolean isExistKey(Object key) {
        return (Integer) key >= 0;
    }

    protected abstract Integer getKey(String uuid);
    protected abstract void insertElement(Resume r, int index);
    protected abstract void fillDeletedElement(int index);
}
