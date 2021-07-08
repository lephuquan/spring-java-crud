package spring.init.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "categories")
public class CategoriesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cate_id")
	private int cateId;

	@Column(name = "cate_name")
	@NotBlank(message = "not blank")
	private String cateName;

	@Column(name = "cate_desc")
	private String cateDesc;

	@OneToMany(mappedBy = "categoriesEntity")
	private List<NewsEntity> newsEntities;

	public CategoriesEntity() {
		super();
	}

	public int getCateId() {
		return cateId;
	}

	public void setCateId(int cateId) {
		this.cateId = cateId;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getCateDesc() {
		return cateDesc;
	}

	public void setCateDesc(String cateDesc) {
		this.cateDesc = cateDesc;
	}

	public List<NewsEntity> getNewsEntities() {
		return newsEntities;
	}

	public void setNewsEntities(List<NewsEntity> newsEntities) {
		this.newsEntities = newsEntities;
	}

}
