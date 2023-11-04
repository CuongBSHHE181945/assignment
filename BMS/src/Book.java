
import java.util.Comparator;



public class Book {
    public String code;
    public String title;
    public int qua;
    public double price;

    public Book() {
    }

    public Book(String code, String title, int qua, double price) {
        this.code = code;
        this.title = title;
        this.qua = qua;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQua() {
        return qua;
    }

    public void setQua(int qua) {
        this.qua = qua;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book:" + "code=" + code + "| title=" + title + "| qua=" + qua + "| price=" + price;
    }
    
    public static Comparator compareCode = new Comparator() {
        @Override
        public int compare(Object x, Object y) {
            Book b1 = (Book)x;
            Book b2 = (Book)y;
            return b1.code.compareTo(b2.code);
        }
    };
}
