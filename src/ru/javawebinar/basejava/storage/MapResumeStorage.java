package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume > {
    private final Map<String, Resume> map = new HashMap<>();

    @Override
    protected Resume getSearchKey(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected void doClear() {
        map.clear();
    }

    @Override
    protected boolean isExistSearchKey(Resume resume) {
        return resume != null;
    }

    @Override
    protected void doUpdate(Resume r, Resume key) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected void doSave(Resume r, Resume resume) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected void doDelete(Resume resume) {
        map.remove(resume.getUuid());
    }

    @Override
    protected Resume doGet(Resume resume) {
        return resume;
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
