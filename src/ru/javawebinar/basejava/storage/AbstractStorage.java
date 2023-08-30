package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {
    protected abstract Object getKey(String uuid);

    protected abstract void doClear();

    protected abstract boolean isExistKey(Object key);

    protected abstract void doUpdate(Resume r, Object key);

    protected abstract void doSave(Resume r, Object key);

    protected abstract void doDelete(Object key);

    protected abstract Resume doGet(Object key);

    protected abstract Resume[] doGetAll();

    protected abstract int doSize();

    public void clear() {
        doClear();
    }

    public void update(Resume r) {
        Object key = getExistKey(r.getUuid());
        doUpdate(r, key);
    }

    public void save(Resume r) {
        Object key = getNotExistKey(r.getUuid());
        doSave(r, key);
    }

    public void delete(String uuid) {
        Object key = getExistKey(uuid);
        doDelete(key);
    }

    public Resume get(String uuid) {
        Object key = getExistKey(uuid);
        return doGet(key);
    }

    public Resume[] getAll() {
        return doGetAll();
    }

    public int size() {
        return doSize();
    }

    private Object getExistKey(String uuid) {
        Object key = getKey(uuid);
        if (!isExistKey(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    private Object getNotExistKey(String uuid) {
        Object key = getKey(uuid);
        if (isExistKey(key)) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }
}
