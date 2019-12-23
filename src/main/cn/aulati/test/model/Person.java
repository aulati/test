package cn.aulati.test.model;

import java.util.Date;

/**
 * A person class.
 * @author Aulati
 *
 */
public class Person {

	/** First name of this Person. */
	private String _firstName;

	/** Last name of this Person. */
	private String _lastName;

	/** Birthday of this employee. */
	private Date _birthday;

	/** Age of this employee. */
	private int _age;

	/**
	 * first name + <i>SPACE</i> + last name.
	 */
	public String toString() {
		if (_lastName.length() == 0) {
			return _firstName;
		} else if (_firstName.length() == 0) {
			return _lastName;
		} else {
			return _firstName + " " + _lastName;
		}
	}

	/**
	 * compare two {@link Person} instance by comparing the next fields
	 * sequentially: <br>
	 * First Name<br>
	 * Last Name
	 * 
	 * @param per2
	 *            another {@code Person} to compare with.
	 * @return the value 0 if the argument Person is equal to this one; a
	 *         value less than 0 if this Person is lexicographically less than
	 *         the Person argument; and a value greater than 0 if this
	 *         Person is lexicographically greater than the Person argument.
	 */
	public int compareTo(Person per2) {
		int rst = -1;

		if (per2 == null) {
			return rst;
		}

		rst = _firstName.compareTo(per2._firstName);

		if (rst == 0) {
			return _lastName.compareTo(per2._lastName);
		}

		return rst;
	}

	/**
	 * Get the first name.
	 * 
	 * @return first name
	 */
	public String getFirstName() {
		return _firstName;
	}

	/**
	 * Set the first name.
	 * 
	 * @param firstName
	 *            the first name to set.
	 */
	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	/**
	 * Get the last name.
	 * 
	 * @return the last name
	 */
	public String getLastName() {
		return _lastName;
	}

	/**
	 * Set the first name.
	 * 
	 * @param lastName
	 *            lastName
	 */
	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	/**
	 * 
	 * @return birthday
	 */
	public Date getBirthday() {
		return _birthday;
	}

	/**
	 * 
	 * @param birthday
	 *            birthday
	 */
	public void setBirthday(Date birthday) {
		_birthday = birthday;
	}

	/**
	 * 
	 * @return age
	 */
	public int getAge() {
		return _age;
	}

	/**
	 * 
	 * @param age
	 *            age
	 */
	public void setAge(int age) {
		_age = age;
	}
}
