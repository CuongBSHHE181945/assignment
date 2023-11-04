import java.util.*;
import java.io.*;
class Main {
 public static void main(String args[]) throws IOException {
    int choice,i; Book x; String xCode; double xPrice;
    Scanner sc = new Scanner(System.in);
    BookList u = new BookList();
    String fname;
    while(true){
      System.out.println();
      System.out.println("1. Input & add book(s) to the end.");
      System.out.println("2. Display all books.");
      System.out.println("3. Search a book for given code.");
      System.out.println("4. Update the book's price for given code.");
      System.out.println("5. Find the (first) max price value.");
      System.out.println("6. Sort the list ascendingly by code.");
      System.out.println("7. Remove the book having given code.");
      System.out.println("8. Load data from file.");
      System.out.println("0. Exit ");
      System.out.print("   Your selection (0 -> 8): ");
      choice = sc.nextInt(); sc.nextLine();
      if(choice==0) break;
      switch(choice){
        case 1: u.input();
                u.saveToFile("book.txt");
                break;
        case 2: if(u.isEmpty()) break;
                u.display();
                break;
        case 3: if(u.isEmpty()) break;
                System.out.print("Enter code:");
                xCode = sc.nextLine().toUpperCase();
                i = u.search(xCode);
                if(i==-1)
                  System.out.println("Not found.");
                else {
                  System.out.println("Found at the position " + (i+1));
                  System.out.println(u.t.get(i));
                }
                break;
        case 4: if(u.isEmpty()) break;
                System.out.print("Enter code: ");
                xCode = sc.nextLine().toUpperCase();
                
                i = u.search(xCode);
                if(i==-1) {
                  System.out.println("Not found.");
                  break;
                }
                System.out.print("Enter new price: ");
                xPrice = sc.nextDouble();
                u.update(xCode, xPrice);
                u.display();
                break;
        case 5: if(u.isEmpty()) break;
                i = u.max();
                System.out.println("Max is at the position " + i);
                System.out.println(u.t.get(i));
                break;
        case 6: if(u.isEmpty()) break;
                u.sortByCode();
                u.display();
                break;
        case 7: if (u.isEmpty()) break;
                System.out.print("Enter code: ");
                xCode = sc.nextLine().toUpperCase();
                if (u.search(xCode)<0) {
                    System.out.println("The code doesn't exist!");
                    System.out.println("The list:");
                    u.display();
                    break;
                }
                System.out.println("List before removing:");
                u.display();
                u.remove(xCode);
                System.out.println("List after removing:");
                u.display();
                u.saveToFile("book.txt");
                break;
        case 8: System.out.print("Enter file name (b = book.txt): ");
                fname = sc.nextLine();
                if(fname.trim().equalsIgnoreCase("b")) 
                    fname = "book.txt";
                u.loadFile(fname);
                System.out.println("Loaded!");
                break;
        default:
            System.out.print("Wrong selection!");
       }
     }      
    System.out.println();
   }
 }
