package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage<SK> implements Storage {
    protected final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);

    protected abstract SK getSearchKey(String uuid);

    protected abstract void doClear();

    protected abstract boolean isExistSearchKey(SK key);

    protected abstract void doUpdate(Resume r, SK key);

    protected abstract void doSave(Resume r, SK key);

    protected abstract void doDelete(SK key);

    protected abstract Resume doGet(SK key);

    protected abstract List<Resume> doGetAll();

    protected abstract int doSize();

    public void clear() {
        doClear();
    }

    public void update(Resume r) {
        SK searchKey = getExistedSearchKey(r.getUuid());
        doUpdate(r, searchKey);
    }

    public void save(Resume r) {
        SK searchKey = getNotExistedSearchKey(r.getUuid());
        doSave(r, searchKey);
    }

    public void delete(String uuid) {
        SK key = getExistedSearchKey(uuid);
        doDelete(key);
    }

    public Resume get(String uuid) {
        SK key = getExistedSearchKey(uuid);
        return doGet(key);
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> resumeList = doGetAll();
        resumeList.sort(RESUME_COMPARATOR);
        return resumeList;
    }

    public int size() {
        return doSize();
    }

    private SK getExistedSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExistSearchKey(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private SK getNotExistedSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExistSearchKey(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }
}
