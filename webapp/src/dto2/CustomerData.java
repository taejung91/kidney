package dto2;

import java.sql.Timestamp;

public class CustomerData {
	private int num;
	private String id;
	private double weight;
	private double height;
	private double s_weight;
	private int Kcal;
	private int Na;
	private int protein;
	private int K;
	private int P;
	private int Ca;
	private Timestamp indate;
	
	
	
	public int getNum() {
		return num;
	}
	public CustomerData setNum(int num) {
		this.num = num;
		return this;
	}
	public String getId() {
		return id;
	}
	public CustomerData setId(String id) {
		this.id = id;
		return this;
	}
	public double getWeight() {
		return weight;
	}
	public CustomerData setWeight(double weight) {
		this.weight = weight;
		return this;
	}
	public double getHeight() {
		return height;
	}
	public CustomerData setHeight(double height) {
		this.height = height;
		return this;
	}
	public double getS_weight() {
		return s_weight;
	}
	public CustomerData setS_weight(double s_weight) {
		this.s_weight = s_weight;
		return this;
	}

	
	public int getKcal() {
		return Kcal;
	}
	public CustomerData setKcal(int kcal) {
		Kcal = kcal;
		return this;
	}
	public int getNa() {
		return Na;
	}
	public CustomerData setNa(int na) {
		Na = na;
		return this;
	}
	public int getProtein() {
		return protein;
	}
	public CustomerData setProtein(int protein) {
		this.protein = protein;
		return this;
	}
	public int getK() {
		return K;
	}
	public CustomerData setK(int k) {
		K = k;
		return this;
	}
	public int getP() {
		return P;
	}
	public CustomerData setP(int p) {
		P = p;
		return this;
	}
	public int getCa() {
		return Ca;
	}
	public CustomerData setCa(int ca) {
		Ca = ca;
		return this;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public CustomerData setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}
	

}
