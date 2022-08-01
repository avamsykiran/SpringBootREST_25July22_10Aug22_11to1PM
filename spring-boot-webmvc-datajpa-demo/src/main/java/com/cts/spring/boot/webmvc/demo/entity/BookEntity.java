package com.cts.spring.boot.webmvc.demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookCode;
	private String title;
	private Double price;
	private LocalDate publishDate;
	
	public BookEntity() {
		// TODO Auto-generated constructor stub
	}

	public BookEntity(Long bookCode, String title, Double price, LocalDate publishDate) {
		super();
		this.bookCode = bookCode;
		this.title = title;
		this.price = price;
		this.publishDate = publishDate;
	}

	public Long getBookCode() {
		return bookCode;
	}

	public void setBookCode(Long bookCode) {
		this.bookCode = bookCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	@Override
	public String toString() {
		return "Book [bookCode=" + bookCode + ", title=" + title + ", price=" + price + ", publishDate=" + publishDate
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookCode == null) ? 0 : bookCode.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((publishDate == null) ? 0 : publishDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookEntity other = (BookEntity) obj;
		if (bookCode == null) {
			if (other.bookCode != null)
				return false;
		} else if (!bookCode.equals(other.bookCode))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (publishDate == null) {
			if (other.publishDate != null)
				return false;
		} else if (!publishDate.equals(other.publishDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
}
