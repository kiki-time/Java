package prac4_2;

import java.util.*;

public class StudentOutput {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.print("정보를 읽어올 파일 이름을 입력하세요: ");
		String fname = sc.next();
		
		Student s = Student.readObject(fname);
		if(s!= null) {
			System.out.println("\n생성된 학생 객체의 정보입니다.");
			System.out.println(s);
		}else {
			System.out.println("생성 실패");
		}
				
	}
}
