package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="UserDB")
public class UserEntity {
	@Id
	private String username;
	@Column("emailAddress")
	private String email;
	private String password;
}
