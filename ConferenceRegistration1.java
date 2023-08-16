package s12127289.conferenceregistration1;

/**
* @author Lochlain Cathcart
* @s12127289
* 
*/
import java.util.ArrayList;
import java.util.Scanner;

class Member {
    private int memberID;
    private String fullName;
    private String university;
    private String email;
    private String phoneNumber;
    float regFee;

    public Member(int memberID, String fullName, String university, String email, String phoneNumber, float regFee) {
        this.memberID = memberID;
        this.fullName = fullName;
        this.university = university;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.regFee = regFee;
    }

    public int getMemberID() {
        return memberID;
    }

    public float getRegFee() {
        return regFee;
    }

    public String toString() {
        return "Member ID: " + memberID +
               "\nFull Name: " + fullName +
               "\nUniversity: " + university +
               "\nEmail: " + email +
               "\nPhone Number: " + phoneNumber +
               "\nRegistration Fee: $" + regFee;
    }
}

class StudentMember extends Member {
    private float discount;

    public StudentMember(int memberID, String fullName, String university, String email, String phoneNumber, float regFee, float discount) {
        super(memberID, fullName, university, email, phoneNumber, regFee);
        this.discount = discount;
    }

    public String toString() {
        return super.toString() +
               "\nDiscount: " + discount + "%" +
               "\nStudent Status: Yes";
    }
}

class KeynoteSpeaker extends Member {
    private String talk;

    public KeynoteSpeaker(int memberID, String fullName, String university, String email, String phoneNumber, float regFee, String talk) {
        super(memberID, fullName, university, email, phoneNumber, regFee);
        this.talk = talk;
    }

    public String toString() {
        return super.toString() +
               "\nTalk Title: " + talk +
               "\nRegistration Fee: $0.00 (Keynote Speaker)";
    }
}

class FullMember extends Member {
    public FullMember(int memberID, String fullName, String university, String email, String phoneNumber, float regFee) {
        super(memberID, fullName, university, email, phoneNumber, regFee);
    }

    public String toString() {
        return super.toString() +
               "\nRegistration Fee: $" + regFee;
    }
}

public class ConferenceRegistration1 {
    ArrayList<Member> memberList = new ArrayList<>();

    final int ENTER_MEMBER = 1;
    final int SEARCH_A_MEMBER = 2;
    final int VIEW_ALL_MEMBERS = 3;
    final int TOTAL_REG_FEE = 4;
    final int EXIT = 5;

    private int getMenuItem() {
        Scanner inputMenuChoice = new Scanner(System.in);

        System.out.println("\nPlease select from the following");
        System.out.println(ENTER_MEMBER  + ". Enter member details");
        System.out.println(SEARCH_A_MEMBER + ". Search a member");
        System.out.println(VIEW_ALL_MEMBERS + ". View all members");
        System.out.println(TOTAL_REG_FEE + ". View total registration fee");
        System.out.println(EXIT + ". Exit the application");
        System.out.print("\nEnter choice ==> ");

        String choice = inputMenuChoice.nextLine();

        while (choice.equals("") || !isStringNumeric(choice)) {
            System.out.println("Error - Menu selection cannot be blank and must be numeric");
            System.out.print("Enter choice ==> ");
            choice = inputMenuChoice.nextLine();
        }
        return Integer.parseInt(choice);
    }

    private boolean isStringNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidate(String input) {
        if (input.equalsIgnoreCase("S") || input.equalsIgnoreCase("K")) {
            return true;
        }
        if (input.equalsIgnoreCase("N")) {
            return true;
        }
        return false;
    }

    private void processOrders() {
        System.out.printf("\nWelcome to the Conference Registration System\n\n");

        int choice = getMenuItem();

        while (choice != EXIT) {
            switch (choice) {
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
                    System.out.println("ERROR choice not recognized");
            }

            choice = getMenuItem();
        }
        System.out.println("Thank you for using the Conference Registration System!");
        System.out.println("Program author: [Your Name]");
        System.out.println("Student ID: [Your Student ID]");
        System.out.println("Date: [Current Date]");
    }

    public void totalRegFee() {
        float totalFee = 0;

        for (Member member : memberList) {
            totalFee += member.getRegFee();
        }

        System.out.println("Total registration fee: $" + totalFee);
    }

    private void viewAllMembers() {
        if (memberList.isEmpty()) {
            System.out.println("No members found!");
        } else {
            for (Member member : memberList) {
                System.out.println(member.toString());
            }
        }
    }

    private void searchMember() {
        Scanner inText = new Scanner(System.in);
        String input;
        int memberID;

        do {
            System.out.printf("Please enter a member ID: ");

            input = inText.nextLine();

            if (input.equals("") || !isStringNumeric(input)) {
                System.out.printf("Error - Member ID cannot be blank and must be numeric\n");
            }
        } while (input.equals("") || !isStringNumeric(input));

        memberID = Integer.parseInt(input);

        int index = findMemberRecord(memberID);

        if (index > -1) {
            Member foundMember = memberList.get(index);
            System.out.println("Member found:");
            System.out.println(foundMember.toString());
        } else {
            System.out.println("No record found for the specified member ID.");
        }
    }

    private int findMemberRecord(int memberID) {
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getMemberID() == memberID) {
                return i;
            }
        }
        return -1;
    }

    private void enterMemberRecord() {
        Scanner inText = new Scanner(System.in);
        int memberID;
        String fullName;
        String university;
        String email;
        String phoneNumber;
        float regFee;
        float discount = 0.0F;
        String talk = "";
        String input;
        boolean isStudent = false;
        boolean isKeynote = false;

        // Enter memberID
        do {
            System.out.print("Please enter member ID (must be an integer): ");
            input = inText.nextLine();

            if (input.equals("") || !isStringNumeric(input)) {
                System.out.println("Error - Member ID must be a number and cannot be blank.");
            }
        } while (input.equals("") || !isStringNumeric(input));

        memberID = Integer.parseInt(input);

        int index = findMemberRecord(memberID);

        if (index > -1) {
            System.out.println("Member with this ID already exists.");
            return;
        }

        // Enter other details
        System.out.print("Please enter full name: ");
        fullName = inText.nextLine();
        System.out.print("Please enter university: ");
        university = inText.nextLine();
        System.out.print("Please enter email: ");
        email = inText.nextLine();
        System.out.print("Please enter phone number: ");
        phoneNumber = inText.nextLine();

        // Enter registration fee
        do {
            System.out.print("Please enter registration fee: ");
            input = inText.nextLine();

            if (input.equals("") || !isStringNumeric(input)) {
                System.out.println("Error - Registration fee must be a number and cannot be blank.");
            }
        } while (input.equals("") || !isStringNumeric(input));

        regFee = Float.parseFloat(input);

        // Ask member type
        do {
            System.out.print("Is this member a Student or a Keynote speaker? ('S' for student, 'K' for keynote speaker, 'N' for None of above): ");
            input = inText.nextLine();

            if (input.equals("") || !isValidate(input)) {
                System.out.println("Error - please select S, K, or N.");
            }
        } while (input.equals("") || !isValidate(input));

        if (input.equalsIgnoreCase("S")) {
            isStudent = true;
            do {
                System.out.print("Please enter student discount (%): ");
                input = inText.nextLine();

                if (input.equals("") || !isStringNumeric(input)) {
                    System.out.println("Error - Discount must be a number and cannot be blank.");
                }
            } while (input.equals("") || !isStringNumeric(input));

            discount = Float.parseFloat(input);
        } else if (input.equalsIgnoreCase("K")) {
            isKeynote = true;
            regFee = 0; // Keynote speakers have no registration fee
            System.out.print("Please enter talk title: ");
            talk = inText.nextLine();
        }

        // Construct and add the new member to the list
        Member newMember;

        if (isStudent) {
            newMember = new StudentMember(memberID, fullName, university, email, phoneNumber, regFee, discount);
        } else if (isKeynote) {
            newMember = new KeynoteSpeaker(memberID, fullName, university, email, phoneNumber, regFee, talk);
        } else {
            newMember = new FullMember(memberID, fullName, university, email, phoneNumber, regFee);
        }

        memberList.add(newMember);

        System.out.println("Member added successfully:");
        System.out.println(newMember.toString());
    }

    public static void main(String[] args) {
        ConferenceRegistration1 myApp = new ConferenceRegistration1();
        myApp.processOrders();
    }
}
