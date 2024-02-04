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

    public University(){
        FILENAME = "students.data";
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void listStudentInformation(){
    for (Student names : students) {
        System.out.println(names.getStudentNum()+": "+names.getStudent());   }
    }

    public void listStudents(){
    int i = 0;
    for (Student names : students) {
        System.out.println(i++ +": "+names.getStudent());

    }
}

    public void saveStudents(){
        try {
            ObjectOutputStream studentWriter = new ObjectOutputStream(new FileOutputStream(FILENAME));
            studentWriter.writeObject(students);
            studentWriter.close();
        } catch (IOException e) {
            System.out.println("Tiedoston kirjoittaminen epäonnistui");
        }

    }

    public void loadStudents(){
        try {
            ObjectInputStream studentReader = new ObjectInputStream(new FileInputStream(FILENAME));
            students = (ArrayList<Student>) studentReader.readObject();
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


}
