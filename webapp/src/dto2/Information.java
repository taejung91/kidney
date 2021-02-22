package dto2;

import java.sql.Date;

public class Information {

	private int iseq;
	private String kind;
	private String title;
	private String content;
	private String image;
	private Date indate;
	
	
	public int getIseq() {
		return iseq;
	}
	public Information setIseq(int iseq) {
		this.iseq = iseq;
		return this;
	}
	public String getKind() {
		return kind;
	}
	public Information setKind(String kind) {
		this.kind = kind;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public Information setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getContent() {
		return content;
	}
	public Information setContent(String content) {
		this.content = content;
		return this;
	}
	public String getImage() {
		return image;
	}
	public Information setImage(String image) {
		this.image = image;
		return this;
	}
	public Date getIndate() {
		return indate;
	}
	public Information setIndate(Date indate) {
		this.indate = indate;
		return this;
	}
	
	

}
