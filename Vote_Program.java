class Vote_Place { //공유자원 - 기표소 클래스
String place_name; // 투표소 이름
	Vote_Place (String n ) { place_name = n; }
	synchronized void check_id ( String no, String name ) { // 동기화 메소드 : 신분확인
		System.out.println(place_name+"투표에서 주민번호:"+ no + " 이름 :" + name + "신분확인하다"); 
	}
	synchronized void vote( String no, String name ) { // 동기화 메소드 투표하다
		System.out.println(place_name+"투표에서 주민번호:"+ no + " 이름 :" + name + "가 투표한다"); 
	}
	void input ( String no, String name ) { // 일반 메소드 투표함에 투표지 넣다
		System.out.println(place_name+"투표에서 주민번호:"+ no + " 이름 :" + name + "가 투표지를 투표함에 넣다"); 
	}
}

class People extends Thread { // 스레드 : 투표할 동네사람 클래스
	String voter_no;
	String voter_name;
	Vote_Place vote_place;
	
	People (String no, String name, Vote_Place vp) {
		voter_name = name; // 투표자의 이름 기억
		voter_no = no; // 투표자의 주민번호 기억
		vote_place = vp; // 투표자의 투표소를 vote_place에 기억
	}
	public void run() {
	vote_place.check_id(voter_no, voter_name);
	vote_place.vote(voter_no, voter_name);
	vote_place.input(voter_no, voter_name);
	}
}

class Vote_Program {
	public static void main (String args[]) {
		Vote_Place place = new Vote_Place("홍은동"); //기표소 객체 생성
		People p1 = new People("930302 - 1034516", "김철수", place);
		People p2 = new People("910622 - 2156201", "이영희", place);
		People p3 = new People("891225 - 1034512", "홍길동", place);
		p1.start(); 	p2.start();		p3.start();
	}
}