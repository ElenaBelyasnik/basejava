package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private final List<Resume> list = new ArrayList<>();

    @Override
    protected Integer getKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
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
    protected void nativeUpdate(Resume r, Object key) {
        list.set((Integer) key, r);
    }

    @Override
    protected void nativeSave(Resume r, Object key) {
        list.add(r);
    }

    @Override
    protected void nativeDelete(Object key) {
        list.remove(((Integer) key).intValue());
    }

    @Override
    protected Resume nativeGet(Object key) {
        return list.get((Integer) key);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Resume[] getAll() {
        Resume[] resumes = new Resume[list.size()];
        return list.toArray(resumes);
    }

    @Override
    public int size() {
        return list.size();
    }
}
