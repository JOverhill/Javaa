import java.lang.Math;
  

public class Student {
    //Attribuutit
    private String firstName = ConstantValues.NO_NAME;
    private String lastName = ConstantValues.NO_NAME;
    private int id;
    private double bachelorCredits = 0;
    private double masterCredits = 0;
    private String titleOfMastersThesis = ConstantValues.NO_TITLE;
    private String titleOfBachelorThesis = ConstantValues.NO_TITLE;
    private int startYear = 2023;
    private int graduationYear;
    //private String birthDate = ConstantValues.NO_BIRTHDATE;
    private int studyYears;
    
    //Student constructor ilman parametreja
    public Student() {
        setId(0);
    }

    //Student constructor kahdella parametrilla
    public Student(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        setId(0); 
    }

    //getters & setters
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        if (firstName != null) {
            this.firstName = firstName;
        }    
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        if (lastName != null) {
            this.lastName = lastName;
        }   
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        if (id >= ConstantValues.MIN_ID && id <= ConstantValues.MAX_ID) {
            this.id = id;
        } else {
            this.id = getRandomId();  
        } 
    }
   
    public double getBachelorCredits() {
        return bachelorCredits;
    }
    public void setBachelorCredits(final double bachelorCredits) {
        if (bachelorCredits >= ConstantValues.MIN_CREDIT && bachelorCredits <= ConstantValues.MAX_CREDITS) {
            this.bachelorCredits = bachelorCredits;
        }   
    }

    public double getMasterCredits() {
        return masterCredits;
    }
    public void setMasterCredits(final double masterCredits) {
        if (masterCredits >= ConstantValues.MIN_CREDIT && masterCredits <= ConstantValues.MAX_CREDITS) {
            this.masterCredits = masterCredits;
        }
    }

    public String getTitleOfMastersThesis() {
        return titleOfMastersThesis;
    }
    public void setTitleOfMastersThesis(String title) {
        if(title != null) {
            this.titleOfMastersThesis = title;
        }
    }

    public String getTitleOfBachelorThesis() {
        return titleOfBachelorThesis;
    }
    public void setTitleOfBachelorThesis(String title) {
        if(title != null) {
            this.titleOfBachelorThesis = title;
        }
    }

    public int getstartYear() {
        return startYear;
    }
    public void setstartYear(final int startYear) {
        if (startYear >= 2000 && startYear <= 2023) {
            this.startYear = startYear;
        }
    }

    public int getGraduationYear() {
        return graduationYear;
    }
    public String setGraduationYear(final int graduationYear) {
        if (!canGraduate()) {
           // System.out.println("Check the required studies");
            return "Check the required studies";
        }
        if (graduationYear < startYear || graduationYear > 2023) {
            //System.out.println("Check graduation year");
            return "Check graduation year";
        }
        else if (canGraduate()) {
            this.graduationYear = graduationYear;
            return "Ok";
        }
        else return "Unexpected error";
    }

    public boolean hasGraduated() {
        if (graduationYear != 0) {
            return true;
        }
        else return false;

    }
    private boolean canGraduate() {
        if (bachelorCredits < ConstantValues.BACHELOR_CREDITS || masterCredits < ConstantValues.MASTER_CREDITS) {
            return false;          
        }
        if (titleOfBachelorThesis == ConstantValues.NO_TITLE || titleOfMastersThesis == ConstantValues.NO_TITLE) {
            return false;
        } 
        else return true;   
    } 

    public int getStudyYears() {   
        if (canGraduate() && graduationYear != 0) {
            this.studyYears = graduationYear - startYear;
            return this.studyYears;
        }
        else {
            this.studyYears = 2023 - startYear;
            return this.studyYears;
        }
    }

    private int getRandomId() {
        int id = (int)(Math.random() * (ConstantValues.MAX_ID - ConstantValues.MIN_ID + 1) + ConstantValues.MIN_ID);
        return id;
    }

    //Apumetodi toString() metodille
    public String status(){
        if (!hasGraduated()) {
            return "The student has not graduated, yet";
        }
        else return "The student has graduated in " + graduationYear;
    }

    public String toString() {
        return "Student id: "+id + "\n" + "FirstName: "+firstName+", "+"LastName: "+lastName + "\n"
        +"Status: " + status() + "\n" + "StartYear: " + startYear + " (studies have lasted for " + getStudyYears() + " years)" 
        + "\n" + "BachelorCredits: " + bachelorCredits + "\n"
        +"MasterCredits: " + masterCredits + "\n"
        +"TitleOfMastersThesis: " + titleOfMastersThesis + "\n" + "TitleofBachelorThesis: " + titleOfBachelorThesis;
    } 

    

}