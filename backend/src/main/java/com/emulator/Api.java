package com.emulator;

import static spark.Spark.*;

import java.util.List;

import com.google.gson.Gson;

public class Api {

    public static void api() {
        get("/jars", (req, res) -> {
            res.type("application/json");

            List<Jar> jarFiles = JarService.getAllJars();
            return new Gson().toJson(jarFiles);
        });

        get("/", (req, res) -> {
            res.type("application/json");
            return new Gson().toJson("Hello World");
        });

        // API: Nhập file jar mới
        post("/import", (req, res) -> {
            String path = req.queryParams("path");
            if (path == null || !path.endsWith(".jar")) {
                res.status(400);
                return "File không hợp lệ. Vui lòng chọn file .jar";
            }

            // Thêm file jar vào danh sách
            Map<String, String> jarFile = new HashMap<>();
            jarFile.put("name", path.substring(path.lastIndexOf("/") + 1));
            jarFile.put("path", path);
            jarFiles.add(jarFile);

            res.status(200);
            return "Nhập file jar thành công";
        });

        // API: Xoá file jar
        delete("/jars/:name", (req, res) -> {
            String name = req.params(":name");
            jarFiles.removeIf(jar -> jar.get("name").equals(name));
            res.status(200);
            return "Xoá file jar thành công";
        });
    }

}
