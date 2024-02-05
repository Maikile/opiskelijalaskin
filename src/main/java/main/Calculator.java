package main;

import java.io.Serializable;
import java.util.ArrayList;

public class Calculator implements Serializable{
    ArrayList<Grade> grades = new ArrayList<>();

    public void getAverageGrade(int averageChoice){
        System.out.println(grades);
        double sum = 0;
        int i = 0;
        for (Grade marks : grades) {
            if(averageChoice == marks.getChooseStudent()){
                sum += marks.getGrade();
                i++;
            }
        }
        if(i == 0){
            System.out.println("Keskiarvo on 0");
        }
        else{
            System.out.println("Keskiarvo on "+sum/i);
        }
    }

public void getMedianGrade(int medianChoice){
    double sum = 0;
    int i = 0;        
    for (Grade marks : grades) {
        if(medianChoice == marks.getChooseStudent()){
            i++;
        }
    }
    if(i == 0){
        System.out.println("Mediaani on 0");
    }
    else{
        System.out.println("Mediaani on "+sum/i);
    }
}
}
