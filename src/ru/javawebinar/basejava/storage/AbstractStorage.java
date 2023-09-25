package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage implements Storage {
    protected abstract Object getSearchKey(String uuid);

    protected abstract void doClear();

    protected abstract boolean isExistSearchKey(Object key);

    protected abstract void doUpdate(Resume r, Object key);

    protected abstract void doSave(Resume r, Object key);

    protected abstract void doDelete(Object key);

    protected abstract Resume doGet(Object key);

    //protected abstract Resume[] doGetAll();
    protected abstract List<Resume> doGetAll();

    protected abstract int doSize();

    public void clear() {
        doClear();
    }

    public void update(Resume r) {
        Object searchKey = getExistedSearchKey(r.getUuid());
        doUpdate(r, searchKey);
    }

    public void save(Resume r) {
        Object searchKey = getNotExistedSearchKey(r.getUuid());
        doSave(r, searchKey);
    }

    public void delete(String uuid) {
        Object key = getExistedSearchKey(uuid);
        doDelete(key);
    }

    public Resume get(String uuid) {
        Object key = getExistedSearchKey(uuid);
        return doGet(key);
    }

/*    public Resume[] getAll() {
        return doGetAll();
    }*/

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> resumeList = doGetAll();
        Collections.sort(resumeList);
        return resumeList;
    }

    public int size() {
        return doSize();
    }

    private Object getExistedSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExistSearchKey(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getNotExistedSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExistSearchKey(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }
}
