package dto2;

import java.sql.Date;

public class Product {
	
	private int pseq;
	private String name;
	private String kind;
	private int price1;
	private int price2;
	private int quantity;
	private String schedule;
	private String s_schedule;
	private String e_schedule;
	private String route;
	private String content;
	private String image;
	private String useyn;
	private Date indate;
	
	
	public int getPseq() {
		return pseq;
	}
	public Product setPseq(int pseq) {
		this.pseq = pseq;
		return this;
		
	}
	public String getName() {
		return name;
	}
	public Product setName(String name) {
		this.name = name;
		return this;
		
	}
	public String getKind() {
		return kind;
	}
	public Product setKind(String kind) {
		this.kind = kind;
		return this;
		
	}
	public int getPrice1() {
		return price1;
	}
	public Product setPrice1(int price1) {
		this.price1 = price1;
		return this;
		
	}
	public int getPrice2() {
		return price2;
	}
	public Product setPrice2(int price2) {
		this.price2 = price2;
		return this;
		
	}
	public int getQuantity() {
		return quantity;
	}
	public Product setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
		
	}
	public String getSchedule() {
		return schedule;
	}
	public Product setSchedule(String schedule) {
		this.schedule = schedule;
		return this;
		
	}
	public String getS_schedule() {
		return s_schedule;
	}
	public Product setS_schedule(String s_schedule) {
		this.s_schedule = s_schedule;
		return this;
		
	}
	public String getE_schedule() {
		return e_schedule;
	}
	public Product setE_schedule(String e_schedule) {
		this.e_schedule = e_schedule;
		return this;
		
	}
	public String getRoute() {
		return route;
	}
	public Product setRoute(String route) {
		this.route = route;
		return this;
		
	}
	public String getContent() {
		return content;
	}
	public Product setContent(String content) {
		this.content = content;
		return this;
		
	}
	public String getImage() {
		return image;
	}
	public Product setImage(String image) {
		this.image = image;
		return this;
		
	}
	public String getUseyn() {
		return useyn;
	}
	public Product setUseyn(String useyn) {
		this.useyn = useyn;
		return this;
		
	}
	public Date getIndate() {
		return indate;
	}
	public Product setIndate(Date indate) {
		this.indate = indate;
		return this;
		
	}
	
	
}
