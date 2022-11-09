
public class Book {
	
	String book_name, publisher_name, publish_date;
    int book_id, price, stock;
    
    Book( int book_id, String book_name, String publisher_name, String publish_date, int price, int stock) {
        
    	this.book_id = book_id;
        this.book_name = book_name;
        this.publisher_name = publisher_name;
        this.publish_date = publish_date;
        this.price = price;
        this.stock = stock;
    }

}
