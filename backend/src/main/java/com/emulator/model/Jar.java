package com.emulator.model;

public class Jar {
    private String id;
    private String name;
    private String path;
    private String size;
    private String icon;
    private String version;
    private String publisher;
    private String mainClass;

    public Jar() {
    }

    public Jar(String id, String name, String path, String size, String icon, String version, String publisher, String mainClass) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.size = size;
        this.icon = icon;
        this.version = version;
        this.publisher = publisher;
        this.mainClass = mainClass;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public String getSize() {
        return this.size;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getVersion() {
        return this.version;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public String getMainClass() {
        return this.mainClass;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setMainClass(String mainClass) {
        this.mainClass = mainClass;
    }

    public String toString() {
        return "Jar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", size='" + size + '\'' +
                ", icon='" + icon + '\'' +
                ", version='" + version + '\'' +
                ", publisher='" + publisher + '\'' +
                ", mainClass='" + mainClass + '\'' +
                '}';
    }

    public String toJson() {
        return "{" +
                "\"id\":" + id +
                ", \"name\":\"" + name + '\"' +
                ", \"path\":\"" + path + '\"' +
                ", \"size\":\"" + size + '\"' +
                ", \"icon\":\"" + icon + '\"' +
                ", \"version\":\"" + version + '\"' +
                ", \"publisher\":\"" + publisher + '\"' +
                ", \"mainClass\":\"" + mainClass + '\"' +
                '}';
    }

}
