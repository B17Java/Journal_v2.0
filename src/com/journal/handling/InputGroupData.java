package com.journal.handling;

import com.journal.controller.ControllerGroup;

import java.util.Scanner;

public class InputGroupData {

    private Scanner scanner = new Scanner(System.in);
    private ControllerGroup controllerGroup = new ControllerGroup();

    public void inputGroupData() {

        int choice = -1;
        while (true) {
            System.out.print("Make your choice to handle student: ");
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
        System.out.print("Input group name : ");
        String groupName = scanner.nextLine();
        return controllerGroup.save(groupName);
    }

    private String findId() {
        System.out.print("Input id : ");
        String id = scanner.nextLine();
        return controllerGroup.findId(id);
    }

    private String findAll() {
        return controllerGroup.findAll();
    }

    private String findByFirstNameOrLastName() {
        System.out.print("Input group name : ");
        String name = scanner.nextLine();
        return controllerGroup.findByFirstNameOrLastName(name);
    }

    private String updateById() {
        System.out.print("Input id : ");
        String id = scanner.nextLine();
        System.out.print("Input new group name : ");
        String groupName = scanner.nextLine();
        return controllerGroup.updateById(id, groupName);
    }

    private String deleteById() {
        System.out.print("Input id : ");
        String id = scanner.nextLine();
        return controllerGroup.deleteById(id);
    }
}