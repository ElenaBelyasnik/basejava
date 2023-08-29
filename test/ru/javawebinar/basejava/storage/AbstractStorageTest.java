package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.jupiter.api.Assertions.*;

class AbstractStorageTest {
    private final Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final String UUID_DUMMY = "dummy";

    private static final Resume RESUME_1;
    private static final Resume RESUME_2;
    private static final Resume RESUME_3;
    private static final Resume RESUME_4;
    private static final Resume RESUME_DUMMY;

    static {
        RESUME_1 = new Resume(UUID_1);
        RESUME_2 = new Resume(UUID_2);
        RESUME_3 = new Resume(UUID_3);
        RESUME_4 = new Resume(UUID_4);
        RESUME_DUMMY = new Resume(UUID_DUMMY);
    }

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    void update() {
        Resume updatingResume = new Resume(UUID_1);
        storage.update(updatingResume);
        assertSame(updatingResume, storage.get(UUID_1));
    }

    @Test
    public void updateNotExistsException() {
        String exceptionMessage = "Resume " + RESUME_DUMMY.getUuid() + " not exists";
        NotExistStorageException thrown = assertThrows(NotExistStorageException.class, () ->
                storage.update(RESUME_DUMMY));

        assertEquals(exceptionMessage, thrown.getMessage());
    }

    @Test
    void save() {
        storage.save(RESUME_4);
        assertSize(4);
        assertGet(RESUME_4);
    }

    @Test
    public void saveExistException() {
        String exceptionMessage = "Resume " + RESUME_1.getUuid() + " already exists";
        ExistStorageException thrown = assertThrows(ExistStorageException.class,
                () -> storage.save(RESUME_1));

        assertEquals(exceptionMessage, thrown.getMessage());
    }

/*
    @Test
    public void saveOverflow(){
        String exceptionMessage = "Storage overflow";
        storage.clear();
        for (int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
            storage.save(new Resume());
        }
        StorageException thrown = assertThrows(StorageException.class,
                () -> storage.save(new Resume()));

        assertEquals(exceptionMessage, thrown.getMessage());
    }
*/

    @Test
    void delete() {
        storage.delete(UUID_1);
        assertSize(2);
        String exceptionMessage = "Resume " + RESUME_1.getUuid() + " not exists";
        NotExistStorageException thrown = assertThrows(NotExistStorageException.class,
                () -> storage.delete(RESUME_1.getUuid()));

        assertEquals(exceptionMessage, thrown.getMessage());
    }

    @Test
    void deleteNotExistException() {
        String exceptionMessage = "Resume " + RESUME_DUMMY.getUuid() + " not exists";
        NotExistStorageException thrown = assertThrows(NotExistStorageException.class,
                () -> storage.delete(RESUME_DUMMY.getUuid()));

        assertEquals(exceptionMessage, thrown.getMessage());
    }

    @Test
    void get() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test
    void getNotExist() {
        String exceptionMessage = "Resume " + RESUME_DUMMY.getUuid() + " not exists";
        NotExistStorageException thrown = assertThrows(NotExistStorageException.class,
                () -> storage.get(UUID_DUMMY));

        Assertions.assertEquals(exceptionMessage, thrown.getMessage());
    }

    @Test
    void getAll() {
        Resume[] actual = storage.getAll();
        assertEquals(3, actual.length);
        Resume[] expected = new Resume[]{RESUME_1, RESUME_2, RESUME_3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void size() {
        assertSize(3);
    }

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }
}