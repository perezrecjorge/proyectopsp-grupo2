package model.VO;

import java.io.Serializable;

public class Administrator implements Serializable {

    static final long serialVersionUID = 42L;

    private String name;
    private String apell;
    private String mail;
    private String phone;
    private String username;
    private String password;
    private String role;


    public Administrator(String name, String apell, String mail, String phone, String username, String password, String role) {
        this.name = name;
        this.apell = apell;
        this.mail = mail;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setApell(String apell) {
        this.apell = apell;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getApell() {
        return apell;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
