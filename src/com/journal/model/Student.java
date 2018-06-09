package com.journal.model;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String age;
    private String address;
    private String email;
    private String phone;
    private String nikGit;

    public Student(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getNikGit() {
        return nikGit;
    }

    public static class Builder {
        private int id;
        private String firstName;
        private String lastName;
        private String age;
        private String address;
        private String email;
        private String phone;
        private String nikGit;



        public Student build() {
            return new Student(this);
        }
    }
}
