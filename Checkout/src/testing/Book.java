package testing;

public class Book {
	private String bookID;
	private String bookTitle;
	private int bookQuantity;
	private double bookPrice;
	private String bookType;
	
	public Book(String bookID, String bookTitle, int bookQuantity, double bookPrice, String bookType) {
		this.bookID = bookID;
		this.bookTitle = bookTitle;
		this.bookQuantity = bookQuantity;
		this.bookPrice = bookPrice;
		this.bookType = bookType;
		
	}
	
	public String addBook() {
		if(!isValidID(bookID)) {
			return "The book information cannot be added due to invalid ID.";
		}
		if (!isValidTitle(bookTitle)) {
	            return "The book information cannot be added due to invalid title.";
	     }
		if (!isValidPrice(bookPrice, bookType)) {
            return "The book information cannot be added due to invalid price.";
        }
		
		 return "The book information can be added.";
	}

	private boolean isValidID(String id) {
		
		return id.length() == 5 && Character.isDigit(id.charAt(0));
	}
	
	private boolean isValidTitle(String title) {
		 String[] words = title.split(" ");
	     return words.length >= 2 && words.length <= 4;
	}
	
	private boolean isValidPrice (double price, String type) {
		if(price <= 5 || price >= 250) {
			return false;
		} if(type.equalsIgnoreCase("Kids") && price > 40) {
			return false;
		}
		return true;
		}
}

