package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.javawebinar.basejava.Config;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.*;
import ru.javawebinar.basejava.ResumeTestData;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractStorageTest {
    //protected static final File STORAGE_DIR = new File("..\\basejava\\storage");
    //    protected static final File STORAGE_DIR = new File("C:\\ELENA\\basejava\\storage");
    protected static final File STORAGE_DIR = Config.get().getStorageDir();

    protected Storage storage;

    private static final String UUID_1 = UUID.randomUUID().toString();
    private static final String UUID_2 = UUID.randomUUID().toString();
    private static final String UUID_3 = UUID.randomUUID().toString();
    private static final String UUID_4 = UUID.randomUUID().toString();
    private static final String UUID_DUMMY = UUID.randomUUID().toString();

    private static final Resume RESUME_1;
    private static final Resume RESUME_2;
    private static final Resume RESUME_3;
    private static final Resume RESUME_4;
    private static final Resume RESUME_DUMMY;

    static {
        RESUME_1 = ResumeTestData.addResumeTestData(UUID_1, "Name1");
        RESUME_2 = ResumeTestData.addResumeTestData(UUID_2, "Name2");
        RESUME_3 = ResumeTestData.addResumeTestData(UUID_3, "Name3");
        RESUME_4 = ResumeTestData.addResumeTestData(UUID_4, "Name4");
        RESUME_DUMMY = ResumeTestData.addResumeTestData(UUID_DUMMY, "dummy");
    }

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    void setUp() throws IOException {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    void clear() throws IOException {
        storage.clear();
        assertSize(0);
    }

    @Test
    void update() {
        //Resume updatingResume = new Resume(UUID_1, "New Name");
        Resume updatingResume = ResumeTestData.addResumeTestData(UUID_1, "New Name");
        RESUME_1.setContact(ContactType.MAIL, "mail1@google.com");
        RESUME_1.setContact(ContactType.SKYPE, "NewSkype");
        RESUME_1.setContact(ContactType.MOBILE, "+7 921 222-22-22");

        storage.update(updatingResume);
        //assertSame(updatingResume, storage.get(UUID_1));
        assertEquals(updatingResume, storage.get(UUID_1));
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

    @Test
    void delete() throws IOException {
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
        Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);

        List<Resume> actual = storage.getAllSorted();
        actual.sort(RESUME_COMPARATOR);
        assertEquals(3, actual.size());
        List<Resume> expected = new ArrayList<>(Arrays.stream(new Resume[]{RESUME_1, RESUME_2, RESUME_3}).toList());
        expected.sort(RESUME_COMPARATOR);
        Assertions.assertArrayEquals(actual.toArray(), expected.toArray());

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