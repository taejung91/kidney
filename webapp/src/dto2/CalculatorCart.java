package dto2;

import java.sql.Date;

public class CalculatorCart {
	
	private int cseq;
	private String id;
	private String fname;;
	private int Kcal;
	private int Na;
	private int protein;
	private int K;
	private int P;
	private int Ca;
	private Date indate;
	
	
	
	
	
	public String getFname() {
		return fname;
	}
	public CalculatorCart setFname(String fname) {
		this.fname = fname;
		return this;
	}
	public int getCseq() {
		return cseq;
	}
	public CalculatorCart setCseq(int cseq) {
		this.cseq = cseq;
		return this;
	}
	public String getId() {
		return id;
	}
	public CalculatorCart setId(String id) {
		this.id = id;
		return this;
	}
	public int getKcal() {
		return Kcal;
	}
	public CalculatorCart setKcal(int kcal) {
		Kcal = kcal;
		return this;
	}
	public int getNa() {
		return Na;
	}
	public CalculatorCart setNa(int na) {
		Na = na;
		return this;
	}
	public int getProtein() {
		return protein;
	}
	public CalculatorCart setProtein(int protein) {
		this.protein = protein;
		return this;
	}
	public int getK() {
		return K;
	}
	public CalculatorCart setK(int k) {
		K = k;
		return this;
	}
	public int getP() {
		return P;
	}
	public CalculatorCart setP(int p) {
		P = p;
		return this;
	}
	public int getCa() {
		return Ca;
	}
	public CalculatorCart setCa(int ca) {
		Ca = ca;
		return this;
	}
	public Date getIndate() {
		return indate;
	}
	public CalculatorCart setIndate(Date indate) {
		this.indate = indate;
		return this;
	}
	
	


}
