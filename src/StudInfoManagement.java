import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class StudInfoManagement{

   static Scanner scan = new Scanner(System.in);
    static int input, num = 0;
    static String target;
    static String matricNum, name,school;
    static int i = 0;
    static int choice = 0;
    static ArrayList<StudInfo> student = new ArrayList <StudInfo>();
    static int count = 0;
    static int first, last;
   
    
    public static void main(String[] args) {
        System.out.println("##################################################");
        System.out.println("Welcome to Our Student Registration System");
        System.out.println("##################################################");
         
        System.out.print("Do you want to add student info [yes/no]? ==> ");
        String answer = scan.nextLine(); 
         
        System.out.println("");
        
        while(answer.equals("yes") || answer.equals("YES") )
        {
           
            System.out.print("Please Enter Your Matric Number: ");
            matricNum = scan.next();
        
            System.out.print("Please Enter Your Name: ");
            name = scan.next();

            System.out.print("Please Enter Your School [COLGIS,CAS,COB]: ");
            school = scan.next();
            
            System.out.println();
           
            System.out.print("Do you want to add student info [yes/no]? ==> ");
            answer = scan.next(); 
        
            student.add(new StudInfo(matricNum,name,school));
        }
       
        selectChoice();
        
    }
    
    public static void selectChoice() {
       
        do {
            displayMenu();

            System.out.println("Select your choice: ");
            choice = scan.nextInt();
            if (choice == 0) {
                System.out.println("Thank you and Bye.");

            } else {

                switch (choice) {
                    
                    case 1:
                        removeStudent(student);
                        break;

                    case 2:
                        searchStudent(student);
                        break;

                    case 3:
                        displaylist(student);
                        break;
                }
            }
        } while (choice != 0);

    }
      
    
     public static void removeStudent(ArrayList<StudInfo> student) {

       boolean result = student.isEmpty();
      
       if (student.size()==0)
       {       
           System.out.println("List is empty");
       }
       else {

            System.out.print("Enter matric number/ name/ school you want to delete==> ");
            String a = scan.next();

                for (int i = 0; i < student.size(); i ++) {
                    if(a.equals(student.get(i).getmatricNum())|| a.equals(student.get(i).getName()) || a.equals(student.get(i).getSchool()) ){
                    student.remove(i--);
                }         
            }
        System.out.println("Successfully Updated!!!");
        selectChoice();
    }
    }
     
    public static void searchStudent(ArrayList<StudInfo> student) 
    {
       boolean searching = false;
       boolean result = student.isEmpty();
      
       if (student.size()==0)
       {
           System.out.println("List is empty");
       }
        else {
            System.out.println("Enter matric number/ name/ school you want to search: ");
            scan.nextLine();
            target = scan.nextLine();
        
             for (int i = 0; i < student.size(); i++){
                if (student.get(i).getmatricNum().equals(target) || student.get(i).getName().equals(target) || student.get(i).getSchool().equals(target)) {
                    searching = true;
                    System.out.println("  Matric Num: " + student.get(i).getmatricNum());
                    System.out.println("  Name      : " + student.get(i).getName());
                    System.out.println("  School    : " + student.get(i).getSchool());
                    break;
                } 
            }
                if (searching == false){
                System.out.println("Sorry the Matric No or the Name enter is not in the list.");
                }
       
     }
        selectChoice();
    }
              
    public static void displayMenu() 
    {
        System.out.println("\n\n:::::::: MENU :::::::::\n"
                
                + "1. DELETE A RECORD\n"
                + "2. SEARCH FOR A RECORD\n"
                + "3. DISPLAY RECORD\n"
                + "0. Exit\n");
   
    }
 

     public static ArrayList<StudInfo> displaylist(ArrayList<StudInfo> student)
    {
        System.out.println();
        System.out.println("1. Selection Sort");
        System.out.println("2. Ascending Collection Sort");
        System.out.println("3. Insertion Sort");
                
        System.out.print("Please choose your sorting technique : ");
        int sorting = scan.nextInt();
        System.out.println();
        if(student.size()==0){
            System.out.println("The list is empty.");
        }
        else{
            System.out.println("UNSORTED LIST MATRIC NUMBER:");
            System.out.print("Matric Number: ");
            for (int l = 0; l < student.size(); l++){                              
                System.out.print("" + student.get(l).getmatricNum()+" ");              
            }
           
        }
        
        switch (sorting) {
            case 1:
                selectionSort(student);
                break;
            case 2:
                collectionSort(student);
                break;
            case 3:
                insertionSort(student); 
                break;
            
            default:
                break;
        }
    
        return student;
        
    }

    private static void insertionSort(ArrayList<StudInfo> student) {
        System.out.println("\n\nINSERTION SORTED LIST: ");
        System.out.print("Matric Number: ");
        for (int i=0; i<student.size(); i++) {
	int y = i+1;
	if (y < student.size()) {
		for (int j=0;j<y; j++) {
			if (Integer.parseInt(student.get(j).getmatricNum()) > Integer.parseInt(student.get(y).getmatricNum())) {
				Collections.swap(student, j, y);
                                System.out.print("\nNext Step:\n");
                                for(int k=0; k<student.size(); k++ ){
					System.out.print(""+student.get(k).getmatricNum()+" ");
                        }
				}
		}
	}
        }
    }
   
        private static void collectionSort(ArrayList<StudInfo> student) {
            System.out.print("\n\nMatric Number: ");
             for(int x=0; x<student.size()-1; x++){
            int minIndex=x;   //initialization the index of smallest value
            for(int y=x+1; y<student.size(); y++){
                //find the smallest value in the list
                if(Integer.parseInt(student.get(y).getmatricNum())<Integer.parseInt(student.get(minIndex).getmatricNum()))
                    minIndex=y;
            } 
            Collections.swap(student,x, minIndex);
            System.out.print("\nStep"+(x+1)+":\n");
            for(int k=0; k<student.size(); k++ ){
                System.out.print(""+student.get(k).getmatricNum()+" ");
            }
            Collections.sort(student, new Comparator<StudInfo>(){
            
             public int compare(StudInfo s1, StudInfo s2) {
                 
               return s1.getmatricNum().compareToIgnoreCase(s2.getmatricNum());
            }
        });
        }
         
               
             System.out.println("\n");
             System.out.println("ASCENDING COLLECTION SORTED LIST: ");
             for (int k=0; k<student.size(); k++ ){
            System.out.print("" + student.get(k).getmatricNum()+" ");
        }
          
        
        }
      
       private static void selectionSort(ArrayList<StudInfo> student) {
              
               
        System.out.println("\n\nSELECTION SORTED LIST: ");
        System.out.print("Matric Number: ");
        for(int x=0; x<student.size()-1; x++){
            int minIndex=x;   //initialization the index of smallest value
            for(int y=x+1; y<student.size(); y++){
                //find the smallest value in the list
                if(Integer.parseInt(student.get(y).getmatricNum())<Integer.parseInt(student.get(minIndex).getmatricNum()))
                    minIndex=y;
            } 
            Collections.swap(student, x, minIndex);
            System.out.print("\nStep"+(x+1)+":\n");
            for(int k=0; k<student.size(); k++ ){
                System.out.print(""+student.get(k).getmatricNum()+" ");
            }
        }
    }
            
        
} 