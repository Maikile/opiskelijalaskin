package main;

import java.util.Scanner;

public class App {
    public static void main( String[] args ){
    University university = new University();
    Calculator calculator = null;
    Student student = null;
    Grade grade = null;
    {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while(!exit){
            System.out.println("1) Lisää opiskelija, 2) Listaa opiskelijat, 3) Lisää opiskelijalle suorite, 4) Listaa opiskelijan suoritteet, 5) Laske opiskelijan suoritusten keskiarvo, 6) Laske opiskelijan suoritusten mediaani, 7) Tallenna opiskelijat tiedostoon, 8) Lataa opiskelijat tiedostosta, 0) Lopeta ohjelma");
            if(sc.hasNext()){
                String stringInput = sc.nextLine();
                int i = Integer.parseInt(stringInput);
                
                switch(i){
                    case 1:
                    System.out.println("Anna opiskelijan nimi?");
                    String name = sc.nextLine();
                    System.out.println("Anna opiskelijan opiskelijanumero:");
                    String studentNumString = sc.nextLine();
                    int studentNum = Integer.parseInt(studentNumString);
                    student = new Student(name,studentNum);
                    university.addStudent(student);
                    break;

                    case 2:
                    university.listStudentInformation();
                    break;

                    case 3:
                    university.listStudents();
                    System.out.println("Mille opiskelijalle suorite lisätään?");
                    String stringChooseStudent = sc.nextLine();
                    int chooseStudent = Integer.parseInt(stringChooseStudent);
                    System.out.println("Mille kurssille suorite lisätään?");
                    String course = sc.nextLine();
                    System.out.println("Mikä arvosana kurssille lisätään?");
                    String stringMark = sc.nextLine();
                    int mark = Integer.parseInt(stringMark);
                    grade = new Grade(course,mark,chooseStudent);
                    university.addGrade(grade);
                    break;

                    case 4:
                    university.listStudents();
                    System.out.println("Minkä opiskelijan suoritteet listataan?");
                    String stringChoice = sc.nextLine();
                    int choice = Integer.parseInt(stringChoice);
                    university.listGrades(choice);
                    break;

                    case 5:
                    System.out.println("Minkä opiskelijan suoritteiden keskiarvo lasketaan?");
                    String stringAverageChoice = sc.nextLine();
                    int averageChoice = Integer.parseInt(stringAverageChoice);
                    calculator = new Calculator(averageChoice);
                    calculator.getAverageGrade();
                    break;

                    case 7:
                    university.saveStudents();
                    break;
                    
                    case 8:
                    university.loadStudents();

                    break;
                    default:
                    System.out.println("Syöte oli väärä");
                    break;

                    case 0:
                    System.out.println("Kiitos ohjelman käytöstä.");
                    exit = true;
                    break;
                }
            }
        }
        sc.close();
    }
}
}