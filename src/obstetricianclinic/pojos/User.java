package obstetricianclinic.pojos;


import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 88535547744590137L;
	@Id
	@GeneratedValue(generator = "users")
	@TableGenerator(name = "users", table = "sqlite_sequence", pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "users")
	private Integer id;
	@Column(unique = true)
	private String username;
	private String password;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roleId")
	private Role role;

	public User() {
		super();
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	

	public User(String username, String password, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", role=" + role + "]";
	}
}


