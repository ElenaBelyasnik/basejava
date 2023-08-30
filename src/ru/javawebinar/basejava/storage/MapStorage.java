package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Map;
import java.util.TreeMap;

public class MapStorage extends AbstractStorage {
    Map<String, Resume> resumeMap = new TreeMap<>();

    @Override
    protected Object getKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doClear() {
        resumeMap.clear();
    }

    @Override
    protected boolean isExistKey(Object key) {
        return resumeMap.containsKey((String) key);
    }

    @Override
    protected void doUpdate(Resume r, Object key) {
        resumeMap.replace((String) key, r);
    }

    @Override
    protected void doSave(Resume r, Object key) {
        resumeMap.put(r.getUuid(), r);
    }

    @Override
    protected void doDelete(Object key) {
        resumeMap.remove((String) key);
    }

    @Override
    protected Resume doGet(Object key) {
        return resumeMap.get((String) key);
    }

    @Override
    protected Resume[] doGetAll() {
        Map<String, Resume> treeMap = new TreeMap<>(resumeMap);
        Resume[] resumes = new Resume[treeMap.size()];
        return treeMap.values().toArray(resumes);
    }

    @Override
    protected int doSize() {
        return resumeMap.size();
    }
}
