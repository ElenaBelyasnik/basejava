package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {
    protected abstract Object getKey(String uuid);

    protected abstract boolean isExistKey(Object key);

    protected abstract void nativeUpdate(Resume r, Object key);

    protected abstract void nativeSave(Resume r, Object key);

    protected abstract void nativeDelete(Object key);

    protected abstract Resume nativeGet(Object key);

    public void update(Resume r) {
        Object key = getExistKey(r.getUuid());
        nativeUpdate(r, key);
    }

    public void save(Resume r) {
        Object key = getKey(r.getUuid());
        if (isExistKey(key)) {
            throw new ExistStorageException(r.getUuid());
        }
        nativeSave(r, key);
    }

    public void delete(String uuid) {
        Object key = getExistKey(uuid);
        nativeDelete(key);
    }

    public Resume get(String uuid) {
        Object key = getExistKey(uuid);
        return nativeGet(key);
    }

    private Object getExistKey(String uuid) {
        Object key = getKey(uuid);
        if (!isExistKey(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }
}
