package com.example.taskbuddy.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FileService {

    private final String filePath = "tasks.txt";

    // File Handling + Exception Handling: Append content to file safely
    public void appendToFile(String content) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(content);
            bw.newLine();
        }
    }

    // File Handling + Exception Handling: Read all lines from file
    public List<String> readFile() throws IOException {
        Path path = Path.of(filePath);
        if (!Files.exists(path)) {
            return new ArrayList<>();
        }
        return Files.readAllLines(path);
    }

    // File Handling + Exception Handling: Clear file contents
    public void clearFile() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("");
        }
    }
}
