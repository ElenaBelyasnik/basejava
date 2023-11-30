package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {
    //protected final Logger log = Logger.getLogger(getClass().getName());
    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    protected final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);

    protected abstract SK getSearchKey(String uuid);

    protected abstract void doClear();

    protected abstract boolean isExist(SK key);

    protected abstract void doUpdate(Resume r, SK key);

    protected abstract void doSave(Resume r, SK key);

    protected abstract void doDelete(SK key) throws IOException;

    protected abstract Resume doGet(SK key);

    protected abstract List<Resume> doGetAll();

    protected abstract int doSize();

    public void clear() {
        doClear();
    }

    public void update(Resume r) {
        LOG.info("Update " + r);
        SK searchKey = getExistedSearchKey(r.getUuid());
        doUpdate(r, searchKey);
    }

    public void save(Resume r) {
        LOG.info("Save " + r);
        SK searchKey = getNotExistedSearchKey(r.getUuid());
        doSave(r, searchKey);
    }

    public void delete(String uuid) {
        LOG.info("Delete " + uuid);
        SK key = getExistedSearchKey(uuid);
        try {
            doDelete(key);
        } catch (IOException e) {
            throw new StorageException("AbstractStorage.delete error");
        }
    }

    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        SK key = getExistedSearchKey(uuid);
        return doGet(key);
    }

    @Override
    public List<Resume> getAllSorted() {
        LOG.info("getAllSorted");
        List<Resume> resumeList = doGetAll();
        resumeList.sort(RESUME_COMPARATOR);
        return resumeList;
    }

    public int size() {
        return doSize();
    }

    private SK getExistedSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            LOG.warning("Resume " + uuid + " not exists");
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private SK getNotExistedSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            LOG.warning("Resume " + uuid + " already exists");
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }
}
