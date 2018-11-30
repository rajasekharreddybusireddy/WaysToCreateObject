package demo;

import java.io.Serializable;

public class Employee implements Cloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected Employee clone() throws CloneNotSupportedException {
		return (Employee) super.clone();
	}

	String name;

	public Employee() {
		System.out.println("Employee constructor");
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
