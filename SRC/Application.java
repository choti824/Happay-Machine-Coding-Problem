package SRC;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Application {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int option = 10;
        while (true) {
            printMenu();
            if (sc.hasNextInt()) {
                option = sc.nextInt();
                if (option == 9) {
                    break;
                }
                perform(option, sc);
            } else {
                System.out.println("Invalid Option");
                sc.next();
            }
        }
        sc.close();
    }

    public static void printMenu () {
        System.out.println("-------Select the option no. to perform the corresponding operation-------");
        System.out.println("0. addAnAuthor");
        System.out.println("1. addBookToCatalog");
        System.out.println("2. addCategory");
        System.out.println("3. getListOfCategories");
        System.out.println("4. getAllAuthorName");
        System.out.println("5. getMostBooksSoldByAuthor");
        System.out.println("6. getMostBooksSoldByCategory");
        System.out.println("7. searchBook");
        System.out.println("8. getBooksByAuthor");
        System.out.println("9. Exit");
    }

    public static int perform (int option, Scanner sc) {
        switch (option) {
            case 0:
                System.out.print("Please provide the following:\nAuthor ID, Author Name, Phone Number, Birth Date, Death Date\nProvide dates in dd/mm/yyyy format\n");
                try {
                    String aId = sc.next();
                    String aName = sc.next();
                    String phn = sc.next();
                    String bdate = sc.next();
                    String ddate = sc.next();
                    if (!validatePhoneNo(phn)) {
                        System.out.println("Invalid Phone Number");
                        break;
                    }
                    if (!validateDate(bdate)) {
                        System.out.println("Invalid Birth Date");
                        break;
                    }
                    if (!validateDate(ddate)) {
                        System.out.println("Invalid Death Date");
                        break;
                    }
                    if (bdate.equals("null") && ddate.equals("null")) {
                        if (!compareDates(bdate, ddate)) {
                            System.out.println("Invalid Birth/Death Date");
                        }
                        break;
                    }
                    Author newAuthor = new Author();
                    newAuthor.setAuthorId(aId);
                    newAuthor.setName(aName);
                    newAuthor.setBirthDate(bdate);
                    newAuthor.setDeathDate(ddate);
                    newAuthor.setPhoneNumber(phn);
                    System.out.println("-----OUTPUT-----");
                    AuthorRepository.addAnAuthor(newAuthor);
                } catch (Exception e) {
                    System.out.println("Invalid Arguments");
                }
                break;
        
            case 1:
                System.out.print("Please provide the following:\nBook ID, Title, Author ID, Publisher, Publish Date, Category ID, Price, Sold Count\nProvide dates in dd/mm/yyyy format\nPrice is an Integer\n");
                try {
                    String bId = sc.next();
                    String title = sc.next();
                    String aId = sc.next();
                    String publisher = sc.next();
                    String pdate = sc.next();
                    String cId = sc.next();
                    String price = sc.next();
                    String sCount = sc.next();
                    if (!validateDate(pdate)) {
                        System.out.println("Invalid Publish Date");
                        break;
                    }
                    if (!validateInt(price)) {
                        System.out.println("Invalid Price");
                        break;
                    }
                    if (!validateInt(sCount)) {
                        System.out.println("Invalid Sold Count");
                        break;
                    } 
                    Book newBook = new Book();
                    newBook.setBookId(bId);
                    newBook.setTitle(title);
                    newBook.setAuthorId(aId);
                    newBook.setPublisher(publisher);
                    newBook.setPublishedDate(pdate);
                    newBook.setCategoryId(cId);
                    newBook.setPrice(Integer.valueOf(price));
                    newBook.setSoldCount(Integer.valueOf(sCount));
                    System.out.println("-----OUTPUT-----");
                    BookRepository.addBookToCatalog(newBook);
                } catch (Exception e) {
                    System.out.println("Invalid Arguments");
                }
                break;

            case 2:
                System.out.print("Please provide the following:\nCategory ID, Category Name\n");
                try {
                    String cId = sc.next();
                    String cName = sc.next();
                    System.out.println("-----OUTPUT-----");
                    CategoryRepository.addCategory(cId, cName);
                } catch (Exception e) {
                    System.out.println("Invalid Arguments");
                }
                break;

            case 3:
                System.out.println("-----OUTPUT-----");
                CategoryRepository.getListOfCategories();
                break;

            case 4:
                System.out.println("-----OUTPUT-----");
                AuthorRepository.getAllAuthorName();
                break;

            case 5:
                System.out.print("Please provide the following:\nAuthor ID\n");
                try {
                    String aId = sc.next();
                    System.out.println("-----OUTPUT-----");
                    BookRepository.getMostBooksSoldByAuthor(aId);
                } catch (Exception e) {
                    System.out.println("Invalid Arguments");
                }
                break;

            case 6:
                System.out.print("Please provide the following:\nCategory ID\n");
                try {
                    String cId = sc.next();
                    System.out.println("-----OUTPUT-----");
                    BookRepository.getMostBooksSoldByCategory(cId);
                } catch (Exception e) {
                    System.out.println("Invalid Arguments");
                }
                break;

            case 7:
                System.out.print("Please enter the full/partial Book Title or Author Name\n");
                try {
                    String searchStr = sc.next();
                    System.out.println("-----OUTPUT-----");
                    BookRepository.getBooksBySearch(searchStr);
                } catch (Exception e) {
                    System.out.println("Invalid Arguments");
                }
                break;

            case 8:
                System.out.print("Please provide the following:\nAuthor ID\n");
                try {
                    String aId = sc.next();
                    System.out.println("-----OUTPUT-----");
                    BookRepository.getBooksByAuthor(aId);
                } catch (Exception e) {
                    System.out.println("Invalid Arguments");
                }
                break;
            
            default:
                System.out.println("Invalid Option\nPlease choose any number from 0 to 9\n");
                break;
        }
        return option;
    }

    private static boolean validatePhoneNo (String phn) {
        if (phn.equals("null")) {
            return true;
        }
        try {
            Integer.valueOf(phn);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean validateInt (String n) {
        try {
            Integer.valueOf(n);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean validateDate (String date) {
        if (date.equals("null")) {
            return true;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatter.setLenient(false);
        try {
            Date dt = formatter.parse(date);
            Date today = new Date(); 
            if (dt.after(today)) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean compareDates (String date1, String date2) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatter.setLenient(false);
        Date dt1 = formatter.parse(date1);
        Date dt2 = formatter.parse(date1);
        if (dt1.after(dt2)) {
            return false;
        }
        return true;
    }
}