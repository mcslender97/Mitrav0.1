package com.vodnal.mitra;

public class RegisterUser {
    private int id;
    private String name;
    private String email;
    private String password;
    private String mobileNum;
    private String address;
    private String age;

    public RegisterUser(int id, String name, String email, String password, String mobileNum, String address,String age) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.mobileNum = mobileNum;
        this.address = address;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
