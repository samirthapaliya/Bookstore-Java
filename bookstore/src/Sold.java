
public class Sold {
    String book_name, publisher_name, sold_date;
    int id, quantity;
    
    Sold(int id, String book_name, String publisher_name, String sold_date, int quantity) {
        this.id = id;
        this.book_name = book_name;
        this.publisher_name = publisher_name;
        this.sold_date = sold_date;
        this.quantity = quantity;
    }
}