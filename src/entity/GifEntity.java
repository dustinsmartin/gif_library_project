package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="GifLibrary")
@GenericGenerator(name="gifId_gen", strategy="increment")
public class GifEntity {
	@Id
	@GeneratedValue(generator="gifId_gen")
	private Integer gifId;
	private String username;
	@Column("emailAddress")
	private String email;
	private String password;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
	private String username;
	
}
