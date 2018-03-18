package main.homework.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.googlecode.ehcache.annotations.Cacheable;

@Entity
@Table(name = "simple_student")
@NamedQueries({
	@NamedQuery(name="student.findAll", query="select s from SimpleStudent s"),
	@NamedQuery(name="student.findById", query="select s from SimpleStudent s where s.id = :id")
})
public class SimpleStudent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "full_name")
	private String fullName;
	@Column
	private int course;
	
	static String SQL_SELECT_STUDENT_BY_ID = "qwe";

	public SimpleStudent(String fullName, int course) {
		this.fullName = fullName;
		this.course = course;
	}

	public SimpleStudent() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getCourse() {
		return course;
	}

	public void setCourse(int course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "SimpleStudent [id=" + id + ", fullName=" + fullName + ", course=" + course + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + course;
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + id;
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
		SimpleStudent other = (SimpleStudent) obj;
		if (course != other.course)
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

}
