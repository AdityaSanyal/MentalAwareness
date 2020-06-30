package com.example.mentalawareness;

public class UserModel {
    private int ID;
    private String Name;
    private String Email;
    private String Age;
    private String Phone;
    private String Password;
    private String Gender;

    public UserModel() {
    }

    public UserModel(int ID, String name, String email, String age, String password, String gender, String phone) {
        this.ID = ID;
        Name = name;
        Email = email;
        Age = age;
        Password = password;
        Gender = gender;
        Phone = phone;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Age='" + Age + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Password='" + Password + '\'' +
                ", Gender='" + Gender + '\'' +
                '}';
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}
