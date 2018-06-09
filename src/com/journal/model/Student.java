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

    public Student(Buider buider) {
        this.firstName = buider.firstName;
        this.lastName = buider.lastName;
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

    public static class Buider {
        private int id;
        private String firstName;
        private String lastName;
        private String age;
        private String address;
        private String email;
        private String phone;
        private String nikGit;

        public Buider setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Buider setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Buider setAge(String age) {
            this.age = age;
            return this;
        }

        public Buider setAddress(String address) {
            this.address = address;
            return this;
        }

        public Buider setEmail(String email) {
            this.email = email;
            return this;
        }

        public Buider setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Buider setNikGit(String nikGit) {
            this.nikGit = nikGit;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
