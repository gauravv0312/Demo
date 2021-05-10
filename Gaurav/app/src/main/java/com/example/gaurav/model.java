package com.example.gaurav;

public class model {
    String Fname,Email,MobileNo;

    public model() {
    }

    public model(String fname, String email, String mobileNo) {
        this.Fname = fname;
        this.Email = email;
        this.MobileNo = mobileNo;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }
}


