import java.util.*;
abstract class JobRole{
    private String role;
    private String requriedskills;

    public JobRole(String role, String requriedskills){
        this.role = role;
        this.requriedskills = requriedskills;
    }

    public String getrole(){
        return role;
    }

    public String getrequriedskills(){
        return requriedskills;
    }

    public abstract void displayRoleDetails();
}

class SoftwareEngineer extends JobRole{
    public SoftwareEngineer(String requriedskills){
        super("Software Engineer", requriedskills);
    }

    public void displayRoleDetails(){
        System.out.println(getrole()+" - Requried Skills : "+getrequriedskills());
    }
}

class DataScientist extends JobRole{
    public DataScientist(String requriedskills){
        super("Data Scientist", requriedskills);
    }

    public void displayRoleDetails(){
        System.out.println(getrole()+" - Requried Skills : "+getrequriedskills());
    }
}

class ProductManager extends JobRole{
    public ProductManager (String requriedskills){
        super("Product Manager",requriedskills);
    }

    public void displayRoleDetails(){
        System.out.println(getrole()+" - Requried Skills : "+getrequriedskills());
    }
}

class Resume<T extends JobRole>{
    private String name;
    private T JobRole;

    public Resume(String name,T JobRole){
        this.name = name;
        this.JobRole = JobRole;
    }

    public String getname(){
        return name;
    }

    public T getJobRole(){
        return JobRole;
    }

    public void displayResume(){
        System.out.println("Canditate Name : "+name);
        JobRole.displayRoleDetails();
    }
}

class ResumeScreeningutil{
    public static <T extends JobRole> void screening (Resume<T> resume){
        System.out.println("Candidate Name : "+resume.getname());
        resume.displayResume();
    }

    public static void displayallResumes(List<? extends JobRole> resumes){
        for (JobRole resume : resumes){
            resume.displayRoleDetails();
        }
    }
}
public class AIResumeScreening {
    public static void main(String[] args) {
        SoftwareEngineer seRole = new SoftwareEngineer("Java, Spring, Microservices");
        DataScientist dsRole = new DataScientist("Python, Machine Learning, SQL");
        ProductManager pmRole  = new ProductManager("Agile, Product Roadmap, Cross-functional teams");

        Resume<SoftwareEngineer> resumeSE = new Resume("Dheeraj", seRole);
        Resume<DataScientist> resumeDS = new Resume("Achyuth", dsRole);
        Resume<ProductManager> resumePM = new Resume("Devath",  pmRole);

        List<JobRole> allresumes = new ArrayList<>();
        allresumes.add(seRole);
        allresumes.add(dsRole);
        allresumes.add(pmRole);
        
        System.out.println("\nAll Resumes in the Screening Pipeline:");
        ResumeScreeningutil.displayallResumes(allresumes);
    }
}
