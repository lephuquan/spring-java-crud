package spring.init.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "staffs")
public class StaffsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "taff_id")
	private int staffId;

	@Column(name = "staffName")
	@NotBlank(message = "not blank")
	private String staffName;

	@Column(name = "staff_address")
	private String staffAddress;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;

	@OneToOne(mappedBy = "staffsEntity")
	private NewsEntity newsEntity;

	public StaffsEntity() {
		super();
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffAddress() {
		return staffAddress;
	}

	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public NewsEntity getNewsEntity() {
		return newsEntity;
	}

	public void setNewsEntity(NewsEntity newsEntity) {
		this.newsEntity = newsEntity;
	}

}
