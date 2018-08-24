package model;

import java.util.List;

public class Gif {
	private String url;
	private List<String> tags;
	private Integer gifId;
	private String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public Integer getGifId() {
		return gifId;
	}
	public void setGifId(Integer gifId) {
		this.gifId = gifId;
	}
	
	}