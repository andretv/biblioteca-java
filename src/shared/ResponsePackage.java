package shared;

import java.io.Serializable;
import java.util.ArrayList;

public class ResponsePackage implements Serializable {

	private String responseSlug;
	private String message;
	private ArrayList<Book> booksList;

	public String getResponseSlug() {
		return responseSlug;
	}

	public void setResponseSlug(String responseSlug) {
		this.responseSlug = responseSlug;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ArrayList<Book> getBooksList() {
		return booksList;
	}

	public void setBooksList(ArrayList<Book> booksList) {
		this.booksList = booksList;
	}

}
