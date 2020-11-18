package com.zebrunner;

import java.io.File;
import java.io.InputStream;

public class FileUtils {

    public static final File[] IMAGES = new File[]{
            new File(FileUtils.class.getClassLoader().getResource("pics/capture.png").getFile()),
            new File(FileUtils.class.getClassLoader().getResource("pics/random.png").getFile()),
    };

    public static final InputStream DOC = FileUtils.class.getClassLoader().getResourceAsStream("docs/doc.docx");

    private FileUtils() {
    }

}
