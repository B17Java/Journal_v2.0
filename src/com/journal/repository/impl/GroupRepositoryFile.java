package com.journal.repository.impl;

import com.journal.model.Group;
import com.journal.repository.GroupRepository;

import java.io.*;

public class GroupRepositoryFile implements GroupRepository {

    @Override
    public boolean save(Group group) {
        try {
            String line = null, lastLine = "";
            int idLast;
            BufferedReader bufferedReader = new BufferedReader(new FileReader("group.txt"));
            while ((line = bufferedReader.readLine()) != null) {
                lastLine = line;
                if (lastLine.split(" ")[1].equals(group.getGroup())) {
                    return false;
                }
            }
            idLast = (lastLine == "") ? 0 : Integer.parseInt(lastLine.split(" ")[0]);
            bufferedReader.close();
            BufferedWriter bufferWriter = new BufferedWriter(new FileWriter("group.txt", true));
            if (idLast == 0) {
                bufferWriter.write((idLast + 1) + " " + group);
            } else {
                bufferWriter.write("\n" + (idLast + 1) + " " + group);
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
    public Group findId(String id) {
        Group group = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("group.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.split(" ")[0].equals(id)) {
                    group = new Group.Builder().setGroup(line.split(" ")[1]).build();
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return group;
    }

    @Override
    public String findAll() {
        String strings = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("group.txt"));
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
    public String findByFirstNameOrLastName(String string) {
        String strings = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("group.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.split(" ")[1].equals(string)) {
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
    public boolean updateById(String id, String groupName) {
        String strings = "";
        boolean isUpdate = false;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("group.txt"));
            String line;
            int index = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.split(" ")[0].equals(id)) {
                    isUpdate = true;
                    strings += (index == 0) ? id + " " + groupName + " " + "\n" :
                            "\n" + id + " " + groupName + " ";
                } else {
                    strings += (index++ == 0) ? line : "\n" + line;
                }
            }
            bufferedReader.close();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("group.txt"));
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
            BufferedReader bufferedReader = new BufferedReader(new FileReader("group.txt"));
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
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("group.txt"));
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
