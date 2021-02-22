package dto2;

import java.sql.Date;

public class Food {
	
	private int fseq;
	private String fname;
	private String kind;
	private int Kcal;
	private int Na;
	private int protein;
	private int K;
	private int P;
	private int Ca;
	private int capacity;
	private String image;
	private Date indate;
	
	
	public int getFseq() {
		return fseq;
	}
	public Food setFseq(int fseq) {
		this.fseq = fseq;
		return this;
	}
	
	
	public String getFname() {
		return fname;
	}
	public Food setFname(String fname) {
		this.fname = fname;
		return this;
	}
	public String getKind() {
		return kind;
	}
	public Food setKind(String kind) {
		this.kind = kind;
		return this;
	}
	public int getKcal() {
		return Kcal;
	}
	public Food setKcal(int kcal) {
		Kcal = kcal;
		return this;
	}
	public int getNa() {
		return Na;
	}
	public Food setNa(int na) {
		Na = na;
		return this;
	}
	public int getProtein() {
		return protein;
	}
	public Food setProtein(int protein) {
		this.protein = protein;
		return this;
	}
	public int getK() {
		return K;
	}
	public Food setK(int k) {
		K = k;
		return this;
	}
	public int getP() {
		return P;
	}
	public Food setP(int p) {
		P = p;
		return this;
	}
	public int getCa() {
		return Ca;
	}
	public Food setCa(int ca) {
		Ca = ca;
		return this;
	}
	public int getCapacity() {
		return capacity;
	}
	public Food setCapacity(int capacity) {
		this.capacity = capacity;
		return this;
	}
	public String getImage() {
		return image;
	}
	public Food setImage(String image) {
		this.image = image;
		return this;
	}
	public Date getIndate() {
		return indate;
	}
	public Food setIndate(Date indate) {
		this.indate = indate;
		return this;
	}
	
	
	

}
