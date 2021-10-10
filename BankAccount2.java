class Account { 
	private int total_money=0;  // private가 아니라 클래스형 변수로 정의한다면? 
	synchronized void deposit(String name,int money) {  // 입금하다 
		total_money+=money; 
		System.out.println(name+"이"+money+"입금하여 잔액은"+total_money+"원"); 
	} 
	synchronized void withdrawal(String name,int money) { // 출금하다
		total_money-=money; 
		System.out.println(name+"이"+money+"출금하여 잔액은"+total_money+"원");
	} 
}

class Man extends Thread { 
	Account account; 
	Man(Account act,String name){ 
		super(name);
		account=act; 	
	} 
	public void run() { 
		for(int i=0;i<5;i++){ 
			account.deposit(getName(),1000); 
			account.withdrawal(getName(),100); 
	}
} 
}

public class BankAccount2 { 
	public static void main(String[] args) { 
		Account tongjang = new Account();
		Man m1 = new Man(tongjang,"첫번째 사람");
		Man m2 = new Man(tongjang,"두번째 사람");
		Man m3 = new Man(tongjang,"세번째 사람"); 
		m1.start();
		m2.start();
		m3.start();
	}
}
