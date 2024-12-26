package com.emulator.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import com.emulator.model.Jar;

public class JarService {
    private static String path = "src/main/resources/jars";

    public JarService() {

    }

    public Jar parserJarFile(String path) {
        // Parse file jar và trả về thông tin của file jar
        Jar jar = new Jar();

        try {
            // Mở tệp JAR
            File jarFile = new File(path);
            if (!jarFile.exists()) {
                System.out.println("Không tìm thấy file " + path);
                return null;
            }

            JarFile jarFileObj = new JarFile(jarFile);

            // Lấy Manifest từ JAR
            Manifest manifest = jarFileObj.getManifest();
            if (manifest != null) {
                // Trích xuất các thuộc tính từ manifest
                String appName = manifest.getMainAttributes().getValue("Implementation-Name");
                String version = manifest.getMainAttributes().getValue("Implementation-Version");
                String publisher = manifest.getMainAttributes().getValue("Implementation-Vendor");
                String iconPath = manifest.getMainAttributes().getValue("MIDlet-1");

                // Nếu có giá trị MIDlet-1, tách thông tin
                if (iconPath != null && iconPath.contains(",")) {
                    String[] midlet1 = iconPath.split(",");
                    if (midlet1.length >= 3) {
                        String icon = midlet1[0];
                        String mainClass = midlet1[2];

                        jar.setIcon(icon != null ? icon : "default-icon.png");
                        jar.setMainClass(mainClass != null ? mainClass : "No main class");
                    }
                }

                // Cập nhật thông tin khác từ Manifest
                jar.setName(appName != null ? appName : "Đang cập nhật");
                jar.setVersion(version != null ? version : "Đang cập nhật");
                jar.setPublisher(publisher != null ? publisher : "Đang cập nhật");
            }

            // Đặt kích thước tệp
            jar.setSize(String.valueOf(jarFile.length()));
            

            jarFileObj.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jar;
    }

    public List<Jar> getAllJars() {
        List<Jar> jars = new ArrayList<>();
        // Lấy ra danh sách file jar từ thư mục resource và thêm file jar vào List
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith(".jar")) {
                    Jar jar = parserJarFile(file.getAbsolutePath());
                    if (jar != null) {
                        jar.setPath(file.getAbsolutePath());
                        jars.add(jar);
                    }
                }
            }
        }

        return jars;
    }
}
