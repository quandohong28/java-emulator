package com.emulator;

import static spark.Spark.*;

import com.emulator.model.Jar;
import com.emulator.service.JarService;

public class Main {
    public static void main(String[] args) {

        port(4567);

        System.out.println("Server is running on http://localhost:" + 4567);
        JarService jarService = new JarService();
        Jar test = jarService.parserJarFile("src/main/resources/jars/NSO9X_215.jar");

        System.out.println(test.toJson());

    }
}
