package com.chetan.javaPractice;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MobilePhone {

    static ArrayList<Contacts> contactsList = new ArrayList<Contacts>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //MobilePhone mobilePhone = new MobilePhone();


        while (true) {
                MobilePhone.menu();
                try {
                System.out.println("Enter Your Choice");
                int choice = sc.nextInt();
                String name = new String();
                Long phoneNumber = new Long(0);
                sc.useDelimiter("\n");

                switch (choice) {
                    case 1: {
                        MobilePhone.menu();
                        break;
                    }

                    case 2: {
                        System.out.println("Enter Contact Name");
                        name = sc.next();
                        System.out.println("Enter Phone Number");
                        phoneNumber = sc.nextLong();
                        MobilePhone.addContact(name, phoneNumber);
                        break;
                    }

                    case 3: {
                        System.out.println("Enter Contact Name which need to deleted");
                        name = sc.next();
                        MobilePhone.removeContact(name);
                        break;
                    }

                    case 4: {
                        System.out.println("Enter Contact Name which need be updated");
                        name = sc.next();
                        System.out.println("Enter Contact Number which need to be updated");
                        phoneNumber = sc.nextLong();
                        MobilePhone.updateContact(name, phoneNumber);
                        break;
                    }

                    case 5: {
                        System.out.println("Enter Contact Name which need to be searched");
                        name = sc.next();
                        int position = MobilePhone.searchContact(name);
                        if (MobilePhone.searchContact(name) >= 0) {
                            System.out.println("Contact is preasent");
                            System.out.println("mobile number for " + name + "is :" + contactsList.get(position).getMobNUmber());
                        }
                        break;
                    }

                    case 6: {
                        int position = 1;
                        for (Contacts c : contactsList) {
                            System.out.println(position + " : \n contact name : " + c.getName() + "\n Phone Number : " + c.getMobNUmber());
                            position++;
                        }
                        break;
                    }

                    case 0: {
                        System.exit(0);
                    }
                }
            } catch (InputMismatchException e) {
                //System.out.println(e);
                //continue;
            }

            System.out.println(" Please enter appropriate input value. Try again from operation selection...!");
        }

    }

    public static void menu() {
        System.out.println("==========================================================");
        System.out.println("Please select option");
        System.out.println("1 : Menu");
        System.out.println("2 : Add New Contact");
        System.out.println("3 : Remove/Delete Contact");
        System.out.println("4 : Update/Modify Existing Contact");
        System.out.println("5 : Search/Find Contact");
        System.out.println("6 : Print List of Contact");
        System.out.println("0 : Quit the program");
        System.out.println("==========================================================");

    }

    public static int searchContact(String name) {
        int position = 0;
        for (Contacts c : contactsList) {
            if (c.getName().equalsIgnoreCase(name)) {
                return position;
            }
            position++;
        }
        return -1;
    }

    public static void addContact(String name, Long phoneNumber) {
        Contacts c = new Contacts(name, phoneNumber);
        if (searchContact(name) >= 0) {
            System.out.println("Contact with " + name + " is already present in Contact List. " +
                    "If you want to modify existing contact details please go for option \n" +
                    " 4 : Update/Modify Existing Contact ");
        } else {
            contactsList.add(c);
        }
    }

    public static void updateContact(String name, Long phoneNumber) {
        Contacts c = new Contacts(name, phoneNumber);
        int position = searchContact(name);
        if (position < 0) {
            System.out.println("Contact with " + name + " is not present in Contact List. So can not be updated.");
        } else {
            contactsList.set(position, c);
        }
    }

    public static void removeContact(String name) {
        int position = searchContact(name);
        if (position < 0) {
            System.out.println("Contact with " + name + " is not present in Contact List.");
        } else {
            contactsList.remove(position);
        }
    }

}

class Contacts {
    private String name;

    public Long getMobNUmber() {
        return mobNUmber;
    }

    private Long mobNUmber;

    public String getName() {
        return name;
    }

    public Contacts(String name, Long mobNUmber) {
        this.name = name;
        this.mobNUmber = mobNUmber;
    }
}
