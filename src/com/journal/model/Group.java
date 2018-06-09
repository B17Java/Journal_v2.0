package com.journal.model;

public class Group {
    private int ID;
    private String nameGroup;

    public Group(Builder builder) {
        this.nameGroup = builder.nameGroup;
    }

    public int getID() {
        return ID;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public static class Builder {
        private int ID;
        private String nameGroup;

        public Builder setNameGroup(String nameGroup) {
            this.nameGroup = nameGroup;
            return this;
        }

        public Group buid() {
            return new Group(this);
        }
    }


}

