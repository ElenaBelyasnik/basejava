package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage {
    private final Map<String, Resume> map = new HashMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected void doClear() {
        map.clear();
    }

    @Override
    protected boolean isExistSearchKey(Object resume) {
        return resume != null;
    }

    @Override
    protected void doUpdate(Resume r, Object key) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected void doSave(Resume r, Object resume) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected void doDelete(Object resume) {
        map.remove(((Resume) resume).getUuid());
    }

    @Override
    protected Resume doGet(Object resume) {
        return (Resume) resume;
    }

    @Override
    protected List<Resume> doGetAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    protected int doSize() {
        return map.size();
    }
}
