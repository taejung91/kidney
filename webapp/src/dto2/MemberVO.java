package dto2;

public class MemberVO {
	private int index;
	private String id;
	private String pw;
	
	
	
	
	public int getIndex() {
		return index;
	}
	
	public MemberVO setIndex(int index) {
		this.index = index;
		return this;
	}
	
	public String getId() {
		return id;
	
	}
	
	public MemberVO setId(String id) {
		this.id = id;
		return this;
	}
	
	public String getPw() {
		return pw;
	}
	
	public MemberVO setPw(String pw) {
		this.pw = pw;
		return this;
	}

}
