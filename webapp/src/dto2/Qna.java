package dto2;

import java.sql.Timestamp;

public class Qna {
	
	private int qseq;
	private String subject;
	private String content;
	private String reply;
	private String id;
	private String rep;
	private Timestamp indate;
	
	
	public int getQseq() {
		return qseq;
	}
	public Qna setQseq(int qseq) {
		this.qseq = qseq;
		return this;
	}
	public String getSubject() {
		return subject;
	}
	public Qna setSubject(String subject) {
		this.subject = subject;
		return this;
	}
	public String getContent() {
		return content;
	}
	public Qna setContent(String content) {
		this.content = content;
		return this;
	}
	public String getReply() {
		return reply;
	}
	public Qna setReply(String reply) {
		this.reply = reply;
		return this;
	}
	public String getId() {
		return id;
	}
	public Qna setId(String id) {
		this.id = id;
		return this;
	}
	public String getRep() {
		return rep;
	}
	public Qna setRep(String rep) {
		this.rep = rep;
		return this;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public Qna setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}

}