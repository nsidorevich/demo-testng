package com.zebrunner;

import java.io.File;

public class FileUtils {

    public static final File[] IMAGES = new File[]{
            new File(FileUtils.class.getClassLoader().getResource("pics/capture.png").getFile()),
            new File(FileUtils.class.getClassLoader().getResource("pics/random.png").getFile()),
    };

    private FileUtils() {
    }

}
