package prac10_2;

import java.util.Scanner;

import prac10_2.Date;
import prac10_2.Diary;

public class DeepCloning {

	public static void main(String[] args)throws CloneNotSupportedException {

		Scanner sc = new Scanner(System.in);
		int target, index;
		
		Date[] dates = { 
				new Date(2019, 5, 13), 
				new Date(2000, 1, 1), 
				new Date(1988,12,25)};
		
		Diary d1 = new Diary(dates);
		Diary d2 = (Diary) d1.clone();
		
		System.out.println("Original Array:\n" + d1);
		System.out.println("Cloned Array:\n"+d2);
		System.out.println();

		while(true) {
			System.out.print("변경하고 싶은 배열을 선택하세요 (1-original/2-cloned): ");
			target = sc.nextInt();
			if(target == 1 || target == 2) {
				break;
			} else {
				System.out.println("다시 선택하세요.");
			}

		}
		while(true) {
			System.out.print("변경하고 싶은 날짜의 인덱스를 입력하세요: ");
			index = sc.nextInt();
			if(index == 0 || index == 1 || index == 2) {
				break;
			}else {
				System.out.println("다시 선택하세요.");
			}
		}
		System.out.print("년도: ");
		int y = sc.nextInt();
		System.out.print("월: ");
		int m = sc.nextInt();
		System.out.print("일: ");
		int d = sc.nextInt();
		
		if(target == 1) {
			d1.getListOfDates()[index] = new Date(y, m, d);
		}else {
			d2.getListOfDates()[index] = new Date(y, m, d);
		}
		
		System.out.println();
		System.out.println("Original Array:\n" + d1);
		System.out.println("Cloned Array:\n"+d2);
	}

}
