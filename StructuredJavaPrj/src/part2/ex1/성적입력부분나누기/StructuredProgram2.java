package part2.ex1.성적입력부분나누기;

import java.util.Scanner;

public class StructuredProgram2{
	
	
	
	// 메인 함수
    public static void main(String[] args) {
    	int[] korList = new int[3];	//지역화시켜서 다른곳에서 문제가 발생되지 않도록 하는게 좋음.
    	
        int menu;
        boolean keepLoop = true;			
        
		
		while(keepLoop)
		{
			menu = inputMenu();
	        
	        switch(menu) {	        
	        case 1:
	        	
	        	inputKors(korList);	// 참조만 넘긴것일 뿐. 함수에서 이름 변경 가능
	        	       
		        break;
	        case 2:
		        
	        	printKors(korList);
	        	
		        break;
	        case 3:
	        	System.out.println("Bye~~");
	        	
	        	keepLoop = false;
				break;
	        
	        default:
	        	System.out.println("잘못된 값을 입력하셨습니다. 메뉴는 1~3까지입니다.");
	       
	        }
	        
		}
    }		// 메인함수 끝나는 영역
    
    static int inputMenu() {
		Scanner scan = new Scanner(System.in);
		
    	System.out.println("┌───────────────────────────┐");
        System.out.println("│           메인 메뉴                   │");
        System.out.println("└───────────────────────────┘");
        System.out.println("\t1. 성적입력 ");
        System.out.println("\t2. 성적출력 ");
        System.out.println("\t3. 종료 ");
        System.out.println("\t선택> ");
        int menu = scan.nextInt();
        
        return menu;
    }
    
    
    static void printKors(int[] kors) {	//해방감. 외부의 영향 X 매개변수란?
        int total = 0;
        float avg;
    	
    	 for(int i=0; i<3; i++)
	        	total += kors[i];
	        
	        avg = total / 3.0f;
	        
	        System.out.println("┌───────────────────────────┐");
	        System.out.println("│           성적  출력                   │");
	        System.out.println("└───────────────────────────┘");
	        System.out.println();		        
	       
	        for(int i=0;i<3;i++)
	        	System.out.printf("국어 %d : %3d\n", 3-i, kors[i]);	        	
	        	        
	        System.out.printf("총점 : %3d\n", total);
	        System.out.printf("평균 : %6.2f\n", avg);
	        System.out.println("─────────────────────────────");
    }
    
    
    static void inputKors(int[] kors) {

    	Scanner scan = new Scanner(System.in);
    	int kor;	// 지역변수
    	
		System.out.println("┌───────────────────────────┐");
        System.out.println("│           성적  입력                   │");
        System.out.println("└───────────────────────────┘");
        System.out.println();
       		        
        for(int i=0; i<3; i++)
	        do {
		        System.out.printf("국어%d : ", i+1);
		        kor = scan.nextInt();	// kor이라는 지역변수를 사용 (코드를 간결화)
	        
		        if(kor < 0 || 100 < kor)
		        	System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");
		        
	        }while(kor < 0 || 100 < kor);
        
        System.out.println("─────────────────────────────");
    	
    }
    
    
}

