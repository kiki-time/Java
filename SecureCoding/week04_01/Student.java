package prac4_1;

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Student {
	// Filewriter, PrintWriter
	// FileReader, Scanner로 입력

	private String sid;
	private String name;
	private String major;

	public Student(String sid, String name, String major) {
		this.sid = sid;
		this.name = name;
		this.major = major;

	}

	public static Student readFromFile(String fname) {
		try (Scanner sc = new Scanner(new File(fname))) {
			if (sc.hasNext()) {
				String sid = sc.next();
				String name = sc.next();
				String major = sc.next();
				return new Student(sid, name, major);
			}
		} catch (IOException e) {
			System.err.println("파일 읽기 오류: " + e.getMessage());
		}
		return null;
	}

	public boolean writeToFile(String fname) {
		try (PrintWriter pw = new PrintWriter(fname)) {
			pw.println(sid + " " + name + " " + major);
			return true;
		} catch (IOException e) {
			System.err.println("파일 쓰기 오류" + e.getMessage());
			return false;
		}
	}
	@Override
	public String toString() {
		return "Student[" + name + ", " + sid + ", " + major + "]";
	}
}
