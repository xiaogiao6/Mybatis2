package com.domain;

public class AccountUser extends Account {
    private String address;
    private String username;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return  super.toString()+"AccountUser{" +
                "address='" + address + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
