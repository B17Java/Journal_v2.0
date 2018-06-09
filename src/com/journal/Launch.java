package com.journal;

import com.journal.handling.InputGroupData;
import com.journal.handling.InputLessonData;
import com.journal.handling.InputStudentData;
import com.journal.handling.InputTeacherData;

import java.util.Scanner;

public class Launch {

    private boolean isTrue = true;
    private Scanner scanner = new Scanner(System.in);
    private InputGroupData groupData = new InputGroupData();
    private InputLessonData lessonData = new InputLessonData();
    private InputTeacherData teacherData = new InputTeacherData();
    private InputStudentData studentData = new InputStudentData();

    public void start() {
        while (isTrue){
            int choice = -1;
            System.out.print("Make your choice: ");
            System.out.println( "[1]- Lesson  [2]- Teacher  [3]- Group  [4]- Student   [0]- Exit");
            String data = scanner.nextLine();
            try {
                choice = Integer.parseInt(data.trim());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            switch (choice) {
                case 0:  isTrue = false; break;
                //case 1:  lessonData.inputLessonData(); break;
                case 2:  teacherData.inputTeacherData(); break;
                case 3:  groupData.inputGroupData(); break;
                case 4:  studentData.inputStudentData(); break;
                case 5:  ; break;
                case 6:  ; break;
                default: System.out.println("Incorrectly input");
            }
            System.out.println("=======================================================");
        }
    }
}
