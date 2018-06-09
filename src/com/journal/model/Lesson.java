package com.journal.model;

public class Lesson {
    private int id;
    private String lessonName;
    private String lessonRoom;
    private String idGroup;
    private String numberOfLesson;
    private String Room;
    private String Subject;

    public Lesson(Builder builder) {
        this.lessonName = lessonName;
    }

    public int getId() {
        return id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public String getLessonRoom() {
        return lessonRoom;
    }

    public String getIdGroup() {
        return idGroup;
    }

    public String getNumberOfLesson() {
        return numberOfLesson;
    }

    public String getRoom() {
        return Room;
    }

    public String getSubject() {
        return Subject;
    }

    private static class Builder {
        private String lessonName;
        private String lessonRoom;
        private String idGroup;
        private String numberOfLesson;
        private String Room;
        private String Subject;

        public Builder setLessonName(String lessonName) {
            this.lessonName = lessonName;
            return this;
        }

        public Builder setLessonRoom(String lessonRoom) {
            this.lessonRoom = lessonRoom;
            return this;
        }

        public Builder setIdGroup(String idGroup) {
            this.idGroup = idGroup;
            return this;
        }

        public Builder setNumberOfLesson(String numberOfLesson) {
            this.numberOfLesson = numberOfLesson;
            return this;
        }

        public Builder setRoom(String room) {
            Room = room;
            return this;
        }

        public Builder setSubject(String subject) {
            Subject = subject;
            return this;
        }

        public Lesson build() {
            return new Lesson(this);
        }


    }
}
