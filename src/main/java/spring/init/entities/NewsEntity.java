package spring.init.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "news")
public class NewsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "new_id")
	private int newId;

	@Column(name = "title")
	@NotBlank(message = "not blank")
	private String title;

	@Column(name = "summary")
	@NotBlank(message = "not blank")
	private String summary;

	@Column(name = "contents")
	private String contents;

	@Column(name = "created_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "not null")
	private LocalDate createdDate;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private StaffsEntity staffsEntity;

	@ManyToOne
	@JoinColumn(name = "categories_id_fk")
	private CategoriesEntity categoriesEntity;

	public NewsEntity() {
		super();
	}

	public int getNewId() {
		return newId;
	}

	public void setNewId(int newId) {
		this.newId = newId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public StaffsEntity getStaffsEntity() {
		return staffsEntity;
	}

	public void setStaffsEntity(StaffsEntity staffsEntity) {
		this.staffsEntity = staffsEntity;
	}

	public CategoriesEntity getCategoriesEntity() {
		return categoriesEntity;
	}

	public void setCategoriesEntity(CategoriesEntity categoriesEntity) {
		this.categoriesEntity = categoriesEntity;
	}

}
