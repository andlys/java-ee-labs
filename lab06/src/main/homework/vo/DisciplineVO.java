package main.homework.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="discipline")
public class DisciplineVO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String name;
	@Column
	private int credits;
	//@Column(name="faculty_id",insertable=false, updatable=false)
	//private int facultyId;
    @ManyToOne(fetch=FetchType.LAZY,cascade={ CascadeType.ALL })    
    @JoinColumn(name="faculty_id")
	private FacultyVO faculty;
	@ManyToMany(cascade = { CascadeType.ALL }, fetch=FetchType.EAGER)
    @JoinTable(
        name = "enrollment", 
        joinColumns = { @JoinColumn(name = "id_discipline") }, 
        inverseJoinColumns = { @JoinColumn(name = "id_student") }
    )
	private Set<StudentVO> enrolledStudents;
	
	public DisciplineVO() {
		super();
	}
	public DisciplineVO(int id, String name, int credits) {
		super();
		this.id = id;
		this.name = name;
		this.credits = credits;
		enrolledStudents = new HashSet<StudentVO>();
	}
	public DisciplineVO(String name, int credits) {
		super();
		this.name = name;
		this.credits = credits;
		enrolledStudents = new HashSet<StudentVO>();
	}
	
	public Set<StudentVO> getEnrolledStudents() {
		return new HashSet<StudentVO>(enrolledStudents);
	}
	
	public void addEnrolledStudent(StudentVO s) {
		enrolledStudents.add(s);
	}
	
	public FacultyVO getFaculty() {
		return faculty;
	}
	public void setFaculty(FacultyVO faculty) {
		this.faculty = faculty;
	}
	public Integer getId() {
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

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + credits;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DisciplineVO other = (DisciplineVO) obj;
		if (credits != other.credits)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DisciplineVO [id=" + id + ", name=" + name + ", credits=" + credits + ", faculty=" + faculty
				+ ", enrolledStudents=" + enrolledStudents + "]";
	}
	
}
