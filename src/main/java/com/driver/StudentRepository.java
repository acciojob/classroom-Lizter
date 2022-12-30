package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    HashMap<String,Student> studentDb = new HashMap<>();
    HashMap<String,Teacher> teacherDb = new HashMap<>();

    public class Pair {
        String Stu;
        String Tea;

        Pair(String Stu, String Tea) {
            this.Stu = Stu;
            this.Tea = Tea;
        }
    }

        ArrayList<Pair> pairs = new ArrayList<>();



    public void addStudentToDb(Student student){

        String name = student.getName();
        //Add it to the studentDb
        studentDb.put(name,student);

    }

    public void addTeacherToDb(Teacher teacher){

        String name = teacher.getName();
        //Add it to the teacherDb
        teacherDb.put(name,teacher);

    }

    public void addStudentTeacherToDb(String student,String teacher){

        pairs.add(new Pair(student,teacher));
    }

    public Student getStudentByNameFromDb(String name){

        if(studentDb.containsKey(name)){
            return studentDb.get(name);
        }else
            return null;
    }

    public Teacher getTeacherByNameFromDb(String name){

        if(teacherDb.containsKey(name)){
            return teacherDb.get(name);
        }else
            return null;
    }

    public List<String> getStudentsByTeacherNameFromDb(String teacher){
        List<String> StudentsOfTeacher= new ArrayList<>();

        for(int i=0;i<pairs.size();i++){
            if(pairs.get(i).Tea.equals(teacher))
                StudentsOfTeacher.add(pairs.get(i).Stu);
        }
        return StudentsOfTeacher;
    }

    public List<String> getAllStudentsFromDb(){

        List<String> StudentList = new ArrayList<>();
        for(String name:studentDb.keySet())
            StudentList.add(name);

        return StudentList;

    }


    public void deleteTeacherByNameFromDb(String teacher){
        for(int i=0;i<pairs.size();i++){
            if(pairs.get(i).Tea.equals(teacher)){
                //if(studentDb.containsKey(pairs.get(i).Stu))
                    //studentDb.remove(pairs.get(i).Stu);
                if(teacherDb.containsKey(teacher))
                    teacherDb.remove(pairs.get(i).Tea);
                pairs.remove(pairs.get(i));
            }
        }
    }

    public void deleteAllTeachersFromDb(){
        for(int i=0;i<pairs.size();i++){

            if(teacherDb.containsKey(pairs.get(i).Tea))
                teacherDb.remove(pairs.get(i).Tea);
        }
        pairs.clear();
    }




}
