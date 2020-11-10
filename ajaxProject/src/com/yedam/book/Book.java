package com.yedam.book;

public class Book {

	private String book_no;
	private String book_title;
	private String book_author;
	private String book_price;

	
	public String getBook_no() {
		return book_no;
	}
	
	public void setBook_no(String book_no) {
		this.book_no = book_no;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public String getBook_price() {
		return book_price;
	}
	public void setBook_price(String book_price) {
		this.book_price = book_price;
	}
	
	@Override
	public String toString() {
		return "Book [book_no=" + book_no + ", book_title=" + book_title + ", book_author=" + book_author + ", book_price=" + book_price + "]";
	}


}


