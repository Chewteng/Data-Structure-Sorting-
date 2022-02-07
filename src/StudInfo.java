/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chew Teng
 */
public class StudInfo {
    private String matricNum;
    private String name;
    private String school;
    
    public StudInfo (String matricNum,String name, String school)
    {
        this.matricNum= matricNum;
        this.name= name;
        this.school= school;
    }

    StudInfo(int matricNum, String name, String school) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setmatricNum (String newMatric)
    {
        matricNum = newMatric;
    }
    
    public String getmatricNum ()
    {
        return matricNum;
    }
    
    public void setName (String newName)
    {
        name = newName;
    }
    
    public String getName ()
    {
        return name;
    }
    
    public void setSchool (String newSchool)
    {
        school = newSchool;
    }
    
    public String getSchool ()
    {
        return school;
    }

    int compareTo(StudInfo pivot) {
        return 0;
        
    }

  
}
