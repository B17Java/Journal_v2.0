package com.journal.handling;

import java.util.Scanner;

public class InputLessonData {

    private Scanner scanner = new Scanner(System.in);
    private
    public void inputLessonData(){

        int choice = -1;
        while (true){
            System.out.print("Make your choice to handle student: ");
            System.out.println( "[1]- To add  [2]- Show by id  [3]- Show All  [4]- Find by name  " +
                    "[5]- Update by id  [6]- Delete by id  [0]- Exit");
            String data = scanner.nextLine();
            try {
                choice = Integer.parseInt(data.trim());
            }
            catch (NumberFormatException e){
                System.out.println("Incorrect choice");
                return;
            }
            switch (choice){
                case 0: return;
                case 1:
                    System.out.println(save()); break;
                case 2:
                    System.out.println(findId()); break;
                case 3:
                    System.out.println(findAll()); break;
                case 4:
                    System.out.println(findByFirstNameOrLastName()); break;
                case 5:
                    System.out.println(updateById()); break;
                case 6:
                    System.out.println(deleteById()); break;
                default: System.out.println("Incorrectly input");
            }
            System.out.println("=======================================================");
        }
    }



    private boolean save() {
        return false;
    }

    private boolean findId() {
        return false;
    }

    private boolean findAll() {
        return false;
    }

    private boolean findByFirstNameOrLastName() {
        return false;
    }

    private boolean updateById() {
        return false;
    }

    private boolean deleteById() {
        return false;
    }
}
