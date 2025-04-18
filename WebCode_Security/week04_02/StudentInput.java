package prac4_2;

import java.util.*;

public class StudentInput {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("학생 정보를 입력하세요: ");
		String sid = sc.next();
		String name = sc.next();
		String major = sc.next();

		Student s = new Student(sid, name, major);
		System.out.println("생성된 학생 객체의 정보입니다.");
		System.out.println(s);
		
		System.out.print("\n정보를 저장할 파일 이름을 입력하세요: ");
		String fname = sc.next();
		
		if(Student.writeObject(fname, s)) {
			System.out.println("파일 저장 완료");
		}else {
			System.out.println("파일 저장 실패");
		}
		
		System.out.println("프로그램을 종료합니다.");
	}
}
