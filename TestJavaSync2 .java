class Professor { // 공유자원 교수 클래스 
	String name; 
	Professor(String n) { name = n; } 

	synchronized void check_testpaper(Student s) { 
		s.end = System.currentTimeMillis();
		System.out.println(s.number+"번"+s.name+"가 시험본 시간은"+(s.end-s.begin)+"ms");
		if((s.end-s.begin)<=700)
			System.out.println(name+"교수가"+s.number+"번"+s.name+"의 시험지를 확인하고 접수했다");
		else 
			System.out.println(s.number+"번"+s.name+"의 시험지는 time over"); 
	}
} 

class Student extends Thread { 
	Professor prof;
	String name;
	int number; 
	long begin,end; 

 	Student(Professor p,String n,int no){ 
		prof = p;
		name = n; 
		number = no; 
	} 
	public void run() { 
		begin = System.currentTimeMillis(); // end가 없는 이유는 교수님이 시간 check 
		testJava(name,number); // n,no라고 매개변수 값을 주면 어떻게 되지? 
		prof.check_testpaper(this); // 교수 객체가 시험지를 check하는 것이니 prof.check~ 
		goHome(name,number);
	} 

	void testJava(String n,int no){ 
		System.out.println(no+"번"+n+"가 JAVA 시험을 보고있다"); 
		try {                         
			Thread.sleep((int)(Math.random()*1000)); } 
		catch(InterruptedException e) { } 
	} 
	void goHome(String n,int no){ 
		System.out.println(no+"번"+n+"가 집으로 돌아간다");
}
} 

public class TestJavaSync2 { 
	public static void main(String[] args){ 
		Professor p = new Professor("방탄소년단");
		Student s1 = new Student(p,"김별이",2020081001); 
		Student s2 = new Student(p,"이지은",2019081077);
		Student s3 = new Student(p,"유준서",2018081100);
		s1.start();
		s2.start();
		s3.start();
	} 
}

