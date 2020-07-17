package class23;


class Video2{
	private int videoNo;
	private String title;
	private String actor;
	public void setVideoData(int vno, String t, String a) {
		videoNo = vno;
		title =t;
		actor =a;
	}
	public int getVideoNo() {return videoNo;}
	public String getTitle() {return title;}
	public String getActor() {return actor;}
	
}

class GeneralMembers{
	private int memberNo;
	private int name;
	private int address;
	private Video2 rentalVideo;
	
	void setMemberDate (int mno, String n, String a, Video2 rv) {
		memberNo =mno;
		name = n;
		address =a;
		rentalVideo =rv;
	}

	
	void printMemberData() {
		 
	}
	
	
}


public class VedioShop2 {

	public static void main(String[] args) {
		Video2 v = new Video2();
		v.setVideoData(1,"허영석", "광진구 123번지",v);
		
	}
}




