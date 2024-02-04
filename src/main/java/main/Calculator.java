package main;

import java.io.Serializable;
import java.util.ArrayList;

public class Calculator implements Serializable{
    private ArrayList<Grade> grades = new ArrayList<>();
    private int averageChoice;

    public Calculator(int averageChoice){
        this.averageChoice = averageChoice;
    }

    public void getAverageGrade(){
        double sum = 0;
        int a = 0;        
        for (Grade marks : grades) {
            if(averageChoice == marks.getChooseStudent()){
                sum += marks.getGrade();
                a++;
            }
        }
        if(a == 0){
            System.out.println("Keskiarvo on 0");
        }
        else{
            System.out.println("Keskiarvo on "+sum/a);
        }
    }
}
