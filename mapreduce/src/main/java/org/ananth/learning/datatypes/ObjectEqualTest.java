package org.ananth.learning.datatypes;

import java.util.Arrays;
import java.util.List;

import org.ananth.learning.exception.NullDataException;
import org.ananth.learning.util.KeySortBuilder;

public class ObjectEqualTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*Person person = new Person("Ananth", "Durai");
		Person person1 = new Person("Ananth", "Dura");
		
		System.out.println(person.equals(person1)); */
		
	/*	String key = new KeySortBuilder()
										.setFirst("xerox")
										.setSecond("Ananth")
										.build();
		
		
		System.out.println(key); */
		
		combinationTest();

	}
	
	
	
	private static void combinationTest() {
		
		String friends = "1 0,2,5,4,3";
		
		String keyFriend = friends.split(" ")[0];
		List<String> friendsList = Arrays.asList(friends.split(" ")[1].split(","));		
		System.out.println(keyFriend);
		System.out.println(friendsList);
		
		for(String s : friendsList) {
			System.out.println(keyFriend + "-" + s);
		}
		
		
		for(String parent : friendsList) {
			
			for(String child : friendsList) {
				if( parent != child) {
					System.out.println(parent + "-" + child);
				}
				
			}
			
			
		}
		
	}
  
}



   
class Person {
	
	private String firstname;
	private String lastname;
	
	
	public Person(final String firstname, final String lastname) {
		
		if(firstname == null) throw new NullDataException("firstname");
		
		if(lastname == null) throw new NullDataException("lastname");
		
		this.firstname = firstname;
		this.lastname = lastname;
		
		
	}
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result
				+ ((lastname == null) ? 0 : lastname.hashCode());
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
		Person other = (Person) obj;
		boolean isFirstMatch = Boolean.FALSE;
		boolean isSecondMatch = Boolean.FALSE;
		if(this.firstname.equals(other.firstname) || this.firstname.equals(other.lastname)) {
			isFirstMatch = Boolean.TRUE;
		}
		if(this.lastname.equals(other.firstname) || this.lastname.equals(other.lastname)) {
			isSecondMatch = Boolean.TRUE;
		}
		
		if(isFirstMatch && isSecondMatch) { return Boolean.TRUE; }
		return Boolean.FALSE;
		
	/*	if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true; */
	}
	
	
	
	
	
	
}
