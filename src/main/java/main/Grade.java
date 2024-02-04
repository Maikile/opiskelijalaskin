package main;

import java.io.Serializable;

public class Grade implements Serializable {
    private String course;
    private int mark;
    private int chooseStudent;
   
public Grade(String course, int grade, int chooseStudent){
    this.course = course;
    this.mark = grade;
    this.chooseStudent = chooseStudent;

}
public String getCourse(){
    return this.course;
}
public int getGrade(){
    return this.mark;
}
public int getChooseStudent(){
    return this.chooseStudent;
}
}
