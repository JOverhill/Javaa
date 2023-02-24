

public class App {
    public static void main(String[] args) throws Exception {
        

        Student oppilas1 = new Student();
        oppilas1.setFirstName("Donald");
        oppilas1.setLastName("Duck");
        oppilas1.setId(0);
        oppilas1.setBachelorCredits(180);
        oppilas1.setMasterCredits(120);
        oppilas1.setTitleOfBachelorThesis("Bachelor thesis title");
        //oppilas1.setTitleOfMastersThesis("jotain");
        oppilas1.setstartYear(2021);
        oppilas1.setGraduationYear(2023);
        
        Student oppilas2 = new Student("Mouse", "Mickey");
        oppilas2.setFirstName(null);
        oppilas2.setLastName(null);
        oppilas2.setBachelorCredits(180);
        oppilas2.setMasterCredits(120);
        oppilas2.setTitleOfBachelorThesis("How to survive a bachelors thesis");
        oppilas2.setTitleOfMastersThesis("Happy ending");
        oppilas2.setId(101);
        oppilas2.setGraduationYear(2019);

        
        //Testitulostukset
        System.out.println(oppilas1);
        System.out.println(" ");
        System.out.println(oppilas2);
        System.out.println(" ");
        
        //Test 3 version 1 Print the output when setting the graduation year
        System.out.println(oppilas1.setGraduationYear(2023));
        System.out.println(oppilas2.setGraduationYear(2019));
    }
    
}

