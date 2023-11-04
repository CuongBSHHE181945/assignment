
import java.util.*;
import java.io.*;


public class BookList {
    
    Scanner sc = new Scanner(System.in);
    
    ArrayList<Book> t = new ArrayList();
    
    BookList() {        
    }
    
    void clear() {
        this.t.clear();
    }
    
    boolean isEmpty() {
        if (t.size()==0) {
            System.out.println("The list is empty!");
            return true;
        }
        return false;
    }
    
    int search (String code) {
        for (int i=0;i<t.size();i++) {
            if (code.compareTo(t.get(i).getCode())==0) return i;
        }
        return -1;
    }
    
    void input() {
        String xcode;
        
        while (true) {
            System.out.print("Enter code (=0 exit):");
            xcode = sc.nextLine().toUpperCase();

            if (xcode.trim().equals("0")) return;

            if (search(xcode)>0) System.out.println("The code is exist!");

            else {

            System.out.print("Enter title: ");
            String xtitle = sc.nextLine();
            System.out.print("Enter quantity: ");
            int xquantity = Integer.parseInt(sc.nextLine());
            System.out.print("Enter price: ");
            double xprice = Double.parseDouble(sc.nextLine());

            Book x = new Book(xcode, xtitle, xquantity, xprice);
            this.t.add(x);
            
            System.out.println("Added succesfully!");
            System.out.println();
            }
        }
    }
    
    void display() {
        for (int i=0;i<t.size();i++) {
            Book x = t.get(i);
            System.out.println(x);
        }
    }
    
    void update(String code, double price) {
        int pos = search(code);
        
        this.t.get(pos).setPrice(price);
    }
    
    int max() {
        int result=0;
        double max = this.t.get(0).getPrice();
        
        for (int i = 1;i<t.size();i++) {
            if (this.t.get(i).getPrice()>max) {
                max = this.t.get(i).getPrice();
                result=i;
            }
        }
        
        return result;
    }
    
    void sortByCode() {
        Collections.sort(t, Book.compareCode);
    }
    
    void remove(String code) {
        int pos=search(code);
        if (pos<0) {
            System.out.println("The code is not exist!");
            return;
        }
        this.t.remove(pos);
    }
    
    void loadFile(String fname) throws IOException{
        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);
        this.clear();
        
        while (true) {
            String s = br.readLine();
            if (s==null) 
                break;
            
            s=s.trim();
            if (s.length()<3)   
                break;
            
            String[] a = s.split("[|]");
            String xCode = a[0].trim();
            String xTitle = a[1].trim();
            int xQua = Integer.parseInt(a[2].trim());
            double xPrice = Double.parseDouble(a[3].trim());
            Book x = new Book(xCode, xTitle, xQua, xPrice);
            this.t.add(x);
        }
        
        fr.close();
        br.close();
    }
    
    void saveToFile(String fname) throws IOException {
      FileWriter fw = new FileWriter(fname);
      PrintWriter pw = new PrintWriter(fw);

      for(int i = 0; i < this.t.size(); ++i) {
         Book x = (Book)this.t.get(i);
         pw.printf("%s | %s | %d | %.1f\r\n", x.code, x.title, x.qua, x.price);
      }

      pw.close();
   }
}
