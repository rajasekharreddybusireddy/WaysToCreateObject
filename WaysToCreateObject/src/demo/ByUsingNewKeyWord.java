package demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ByUsingNewKeyWord {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, ClassNotFoundException {

	         byUsingNewOperator();

		System.out.println("----------------------------------------------------------------------------------");

		byUsingClassForName();

		System.out.println("--------------------------------------------------------------------");

		byUsingConstructorClassNewInstance();

		System.out.println("--------------------------------------------------------------------------------------");
		byUsingClone();

		System.out.println(
				"---------------------------------------------------------------------------------------------");
		byUsingDeserilization();

	}

	private static void byUsingDeserilization() throws FileNotFoundException, IOException, ClassNotFoundException {
		Employee employee2 = new Employee();
		employee2.name = "serilization";
		FileOutputStream fileOutputStream = new FileOutputStream("employee.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(employee2);

		FileInputStream fileInputStream = new FileInputStream("employee.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		Object readObject = objectInputStream.readObject();

		Employee e5 = (Employee) readObject;

		System.out.println(e5.hashCode());
		System.out.println(e5.name);
	}

	private static void byUsingClone() {
		try {
			Employee employee = new Employee();
			Employee clone = employee.clone();
			clone.name = "iamclone";
			System.out.println(clone.hashCode());
			System.out.println(clone.name);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void byUsingConstructorClassNewInstance() {
		try {
			Constructor<Employee> constructor = Employee.class.getConstructor();
			Employee employee2 = constructor.newInstance();
			employee2.name = "3rdway";
			System.out.println(employee2.hashCode());
			System.out.println(employee2.name);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void byUsingClassForName() {
		try {
			// Object object = Class.forName("demo.Employee").newInstance();
			Employee object = Employee.class.newInstance();
			Employee e3 = (Employee) object;
			e3.name = "reddy";
			System.out.println(e3.hashCode());
			System.out.println(e3.name);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private static void byUsingNewOperator() {
		// creating object for employee class
		Employee employee = new Employee();

		// initlizing employee class variable
		employee.name = "rajasekhar";

		// printing employee class
		System.out.println(employee.hashCode());
		System.out.println(employee.name);
	}

}
