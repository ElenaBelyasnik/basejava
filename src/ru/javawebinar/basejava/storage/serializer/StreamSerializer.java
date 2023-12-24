package ru.javawebinar.basejava.storage.serializer;

import ru.javawebinar.basejava.model.Resume;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;

public interface StreamSerializer {
    void doWrite(Resume r, OutputStream os) throws IOException;

    Resume doRead(BufferedInputStream is) throws IOException;
}
