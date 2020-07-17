package class25;

public class StaticPractice {
	public static void main(String[] args) {
		StaticPracitec c = new StaticPracitec(100,"홍길동");
	StaticPracitec c2 = new StaticPracitec(101,"김길동");
	EnterAdm.entrance(c);
	EnterAdm.entrance(c2);
	
	
	
	}

}

class EnterAdm{
	static int count;
	static final int maxCnt=100;
	static StaticPracitec[] custs = new StaticPracitec[maxCnt];
	
	public static void entrance (StaticPracitec c) {
		if (c != null) custs[count++] =c;
	}
	
	public static int getCount() {
		return count;
	}
	
}


class StaticPracitec{
	int number;
	String name;
	
	public StaticPracitec(int number,String name) {
		this.number = number;
		this.name = name;
		
	}
}



