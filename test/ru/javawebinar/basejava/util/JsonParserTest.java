package ru.javawebinar.basejava.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.model.Section;
import ru.javawebinar.basejava.model.TextSection;

import static ru.javawebinar.basejava.TestData.R1;

class JsonParserTest {

    @Test
    void testResume() {
        String json = JsonParser.write(R1);
        System.out.println(json);
        Resume resume = JsonParser.read(json, Resume.class);
        Assertions.assertEquals(R1, resume);
    }

    @Test
    void write() {
        Section actualSection = new TextSection("Objective1");
        String json = JsonParser.write(actualSection, Section.class);
        System.out.println(json);
        Section expectedSection = JsonParser.read(json, Section.class);
        Assertions.assertEquals(actualSection, expectedSection);
    }
}