package dto2;

import java.sql.Date;

public class Hospital {
	
	private int no;
	private String name;
	private String address;
	private String tel;
	private String confirm;
	private String doctor;
	private String doctor_yn;
	
	
	
	
	public String getAddress() {
		return address;
	}
	public Hospital setAddress(String address) {
		this.address = address;
		return this;
	}
	public int getNo() {
		return no;
	}
	public Hospital setNo(int no) {
		this.no = no;
		return this;
	}
	public String getName() {
		return name;
	}
	public Hospital setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getTel() {
		return tel;
	}
	public Hospital setTel(String tel) {
		this.tel = tel;
		return this;
	}
	public String getConfirm() {
		return confirm;
	}
	public Hospital setConfirm(String confirm) {
		this.confirm = confirm;
		return this;
	}
	public String getDoctor() {
		return doctor;
	}
	public Hospital setDoctor(String doctor) {
		this.doctor = doctor;
		return this;
	}
	public String getDoctor_yn() {
		return doctor_yn;
	}
	public Hospital setDoctor_yn(String doctor_yn) {
		this.doctor_yn = doctor_yn;
		return this;
	}
	
	

}
