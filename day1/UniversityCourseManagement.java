import java.util.*;
abstract class CourseType{
    private String coursename;
    private String instructor;

    public CourseType(String coursename, String instructor){
        this.coursename = coursename;
        this.instructor = instructor;
    }

    public String getcoursename(){
        return coursename;
    }

    public String getinstructor(){
        return instructor;
    }

    public abstract void displayEvaluationMethod();
}

class ExamCourse extends CourseType{

    public ExamCourse(String coursename, String instructor) {
        super(coursename, instructor);
    }

    public void displayEvaluationMethod(){
        System.out.println(getcoursename()+"- instructor : "+getinstructor()+" | Evaluation : Exam-Based");
    } 
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String coursename, String instructor){
        super(coursename, instructor);
    }

    public void displayEvaluationMethod(){
        System.out.println(getcoursename()+" - Instructor : "+getinstructor()+" | Evalution : Assignment-Based");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String coursename, String instructor){
        super(coursename, instructor);
    }

    public void displayEvaluationMethod(){
        System.out.println(getcoursename()+" - Instructor : "+getinstructor()+" | Evalution : Research-Based");
    }
}

class Course<T extends CourseType> {
    private T courseType;

    public Course(T courseType){
        this.courseType = courseType;
    }

    public T getcourseTypes(){
        return courseType;
    }

    public void showdetails(){
        courseType.displayEvaluationMethod();
    }
}

class Courseutil {
    public static void displayallcourses (List<? extends CourseType> courseList){
        for(CourseType course : courseList){
            course.displayEvaluationMethod();
        }
    }
}

public class UniversityCourseManagement {
    public static void main(String[] args) {
        Course<ExamCourse> math101 = new Course<>(new ExamCourse("Math 101", "Dr. Rao"));
        Course<AssignmentCourse> cs102 = new Course<>(new AssignmentCourse("CS 102", "Prof. Kapoor"));
        Course<ResearchCourse> phy303 = new Course<>(new ResearchCourse("Physics 303", "Dr. Mehta"));

        List<CourseType> courseList = new ArrayList<>();
        courseList.add(math101.getcourseTypes());
        courseList.add(cs102.getcourseTypes());
        courseList.add(phy303.getcourseTypes());

        System.out.println("Univeristy CourseList : ");
        Courseutil.displayallcourses(courseList);
    }
}
