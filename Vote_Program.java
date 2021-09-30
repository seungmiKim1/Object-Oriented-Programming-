class Vote_Place { //�����ڿ� - ��ǥ�� Ŭ����
String place_name; // ��ǥ�� �̸�
	Vote_Place (String n ) { place_name = n; }
	synchronized void check_id ( String no, String name ) { // ����ȭ �޼ҵ� : �ź�Ȯ��
		System.out.println(place_name+"��ǥ���� �ֹι�ȣ:"+ no + " �̸� :" + name + "�ź�Ȯ���ϴ�"); 
	}
	synchronized void vote( String no, String name ) { // ����ȭ �޼ҵ� ��ǥ�ϴ�
		System.out.println(place_name+"��ǥ���� �ֹι�ȣ:"+ no + " �̸� :" + name + "�� ��ǥ�Ѵ�"); 
	}
	void input ( String no, String name ) { // �Ϲ� �޼ҵ� ��ǥ�Կ� ��ǥ�� �ִ�
		System.out.println(place_name+"��ǥ���� �ֹι�ȣ:"+ no + " �̸� :" + name + "�� ��ǥ���� ��ǥ�Կ� �ִ�"); 
	}
}

class People extends Thread { // ������ : ��ǥ�� ���׻�� Ŭ����
	String voter_no;
	String voter_name;
	Vote_Place vote_place;
	
	People (String no, String name, Vote_Place vp) {
		voter_name = name; // ��ǥ���� �̸� ���
		voter_no = no; // ��ǥ���� �ֹι�ȣ ���
		vote_place = vp; // ��ǥ���� ��ǥ�Ҹ� vote_place�� ���
	}
	public void run() {
	vote_place.check_id(voter_no, voter_name);
	vote_place.vote(voter_no, voter_name);
	vote_place.input(voter_no, voter_name);
	}
}

class Vote_Program {
	public static void main (String args[]) {
		Vote_Place place = new Vote_Place("ȫ����"); //��ǥ�� ��ü ����
		People p1 = new People("930302 - 1034516", "��ö��", place);
		People p2 = new People("910622 - 2156201", "�̿���", place);
		People p3 = new People("891225 - 1034512", "ȫ�浿", place);
		p1.start(); 	p2.start();		p3.start();
	}
}