class Bank_Money {
	String name;
	Bank_Money (String n){ name = n; }
	synchronized void Money_sum(int money, String name) {
		for ( int i = 0 ; i < 5 ; i++ ){
			money = money + 1000;
			System.out.println( name + "�� 1000�� �Ա��Ͽ� �ܾ��� " + money );
			money = money - 100;
			System.out.println( name + "�� 100�� ����Ͽ� �ܾ��� " + money );
		}
	}
}


public class BankAccount{
	public static void main(String[] args){
		RunnableThread r = new RunnableThread("ù��° ���");
		Thread t = new Thread(r);
		RunnableThread r2 = new RunnableThread("�ι�° ���");
		Thread t2 = new Thread(r2);
		RunnableThread r3 = new RunnableThread("����° ���");
		Thread t3 = new Thread(r3);
		t.start();
		t2.start();
		t3.start();
	}
}