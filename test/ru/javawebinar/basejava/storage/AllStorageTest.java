package ru.javawebinar.basejava.storage;


import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        ArrayStorageTest.class,
        SortedArrayStorageTest.class,
        MapUuidStorageTest.class,
        ListStorageTest.class,
        MapResumeStorageTest.class,
        AbstractArrayStorageTest.class,
        ObjectFileStorageTest.class,
        ObjectPathStorageTest.class
})
public class AllStorageTest {
}