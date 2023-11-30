package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.io.IOException;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public interface Storage {
    void clear() throws IOException;

    void update(Resume r);

    void save(Resume r);

    Resume get(String uuid);

    void delete(String uuid) throws IOException;

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    //Resume[] getAll();
    List<Resume> getAllSorted();

    int size();
}
