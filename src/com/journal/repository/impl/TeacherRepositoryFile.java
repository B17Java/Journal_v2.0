package com.journal.repository.impl;

import com.journal.model.Teacher;
import com.journal.repository.TeacherRepository;

import java.io.*;

public class TeacherRepositoryFile implements TeacherRepository {

    @Override
    public boolean save(Teacher teacher) {
        try {
            String line = null, lastLine = "";
            int idLast;
            BufferedReader bufferedReader = new BufferedReader(new FileReader("teacher.txt"));
            while ((line = bufferedReader.readLine()) != null) {
                lastLine = line;
                if (lastLine.split(" ")[1].equals(teacher.getFirstName()) &&
                        lastLine.split(" ")[2].equals(teacher.getLastName())) {
                    return false;
                }
            }
            idLast = (lastLine == "") ? 0 : Integer.parseInt(lastLine.split(" ")[0]);
            bufferedReader.close();
            BufferedWriter bufferWriter = new BufferedWriter(new FileWriter("teacher.txt", true));
            if (idLast == 0) {
                bufferWriter.write((idLast + 1) + " " + teacher);
            } else {
                bufferWriter.write("\n" + (idLast + 1) + " " + teacher);
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
    public Teacher findId(String id) {
        Teacher teacher = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("teacher.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.split(" ")[0].equals(id)) {
                    teacher = new Teacher.Builder().setFirstName(line.split(" ")[1]).setLastName(line.split(" ")[2]).build();
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return teacher;
    }

    @Override
    public String findAll() {
        String strings = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("teacher.txt"));
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
            BufferedReader bufferedReader = new BufferedReader(new FileReader("teacher.txt"));
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
            BufferedReader bufferedReader = new BufferedReader(new FileReader("teacher.txt"));
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
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("teacher.txt"));
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
            BufferedReader bufferedReader = new BufferedReader(new FileReader("teacher.txt"));
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
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("teacher.txt"));
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
