package com.journal.repository.impl;

import com.journal.model.Student;
import com.journal.repository.StudentRepository;

import java.io.*;

public class StudentRepositoryFile implements StudentRepository {

    @Override
    public boolean save(Student student) {
        try {
            String line = null, lastLine = "";
            int idLast;
            BufferedReader bufferedReader = new BufferedReader(new FileReader("student.txt"));
            while ((line = bufferedReader.readLine()) != null) {
                lastLine = line;
                if (lastLine.split(" ")[1].equals(student.getFirstName()) &&
                        lastLine.split(" ")[2].equals(student.getLastName())) {
                    return false;
                }
            }
            idLast = (lastLine == "") ? 0 : Integer.parseInt(lastLine.split(" ")[0]);
            bufferedReader.close();
            BufferedWriter bufferWriter = new BufferedWriter(new FileWriter("student.txt", true));
            if (idLast == 0) {
                bufferWriter.write((idLast + 1) + " " + student);
            } else {
                bufferWriter.write("\n" + (idLast + 1) + " " + student);
            }
            bufferWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public Student findId(String id) {
        Student student = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("student.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.split(" ")[0].equals(id)) {
                    student = new Student.Builder().setFirstName(line.split(" ")[1]).setLastName(line.split(" ")[2]).build();
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return student;
    }

    @Override
    public String findAll() {
        String strings = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("student.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                strings += line + "\n";
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return strings.equals("") ? null : strings;
    }

    @Override
    public String findByFirstNameOrLastName(String name) {
        String strings = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("student.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.split(" ")[1].equals(name) || line.split(" ")[2].equals(name)) {
                    strings += line + "\n";
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return strings.equals("") ? null : strings;
    }

    @Override
    public boolean updateById(String id, String firstName, String lastName) {
        String strings = "";
        boolean isUpdate = false;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("student.txt"));
            String line;
            int index = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.split(" ")[0].equals(id)) {
                    isUpdate = true;
                    strings += (index == 0) ? id + " " + firstName + " " + lastName + " " + "\n" :
                            "\n" + id + " " + firstName + " " + lastName + " ";
                } else {
                    strings += (index++ == 0) ? line : "\n" + line;
                }
            }
            bufferedReader.close();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("student.txt"));
            bufferedWriter.write(strings);
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return isUpdate;
    }

    @Override
    public boolean deleteById(String id) {
        String strings = "";
        boolean isDelete = false;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("student.txt"));
            String line;
            int index = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.split(" ")[0].equals(id)) {
                    isDelete = true;
                    continue;
                }
                strings += (index++ == 0) ? line : "\n" + line;
            }
            bufferedReader.close();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("student.txt"));
            bufferedWriter.write(strings);
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return isDelete;
    }
}

