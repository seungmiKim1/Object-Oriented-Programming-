class ThreadA extends Thread { 
	public static int num = 0;
	public ThreadA (String name) { 
		super(name); 
	} 
	public void run() { 
		for(int i=0; i<10; i++)
			System.out.println(num++ +":"+getName()); 
	}
  } 

public class TestMultiThread { 
	public static void main(String[] args){ 
		ThreadA t1 = new ThreadA("첫번째 쓰레드");
		ThreadA t2 = new ThreadA("두번째 쓰레드"); 
		t1.start();
		t2.start(); 
	}
 }
