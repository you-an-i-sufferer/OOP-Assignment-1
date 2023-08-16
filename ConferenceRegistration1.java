
package conferenceregistration1;

/**
 *
 * @author lil
 */

import java.util.Scanner;
//TODO -- import other Java classes needed


public class ConferenceRegistration1 {

 
    final int ENTER_MEMBER = 1;    
    final int SEARCH_A_MEMBER = 2;
    final int VIEW_ALL_MEMBERS = 3;
    final int TOTAL_REG_FEE = 4;
    final int EXIT = 5;
    
    //TODO -- declare an ArrayList object to store member list objects.
  
    
    // this method get a MenuItem
    private int getMenuItem()
    {
    
        Scanner inputMenuChoice = new Scanner(System.in);
        
        System.out.println("\nPlease select from the following");        
        System.out.println(ENTER_MEMBER  + ". Enter member details");       
        System.out.println(SEARCH_A_MEMBER + ". Search a member");
        System.out.println(VIEW_ALL_MEMBERS + ". View all members");
        System.out.println(TOTAL_REG_FEE + ". View total registration fee");
        
        System.out.println(EXIT + ". Exit the application");
        System.out.print("\nEnter choice ==> ");

        String choice = inputMenuChoice.nextLine();

	while (choice.equals("") || !isStringNumeric(choice))
	{
          System.out.println("Error - Menu selection cannot be blank and must be numeric");
	    System.out.print("Enter choice ==> ");

	    choice = inputMenuChoice.nextLine();
	}
	return Integer.parseInt(choice);
    }
    
    //check if a string is numeric
    private boolean isStringNumeric(String str)
    {
	for (int i = 0; i < str.length(); i++)
    	{
    	    if (!Character.isDigit(str.charAt(i)))
		return false;
	}

	return true;
    }
    
    //check if a string is validate 
    private boolean isValidate(String input)
    {
      if (input.equalsIgnoreCase("S") || input.equalsIgnoreCase("K"))
      {       
          return true;
      }
      
      if (input.equalsIgnoreCase("N"))
      {
          return true;
      }
      return false;
           
    }
    
    
    private void processOrders()
    {
	System.out.printf("\nWelcome to the Conference Registration System\n\n");
        
        int choice = getMenuItem();
	
        while (choice != EXIT)
	{
     	    switch (choice)
	    {
		case ENTER_MEMBER:
			enterMemberRecord();
			break;
		case SEARCH_A_MEMBER:
			searchMember();
			break;
                case VIEW_ALL_MEMBERS:
			viewAllMembers();                                                  
			break; 
                case TOTAL_REG_FEE:			
                        totalRegFee();                                
			break;        
		default:
			System.out.println("ERROR choice not recognised");
            }
            
            choice = getMenuItem();
	}
        
        //TODO -- display "Thank you" message
        //TODO -- display "Program author's name, student ID and date"
        
    }
    
    private void totalRegFee()
    {
       
        //TODO -- get size from the member list
	//TODO -- using for loop to get each member's registration fee and sum them up
	//TODO -- note, ArrlyList has a get(i) method to get each element in the ArrlyList
	//TODO -- output the total registration fee   
      
    }
    
    
    private void viewAllMembers()
    {
       
        //TODO -- get size from the member list
	//If memeber size is 0, output "No member found!"
	//If member size is > 0
	//using a for loop to get each element from the member list
	//output the member details by calling its toString method.  
    }
    
    
    private void searchMember()
    {
        Scanner inText = new Scanner(System.in);
        String input;
        int memberID;
        
        do {
            System.out.printf("Pease enter a numberID: ");
            
            input = inText.nextLine();
           
            if (input.equals("") || !isStringNumeric(input))     
                System.out.printf("Error - Member ID cannot be blank and must be numeric\n");
                
        } while (input.equals("") || !isStringNumeric(input));

        memberID = Integer.parseInt(input);

        int index = findMemberRecord(memberID);

        if (index > -1) 
        {   
            //TODO -- member found, get the related memeber by the index
	    //TODO  -- display "Member found" message
            //TODO -- display related member information
                                       
            
        }    
        else
          //TODO - display "No record found" message
            System.out.println();          
        	
    }
    
    
    private int findMemberRecord(int memberID)
    {
        int index = -1;
       
        //TODO -- get the size from the member list
	//TODO -- using for loop to get each element of the list
	//TODO -- if the element's memberID  == memberID to be found
        //TODO -- update the index value to the curent element's index
       
        return index;
    }
    
    private void enterMemberRecord()
    {
	//declare all variables to held users' input for members 
	     
       /* 
        int memberID;
        String fullName;
        String university;
        String email;
        String phoneNumber;
        float regFee; 
        
        float discount = 0.0F;
        String talk ="";
       */ 
        int index;
        String input;
        
        boolean isStudent = false;
        boolean isKeynote = false;
        
        
        Scanner inText = new Scanner(System.in);
        
        //enter memberID
        do {
            System.out.printf("Please enter member ID: (must be an integer) ");
            
            input = inText.nextLine();
            
            if (input.equals("") || !isStringNumeric(input))
               System.out.printf("Error - Member ID must be a number and cannot be blank\n"); 
            
        } while(input.equals("") || !isStringNumeric(input));
            
       //TODO - assignment user's input to member ID    
             
       //TODO - call findMemberRecord() method to check if the member ID is exist in the current list       
       //TODO -- if the member ID is already exist, display "Member with this ID alreasy exsit"
             //TODO -- return to the main menu
       
       //TODO -- enter other details, full name, university, email, phone etc
       
       //TODO -- enter full member fee, note using do loop, check the input string must be numeric, take privious code as reference
        
              
        //ask the member type
        do {
            System.out.printf("Is this member a Student or a Keynote spearker? ('S' for student, 'K' for keynote speaker, 'N' for None of above) ");
            
            input = inText.nextLine();
            
            if (input.equals("") || !isValidate(input))            
           
               System.out.printf("Error - please select S, K or N \n"); 
            
        } while(input.equals("") || !isValidate(input));
            
        //TODO - check if  is a student, assign isStudent = true
            //TODO - using a do loop to ask user to input a discount (must be numeric)
            //TODO - assign discount value
        
        //TODO - if is a keynote member, assign isKeynote = true
            //TODO - apply fee = 0 or discount = 100
            //TODO - enter talk
        
        
        //next, construct object and add the new member onto the list
        
        if (isStudent == true)
        {
            //TODO - create a student member object
            //TODO - add the object to the member list
            //TODO - display the member information   
           
        }
        if (isKeynote == true)
        {
            //TODO - create a keynote speaker member object
            //TODO - add the object to the member list
            //TODO - display the member information   

        }else
        {
            //TODO - create a full member object
            //TODO - add the object to the member list
            //TODO - display the member information            
           
        }
   
    }
    
    public static void main(String[] args) {
        
        ConferenceRegistration1 myApp = new ConferenceRegistration1();
	  myApp.processOrders();
    }
    
}
