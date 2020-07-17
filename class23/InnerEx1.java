package class23;

/*
 * 호출방법
InnerEx1 ex = new InnerEx1();
InnerEx1.InstanceInner inner1 = ex.new InstanceInner();
InnerEx1.StaticInner inner2 = new InnerEx1.StaticInner();
*/
public class InnerEx1 {
	int m=0;
	claas InstanceInner{    //클래스안 내부 클래스
		int iv=100;
		int t =m;
		
		final static int CONST =100;
	}
	static class StaticInner{     //클래스안 내부 스태틱
		int iv=200;
		
		static int cv =200;
	}
	void myMethod() {         //클래스안 내부 매소드
		class Localnner{
			int iv =300;
			int t =m;
			final static int CONST =300;
		}
	}
	public static void main(String args[]) {
		InnerEx1 ex = new InnerEx1();
		InnerEx1.InstanceInner inner1 = ex.new InstanceInner();
		System.out.println(InstanceInner.);
		System.out.println(StaticInner.cv);
	}
}










