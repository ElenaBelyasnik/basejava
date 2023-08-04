package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public final void update(Resume resume) {
        String uuid = resume.getUuid();
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("ERROR: there is no resume with uuid = " + uuid);
        } else {
            storage[index] = resume;
        }
    }

    public final void save(Resume r) {
        String uuid = r.getUuid();
        int index = getIndex(uuid);
        if (index >= 0) {
            System.out.println("ERROR: resume with uuid = " + r.getUuid() + " already exists");
        } else if (size == STORAGE_LIMIT) {
            System.out.println("ERROR: storage overflow");
        } else {
            insertElement(r, index);
            size++;
        }
    }

    public final Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    public final void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("ERROR: there is no resume with uuid = " + uuid);
        } else {
            size--;
            fillDeletedElement(index);
            storage[size] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }


    public int size() {
        return size;
    }


    protected abstract int getIndex(String uuid);
    protected abstract void insertElement(Resume r, int index);
    protected abstract void fillDeletedElement(int index);
}
