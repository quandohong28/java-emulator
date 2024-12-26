package com.emulator.controller;

import com.emulator.model.Jar;
import com.emulator.service.JarService;
import java.util.List;

import javax.swing.text.View;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Spark;

public class JarController {

    public String getAllJars(Request req, Response res) {
        res.type("application/json");
        List<Jar> jars = JarService.getAllJars();
        return new Gson().toJson(jars);
    }
}
