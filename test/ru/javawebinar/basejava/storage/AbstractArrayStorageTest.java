package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.jupiter.api.Assertions.*;

class AbstractArrayStorageTest {
    private final Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final String UUID_DUMMY = "dummy";
    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final Resume RESUME_3 = new Resume(UUID_3);
    private static final Resume RESUME_4 = new Resume(UUID_4);
    private static final Resume RESUME_DUMMY = new Resume(UUID_DUMMY);

    protected AbstractArrayStorageTest(Storage storage) {
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
        checkSize(0);
    }


    @Test
    void update() {
        Resume updatingResume = new Resume(UUID_1);
        storage.update(updatingResume);
        assertSame(updatingResume, storage.get(UUID_1));
    }

    @Test
    public void updateResumeNotExistsException() {
        String exceptionMessage = "Resume " + RESUME_DUMMY.getUuid() + " not exists";
        NotExistStorageException thrown = assertThrows(NotExistStorageException.class, () ->
                storage.update(RESUME_DUMMY));

        assertEquals(exceptionMessage, thrown.getMessage());
    }

    @Test
    public void save() {
        storage.save(RESUME_4);
        checkSize(4);
        assertEquals(RESUME_4, storage.get(RESUME_4.getUuid()));
    }

    @Test
    public void saveResumeExistsException(){
        String exceptionMessage = "Resume " + RESUME_1.getUuid() + " already exists";
        ExistStorageException thrown = assertThrows(ExistStorageException.class,
                () -> storage.save(RESUME_1));

        assertEquals(exceptionMessage, thrown.getMessage());
    }

    @Test
    public void saveStorageLimitOverflow(){
        String exceptionMessage = "Storage overflow";
        StorageException thrown = assertThrows(StorageException.class, () -> {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT + 1; i++) {
                storage.save(new Resume());
            }
        });

        assertEquals(exceptionMessage, thrown.getMessage());
    }

    @Test
    void get() {
        assertEquals(RESUME_1, storage.get(UUID_1));
    }

    @Test
    void getNotExist() {
        String exceptionMessage = "Resume " + RESUME_DUMMY.getUuid() + " not exists";
        NotExistStorageException thrown = assertThrows(NotExistStorageException.class,
                () -> storage.get(UUID_DUMMY));

        Assertions.assertEquals(exceptionMessage, thrown.getMessage());
    }

    @Test
    void delete() {
        storage.delete(UUID_1);
        checkSize(2);
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
    void getAll() {
        Resume[] resumes = storage.getAll();
        assertEquals(3, resumes.length);
        assertEquals(RESUME_1, resumes[0]);
        assertEquals(RESUME_2, resumes[1]);
        assertEquals(RESUME_3, resumes[2]);
    }

    @Test
    void size() {
        checkSize(3);
    }

    private void checkSize(int size) {
        assertEquals(size, storage.size());
    }
}