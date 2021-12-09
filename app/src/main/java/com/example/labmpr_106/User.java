package com.example.labmpr_106;

public class User {
    private String name;
    private String nim;
    private String id;
    public User(){};
    public User(String id, String name, String nim) {
        this.id = id;
        this.name = name;
        this.nim = nim;
    }
    public String getId() {return id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getNim() {return nim;}
    public void setNim(String nim) {this.nim = nim;}

}
