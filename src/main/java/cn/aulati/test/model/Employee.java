package cn.aulati.test.model;


import java.util.Objects;

/**
 * Employee class.
 * <p>extends from the {@link Person} class.
 * 
 * @author Aulati
 *
 */
public class Employee extends Person {

	/** Name of the base class. */
	private static String _baseClassName = "cn.aulati.test.model.Person";
	
	/** Date of entering the company. Format:yyyyMMdd */
	private String _dateOfEntry;

	/** age of entry this company. */
	private int _age;

	/**
	 * Get the dateOfEntry
	 * @return dateOfEntry
	 */
	public String getDateOfEntry() {
		return _dateOfEntry;
	}

	/**
	 * Set the dateOfEntry.
	 * @param dateOfEntry the dateOfEntry to set.
	 */
	public void setDateOfEntry(String dateOfEntry) {
		_dateOfEntry = dateOfEntry;
	}

	/**
	 * Get the age
	 * @return age
	 */
	@Override
	public int getAge() {
		return _age;
	}

	/**
	 * Set the age.
	 * @param age the age to set.
	 */
	public void setAge(int age) {
		_age = age;
	}

	/**
	 * Get the baseClassName
	 * @return baseClassName
	 */
	public static String getbaseClassName() {
		return _baseClassName;
	}

	/**
	 * Set the baseClassName.
	 * @param baseClassName the baseClassName to set.
	 */
	public static void setbaseClassName(String baseClassName) {
		_baseClassName = baseClassName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return _age == employee._age &&
				Objects.equals(_dateOfEntry, employee._dateOfEntry);
	}

	@Override
	public int hashCode() {
		return Objects.hash(_dateOfEntry, _age);
	}
}
