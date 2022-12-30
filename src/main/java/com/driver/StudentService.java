package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void  addStudent(Student student)
    {
        studentRepository.addStudentToDb(student);

    }

    public void  addTeacher(Teacher teacher)
    {
        studentRepository.addTeacherToDb(teacher);

    }

    public void  addStudentTeacherPair(String student,String teacher)
    {
        studentRepository.addStudentTeacherToDb(student,teacher);
    }

    public Student getStudentByName(String student)
    {
       Student response= studentRepository.getStudentByNameFromDb(student);
       return response;
    }

    public Teacher getTeacherByName(String teacher)
    {
        Teacher response= studentRepository.getTeacherByNameFromDb(teacher);
        return response;
    }

    public List<String> getStudentsByTeacherName(String teacher){

        return studentRepository.getStudentsByTeacherNameFromDb(teacher);
    }

    public List<String> getAllStudents(){
        return studentRepository.getAllStudentsFromDb();
    }

    public void deleteTeacherByName(String teacher){
        studentRepository.deleteTeacherByNameFromDb(teacher);
    }

    public void deleteAllTeachers(){
        studentRepository.deleteAllTeachersFromDb();
    }



}
