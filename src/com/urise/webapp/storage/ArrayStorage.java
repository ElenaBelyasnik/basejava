package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        String uuid = resume.getUuid();
        int index = findUuid(uuid);
        if (index >= 0) {
            storage[index] = resume;
        } else {
            System.out.println("ERROR: there is no resume with uuid = " + uuid);
        }
    }

    public void save(Resume r) {
        if (size + 1 < storage.length) {
            String uuid = r.getUuid();
            int index = findUuid(uuid);
            if (index == -1) {
                storage[size] = r;
                size++;

            } else {
                System.out.println("ERROR: already have a resume with uuid = " + uuid);
            }
        } else {
            System.out.println("ERROR: array size out of bounds");
        }
    }

    public Resume get(String uuid) {
        int index = findUuid(uuid);
        if (index >= 0) {
            return storage[index];
        } else {
            System.out.println("ERROR: there is no resume with uuid = " + uuid);
        }
        return null;
    }

    public void delete(String uuid) {
        int index = findUuid(uuid);
        if (index >= 0) {
            size--;
            storage[index] = storage[size];
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

    private int findUuid(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
