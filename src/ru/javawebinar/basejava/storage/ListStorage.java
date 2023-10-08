package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {
    private final List<Resume> list = new ArrayList<>();

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected boolean isExistSearchKey(Integer searchKey) {
        return searchKey != null;
    }

    @Override
    protected void doUpdate(Resume r, Integer searchKey) {
        list.set(searchKey, r);
    }

    @Override
    protected void doSave(Resume r, Integer key) {
        list.add(r);
    }

    @Override
    protected void doDelete(Integer searchKey) {
        list.remove(searchKey.intValue());
    }

    @Override
    protected Resume doGet(Integer searchKey) {
        return list.get(searchKey);
    }

    @Override
    public void doClear() {
        list.clear();
    }

    @Override
    protected List<Resume> doGetAll() {
        return new ArrayList<>(list);
    }

    @Override
    public int doSize() {
        return list.size();
    }
}
