package class23;

class Value{
	int value;
	
	Value(int value){
		this.value =value;
	}
}

public class Equals {
	public static void main(String[] args) {
		Value v1 = new Value(11);
		Value v2 = new Value(11);
		
		if (v1.equals(v2)) { //다른 이유는 주소값만 비교하게 되기때문
			System.out.println("v1과 v2는 같습니다."); 
		}else {
			System.out.println("v1과v2는 다릅니다.");
		}
		v2 =v1;
		
		if (v1.equals(v2)) { //같은이유는  v2 =v1; 를통해 재정의 하였기 때문임
			System.out.println("v1과 v2는 같습니다.");
		}else {
			System.out.println("v1과 v2는 다릅니다.");
		}
	}
}

