package dto2;

import java.sql.Date;

public class Calculator {
	
	private int cseq;
	private String id;
	private int fseq;
	private int Kcal;
	private int Na;
	private int protein;
	private int K;
	private int P;
	private int Ca;
	private Date indate;
	
	
	
	public int getFseq() {
		return fseq;
	}
	public Calculator setFseq(int fseq) {
		this.fseq = fseq;
		return this;
	}
	public int getCseq() {
		return cseq;
	}
	public Calculator setCseq(int cseq) {
		this.cseq = cseq;
		return this;
	}
	public String getId() {
		return id;
	}
	public Calculator setId(String id) {
		this.id = id;
		return this;
	}
	public int getKcal() {
		return Kcal;
	}
	public Calculator setKcal(int kcal) {
		Kcal = kcal;
		return this;
	}
	public int getNa() {
		return Na;
	}
	public Calculator setNa(int na) {
		Na = na;
		return this;
	}
	public int getProtein() {
		return protein;
	}
	public Calculator setProtein(int protein) {
		this.protein = protein;
		return this;
	}
	public int getK() {
		return K;
	}
	public Calculator setK(int k) {
		K = k;
		return this;
	}
	public int getP() {
		return P;
	}
	public Calculator setP(int p) {
		P = p;
		return this;
	}
	public int getCa() {
		return Ca;
	}
	public Calculator setCa(int ca) {
		Ca = ca;
		return this;
	}
	public Date getIndate() {
		return indate;
	}
	public Calculator setIndate(Date indate) {
		this.indate = indate;
		return this;
	}
	
	

	
}
