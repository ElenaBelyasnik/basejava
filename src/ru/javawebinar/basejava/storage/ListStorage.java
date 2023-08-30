package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private final List<Resume> resumeList = new ArrayList<>();

    @Override
    protected Integer getKey(String uuid) {
        for (int i = 0; i < resumeList.size(); i++) {
            if (resumeList.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected boolean isExistKey(Object key) {
        return key != null;
    }

    @Override
    protected void doUpdate(Resume r, Object key) {
        resumeList.set((Integer) key, r);
    }

    @Override
    protected void doSave(Resume r, Object key) {
        resumeList.add(r);
    }

    @Override
    protected void doDelete(Object key) {
        resumeList.remove(((Integer) key).intValue());
    }

    @Override
    protected Resume doGet(Object key) {
        return resumeList.get((Integer) key);
    }

    @Override
    public void doClear() {
        resumeList.clear();
    }

    @Override
    public Resume[] doGetAll() {
        Resume[] resumes = new Resume[resumeList.size()];
        return resumeList.toArray(resumes);
    }

    @Override
    public int doSize() {
        return resumeList.size();
    }
}
