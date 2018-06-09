package com.journal.model;

public class Group {
    private int id;
    private String nameGroup;

    public Group(Builder builder) {
        this.nameGroup = builder.nameGroup;
    }
  
    public int getId() {
        return id;
    }

    public String getGroup() {
        return nameGroup;
    }

    public static class Builder {

        private String nameGroup;

        public Builder setGroup(String nameGroup) {
            this.nameGroup = nameGroup;
            return this;
        }

        public Group build() {
            return new Group(this);
        }
    }
}