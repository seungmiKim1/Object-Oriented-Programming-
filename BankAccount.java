class Bank_Money {
	String name;
	Bank_Money (String n){ name = n; }
	synchronized void Money_sum(int money, String name) {
		for ( int i = 0 ; i < 5 ; i++ ){
			money = money + 1000;
			System.out.println( name + "이 1000원 입금하여 잔액은 " + money );
			money = money - 100;
			System.out.println( name + "이 100원 출금하여 잔액은 " + money );
		}
	}
}


public class BankAccount{
	public static void main(String[] args){
		RunnableThread r = new RunnableThread("첫번째 사람");
		Thread t = new Thread(r);
		RunnableThread r2 = new RunnableThread("두번째 사람");
		Thread t2 = new Thread(r2);
		RunnableThread r3 = new RunnableThread("세번째 사람");
		Thread t3 = new Thread(r3);
		t.start();
		t2.start();
		t3.start();
	}
}