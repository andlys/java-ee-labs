package main.homework.vo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "faculty")
public class FacultyVO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 30)
	private String name;
	@Column(name = "dekan_full_name", length = 60)
	private String dekanName;
    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="faculty")
	private List<DisciplineVO> disciplines;
	public FacultyVO() {
		super();
	}

	public FacultyVO(String name, String dekanName) {
		super();
		this.id = id;
		this.name = name;
		this.dekanName = dekanName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDekanName() {
		return dekanName;
	}

	public void setDekanName(String dekanName) {
		this.dekanName = dekanName;
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + ", dekanName=" + dekanName + "]";
	}

}
