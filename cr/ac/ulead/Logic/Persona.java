package cr.ac.ulead.Logic;

import java.util.Date;

public class Persona {
	String name;
	String lastname;
	Date DateOfBirht;
	String ID;

	@Override
	public String toString() {
		return "Persona [name=" + name + ", lastname=" + lastname + ", DateOfBirst=" + DateOfBirht + ", ID=" + ID + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDateOfBirst() {
		return DateOfBirht;
	}

	public void setDateOfBirst(Date date) {
		DateOfBirht = date;
	}

	public String getID() {
		return ID;
	}

	public void setID(String datos) {
		ID = datos;
	}

}
