package com.example.demo.logging;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class TestLogger {

    public static void log(String message) {

        try {

            FileWriter writer = new FileWriter("logs/test-execution.log", true);

            writer.write(LocalDateTime.now() + " : " + message + "\n");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}