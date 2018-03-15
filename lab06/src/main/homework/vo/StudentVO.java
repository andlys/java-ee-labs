package main.homework.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="student")
public class StudentVO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String fio;
	@Column
	private int course;
	@Embedded
	private StudentCard card; 
	@Temporal(TemporalType.DATE)
	@Column
	private Date enteredDate = new Date();
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="student_contact_id")
	private StudentContact studentContact;
	public StudentVO() {
		
	}
	public StudentVO(String fio, int course, String seriesId, String numId, StudentContact studentContact) {
		super();
		this.id = id;
		this.fio = fio;
		this.course = course;
		this.card = new StudentCard(seriesId, numId);
		this.studentContact = studentContact;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + course;
		result = prime * result + ((fio == null) ? 0 : fio.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public String toString() {
		return "StudentVO [id=" + id + ", fio=" + fio + ", course=" + course + ", card=" + card + ", enteredDate="
				+ enteredDate + ", studentContact=" + studentContact + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentVO other = (StudentVO) obj;
		if (course != other.course)
			return false;
		if (fio == null) {
			if (other.fio != null)
				return false;
		} else if (!fio.equals(other.fio))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFio() {
		return fio;
	}
	public void setFio(String fio) {
		this.fio = fio;
	}
	public int getCourse() {
		return course;
	}
	public void setCourse(int course) {
		this.course = course;
	}
}
