package shared;

import java.io.Serializable;

public class Book implements Serializable {

	private int id;
	private String title;
	private int year;
	private int customerId;
	
	public Book(int id, String title, int year) {
		this.id = id;
		this.title = title;
		this.year = year;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int userId) {
		this.customerId = userId;
	}
	
}
