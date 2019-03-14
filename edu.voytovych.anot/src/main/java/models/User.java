package models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends Model implements Serializable {

	private static final long serialVersionUID = 3072398152128409833L;

	@Column(name = "age")
	private int age;

	@Column(name = "firstname", length = 50)
	private String firstname;

	@Column(name = "lastname", length = 50)
	private String lastname;
	

	private Set<Role> roles = new HashSet<Role>();

	public User() {
		super();
	}
	
	public User(int id) {
		super(id);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	
}
