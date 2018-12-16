package org.softuni.ruk.util;

import org.softuni.ruk.io.ConsoleIO;

import java.io.*;

public class FileUtilImpl implements FileUtil {

    @Override
    public String readFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath))));

        String line;
        StringBuilder fileContent = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            fileContent.append(line).append(System.lineSeparator());
        }

        return fileContent.toString();
    }
}
