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

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public static class Builder {

        private String firstName;
        private String lastName;
        private String age;
        private String address;
        private String email;
        private String phone;
        private String nikGit;

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setAge(String age) {
            this.age = age;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setNikGit(String nikGit) {
            this.nikGit = nikGit;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
