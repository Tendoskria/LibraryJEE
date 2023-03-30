package fr.univtours.polytech.bookmanager.model;

import java.io.Serializable;
import java.sql.Date;

public class MyKey implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Date startingDate;
	private Date endingDate;
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}
