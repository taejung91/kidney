package dto2;

import java.sql.Timestamp;

public class Order {
	
	private int odseq;
	private int oseq;
	private String id;
	private Timestamp indate;
	private int pseq;
	private int quantity1;
	private int quantity2;
	private String cname;
	private String birth;
	private String email;
	private String tel;
	private String pname;
	private String s_schedule;
	private String e_schedule;
	private int price1;
	private int price2;
	private String kind;
	private String result;
	
	
	
	public String getKind() {
		return kind;
	}
	public Order setKind(String kind) {
		this.kind = kind;
		return this;
	}
	public int getOdseq() {
		return odseq;
	}
	public Order setOdseq(int odseq) {
		this.odseq = odseq;
		return this;
	}
	public int getOseq() {
		return oseq;
	}
	public Order setOseq(int oseq) {
		this.oseq = oseq;
		return this;
	}
	public String getId() {
		return id;
	}
	public Order setId(String id) {
		this.id = id;
		return this;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public Order setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}
	public int getPseq() {
		return pseq;
	}
	public Order setPseq(int pseq) {
		this.pseq = pseq;
		return this;
	}
	
	public int getQuantity1() {
		return quantity1;
	}
	public Order setQuantity1(int quantity1) {
		this.quantity1 = quantity1;
		return this;
	}
	public int getQuantity2() {
		return quantity2;
	}
	public Order setQuantity2(int quantity2) {
		this.quantity2 = quantity2;
		return this;
	}
	public String getCname() {
		return cname;
	}
	public Order setCname(String cname) {
		this.cname = cname;
		return this;
	}
	public String getBirth() {
		return birth;
	}
	public Order setBirth(String birth) {
		this.birth = birth;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Order setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getTel() {
		return tel;
	}
	public Order setTel(String tel) {
		this.tel = tel;
		return this;
	}
	public String getPname() {
		return pname;
	}
	public Order setPname(String pname) {
		this.pname = pname;
		return this;
	}
	public String getS_schedule() {
		return s_schedule;
	}
	public Order setS_schedule(String s_schedule) {
		this.s_schedule = s_schedule;
		return this;
	}
	public String getE_schedule() {
		return e_schedule;
	}
	public Order setE_schedule(String e_schedule) {
		this.e_schedule = e_schedule;
		return this;
	}
	public int getPrice1() {
		return price1;
	}
	public Order setPrice1(int price1) {
		this.price1 = price1;
		return this;
	}
	public int getPrice2() {
		return price2;
	}
	public Order setPrice2(int price2) {
		this.price2 = price2;
		return this;
	}
	public String getResult() {
		return result;
	}
	public Order setResult(String result) {
		this.result = result;
		return this;
	}
	
	
	

}
