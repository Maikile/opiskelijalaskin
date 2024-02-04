package main;
import java.io.Serializable;


public class Student implements Serializable {
    private String name;
    private int studentNum;
    
public Student(String student, int studentNum){
    this.name = student;
    this.studentNum = studentNum;

}
public String getStudent(){
    return this.name;
}

public int getStudentNum(){
    return this.studentNum;
}


}