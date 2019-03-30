package com.example.listviewor;

public class Person {
    private String p_nameSurname;
    private String p_eMail;
    private String p_adress;
    private long p_id;

    public Person() {
    }

    public Person(String name, String email, String adress) {
        this.p_nameSurname = name;
        this.p_eMail = email;
        this.p_adress = adress;
    }

    public String getP_nameSurname() {
        return p_nameSurname;
    }

    public void setP_nameSurname(String p_nameSurname) {
        this.p_nameSurname = p_nameSurname;
    }

    public String getP_eMail() {
        return p_eMail;
    }

    public void setP_eMail(String p_eMail) {
        this.p_eMail = p_eMail;
    }

    public String getP_adress() {
        return p_adress;
    }

    public void setP_adress(String p_adress) {
        this.p_adress = p_adress;
    }

    public long getP_id() {
        return p_id;
    }

    public void setP_id(long p_id) {
        this.p_id = p_id;
    }
}
