package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class University {
    final private String FILENAME;
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Grade> grades = new ArrayList<>();

    public University(){
        FILENAME = "students.data";
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void addGrade(Grade grade){
        grades.add(grade);
    }


    public ArrayList<Grade> getArrayList(){
        return grades;
    }

    public void listStudentInformation(){
    System.out.println("Opiskelijat:");
    for (Student names : students) {
        System.out.println(names.getStudentNum()+": "+names.getStudent());   }
    }

    public void listStudents(){
    int i = 0;
    for (Student names : students) {
        System.out.println(i++ +": "+names.getStudent());

    }
}
    public void listGrades(int choice){
    for (Grade marks : grades) {
        if(choice == marks.getChooseStudent()){
            System.out.println(marks.getCourse()+": "+marks.getGrade());
        }
    }
}
    public void saveStudents(){
        try {
            ObjectOutputStream studentWriter = new ObjectOutputStream(new FileOutputStream(FILENAME));
            studentWriter.writeObject(students);
            studentWriter.writeObject(grades);
            studentWriter.close();
        } catch (IOException e) {
            System.out.println("Tiedoston kirjoittaminen epäonnistui");
        }

    }

    public void loadStudents(){
        try {
            ObjectInputStream studentReader = new ObjectInputStream(new FileInputStream(FILENAME));
            students = (ArrayList<Student>) studentReader.readObject();
            grades = (ArrayList<Grade>) studentReader.readObject();
            studentReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Tiedoston lataaminen epäonnistui");
        } catch (IOException e) {
            System.out.println("Tiedoston lataaminen epäonnistui");
        }
        catch (ClassNotFoundException e){
            System.out.println("Tiedoston lataaminen epäonnistui");
        }
    }

public void getAverageGrade(int averageChoice){
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

