package com.peculiar.app.auth;

//Model of the User credentials
public class UserModel {
    private String fname;
    private String mName;
    private String lName;
    private String contact;
    private String userName;
    private String password;
    public UserModel(int id, String fName, String mName, String lName, String contact, String usrName, String pswrd) {
        this.fname = fName;
        this.mName = mName;
        this.lName = lName;
        this.contact = contact;
        this.userName = usrName;
        this.password = pswrd;
    }
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getmName() {
        return mName;
    }
    public void setmName(String mName) {
        this.mName = mName;
    }
    public String getlName() {
        return lName;
    }
    public void setlName(String lName) {
        this.lName = lName;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
