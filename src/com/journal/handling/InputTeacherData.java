package com.journal.handling;

import com.journal.controller.ControllerTeacher;

import java.util.Scanner;

public class InputTeacherData {

    private Scanner scanner = new Scanner(System.in);
    private ControllerTeacher controllerTeacher = new ControllerTeacher();

    public void inputTeacherData() {

        int choice = -1;
        while (true) {
            System.out.print("Make your choice to handle teacher: ");
            System.out.println("[1]- To add  [2]- Show by id  [3]- Show All  [4]- Find by name  " +
                    "[5]- Update by id  [6]- Delete by id  [0]- Exit");
            String data = scanner.nextLine();
            try {
                choice = Integer.parseInt(data.trim());
            } catch (NumberFormatException e) {
                System.out.println("Incorrect choice");
                return;
            }
            switch (choice) {
                case 0:
                    return;
                case 1:
                    System.out.println(save());
                    break;
                case 2:
                    System.out.println(findId());
                    break;
                case 3:
                    System.out.println(findAll());
                    break;
                case 4:
                    System.out.println(findByFirstNameOrLastName());
                    break;
                case 5:
                    System.out.println(updateById());
                    break;
                case 6:
                    System.out.println(deleteById());
                    break;
                default:
                    System.out.println("Incorrectly input");
            }
            System.out.println("=======================================================");
        }
    }


    private String save() {
        System.out.print("Input first name : ");
        String firstName = scanner.nextLine();
        System.out.print("Input last name : ");
        String lastName = scanner.nextLine();
        return controllerTeacher.save(firstName, lastName);
    }

    private String findId() {
        System.out.print("Input id : ");
        String id = scanner.nextLine();
        return controllerTeacher.findId(id);
    }

    private String findAll() {
        return controllerTeacher.findAll();
    }

    private String findByFirstNameOrLastName() {
        System.out.print("Input first or last name : ");
        String name = scanner.nextLine();
        return controllerTeacher.findByFirstNameOrLastName(name);
    }

    private String updateById() {
        System.out.print("Input id : ");
        String id = scanner.nextLine();
        System.out.print("Input new first name : ");
        String firstName = scanner.nextLine();
        System.out.print("Input new last name : ");
        String lastName = scanner.nextLine();
        return controllerTeacher.updateById(id, firstName, lastName);
    }

    private String deleteById() {
        System.out.print("Input id : ");
        String id = scanner.nextLine();
        return controllerTeacher.deleteById(id);
    }
}
