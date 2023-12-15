package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.storage.serializer.XmlStreamSerializer;

public class XmlPathStorageTest extends AbstractStorageTest {

// https://stackoverflow.com/questions/77143490/jaxb-problem-w-java-11-classnotfoundexception-org-glassfish-jaxb-runtime-v2-c

    public XmlPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new XmlStreamSerializer()));
    }
}
