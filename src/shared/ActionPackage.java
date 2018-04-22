package shared;

import java.io.Serializable;

public class ActionPackage implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private User user;
	private Book book;
	private String action;
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	
}
