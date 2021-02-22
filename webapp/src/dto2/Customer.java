package dto2;

import java.sql.Date;
import java.sql.Timestamp;

public class Customer {
	
	private String id;
	private String pw;
	private String name;
	private String birth;
	private String gender;
	private String tel;
	private String tel1;
	private String tel2;
	private String tel3;
	private String email;
	private String add1;
	private String add2;
	private Date indate;
	private String receive;
	private String deleteyn;
	
	
	
	public String getTel() {
		return tel;
	}
	public Customer setTel(String tel) {
		this.tel = tel;
		return this;
	}
	public String getTel1() {
		return tel1;
	}
	public Customer setTel1(String tel1) {
		this.tel1 = tel1;
		return this;
	}
	public String getTel2() {
		return tel2;
	}
	public Customer setTel2(String tel2) {
		this.tel2 = tel2;
		return this;
	}
	public String getTel3() {
		return tel3;
	}
	public Customer setTel3(String tel3) {
		this.tel3 = tel3;
		return this;
	}
	public String getId() {
		return id;
	}
	public Customer setId(String id) {
		this.id = id;
		return this;
	}
	public String getPw() {
		return pw;
	}
	public Customer setPw(String pw) {
		this.pw = pw;
		return this;
	}
	public String getName() {
		return name;
	}
	public Customer setName(String name) {
		this.name = name;
		return this;
	}
	public String getBirth() {
		return birth;
	}
	public Customer setBirth(String birth) {
		this.birth = birth;
		return this;
	}
	public String getGender() {
		return gender;
	}
	public Customer setGender(String gender) {
		this.gender = gender;
		return this;
	}

	public String getEmail() {
		return email;
	}
	public Customer setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getAdd1() {
		return add1;
	}
	public Customer setAdd1(String add1) {
		this.add1 = add1;
		return this;
	}
	public String getAdd2() {
		return add2;
	}
	public Customer setAdd2(String add2) {
		this.add2 = add2;
		return this;
	}
	public Date getIndate() {
		return indate;
	}
	public Customer setIndate(Date indate) {
		this.indate = indate;
		return this;
	}
	public String getReceive() {
		return receive;
	}
	public Customer setReceive(String receive) {
		this.receive = receive;
		return this;
	}
	public String getDeleteyn() {
		return deleteyn;
	}
	public Customer setDeleteyn(String deleteyn) {
		this.deleteyn = deleteyn;
		return this;
	}
	
	
	

}
