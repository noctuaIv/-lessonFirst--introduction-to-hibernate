package models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role extends Model{

	private static final long serialVersionUID = 3913596127777173999L;

	@Column(name="title")
	private String title;
	
	@ManyToMany(mappedBy="roles")
	private Set<User> users = new HashSet<User>();
	
	public Role(){
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
