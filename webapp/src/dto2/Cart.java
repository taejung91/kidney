package dto2;

import java.sql.Timestamp;

public class Cart {
	private int cseq;
	private String id;
	private int pseq;
	private String cname;
	private String pname;
	private int quantity1;
	private int quantity2;
	private String s_schedule;
	private int price1;
	private int price2;
	private String kind;
	private String result;
	
	
	
	
	public String getKind() {
		return kind;
	}
	public Cart setKind(String kind) {
		this.kind = kind;
		return this;
	}
	public int getCseq() {
		return cseq;
	}
	public Cart setCseq(int cseq) {
		this.cseq = cseq;
		return this;
	}
	public String getId() {
		return id;
	}
	public Cart setId(String id) {
		this.id = id;
		return this;
	}
	public int getPseq() {
		return pseq;
	}
	public Cart setPseq(int pseq) {
		this.pseq = pseq;
		return this;
	}
	public String getCname() {
		return cname;
	}
	public Cart setCname(String cname) {
		this.cname = cname;
		return this;
	}
	public String getPname() {
		return pname;
	}
	public Cart setPname(String pname) {
		this.pname = pname;
		return this;
	}
	
	
	public int getQuantity1() {
		return quantity1;
	}
	public Cart setQuantity1(int quantity1) {
		this.quantity1 = quantity1;
		return this;
	}
	public int getQuantity2() {
		return quantity2;
	}
	public Cart setQuantity2(int quantity2) {
		this.quantity2 = quantity2;
		return this;
	}
	public String getS_schedule() {
		return s_schedule;
	}
	public Cart setS_schedule(String s_schedule) {
		this.s_schedule = s_schedule;
		return this;
	}
	
	
	public int getPrice1() {
		return price1;
	}
	public Cart setPrice1(int price1) {
		this.price1 = price1;
		return this;
	}
	
	public int getPrice2() {
		return price2;
	}
	public Cart setPrice2(int price2) {
		this.price2 = price2;
		return this;
	}
	public String getResult() {
		return result;
	}
	public Cart setResult(String result) {
		this.result = result;
		return this;
	}
	
	

}
