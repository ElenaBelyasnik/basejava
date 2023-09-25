package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage {
    Map<String, Resume> map = new HashMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doClear() {
        map.clear();
    }

    @Override
    protected boolean isExistSearchKey(Object uuid) {
        return map.containsKey((String) uuid);
    }

    @Override
    protected void doUpdate(Resume r, Object key) {
        map.replace((String) key, r);
    }

    @Override
    protected void doSave(Resume r, Object uuid) {
        map.put((String) uuid, r);
    }

    @Override
    protected void doDelete(Object uuid) {
        map.remove((String) uuid);
    }

    @Override
    protected Resume doGet(Object uuid) {
        return map.get((String) uuid);
    }

/*
    @Override
    protected Resume[] doGetAll() {
        Map<String, Resume> treeMap = new TreeMap<>(resumeMap);
        Resume[] resumes = new Resume[treeMap.size()];
        return treeMap.values().toArray(resumes);
    }
*/

    @Override
    protected List<Resume> doGetAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    protected int doSize() {
        return map.size();
    }
}
