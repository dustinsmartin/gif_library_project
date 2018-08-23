package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="GifLibrary")
@GenericGenerator(name="gifId_gen", strategy="increment")
public class GifEntity {
	@Id
	@GeneratedValue(generator="gifId_gen")
	private Integer gifId;
	@Column(name = "GIFUrl")
	private String url;
	@Column(name = "tag")
	private String tags;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
	private String username;
	
	
	public Integer getGifId() {
		return gifId;
	}
	public void setGifId(Integer gifId) {
		this.gifId = gifId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<String> getTags() {
		return Arrays.asList(tags.split(","));
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
	
}
