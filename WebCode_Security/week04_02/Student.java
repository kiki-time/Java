package prac4_2;

import java.io.*;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	private String sid;
	private String name;
	private String major;

	public Student(String sid, String name, String major) {
		this.sid = sid;
		this.name = name;
		this.major = major;
	}

	public static Student readObject(String fname) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fname))){
			return (Student) ois.readObject();
		}catch(IOException e) {
			System.err.println("파일 읽기 오류");
			return null;
		}catch(ClassNotFoundException e) {
			System.err.println("파일 읽기 오류");
			return null;
		}
	}
	
	public static boolean writeObject(String fname, Student s) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname))){
			oos.writeObject(s);
			return true;
		}catch (IOException e) {
			System.err.println("파일 쓰기 오류");
			return false;
		}
		
	}
	@Override
	public String toString() {
		return "Student[" + name + ", " + sid + ", " + major + "]";
	}
}
