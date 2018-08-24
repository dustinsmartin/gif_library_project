package service;

import java.util.List;

import model.Gif;
import model.User;

public interface UserLoginService {
	
	public User authenticate(String username, String password) throws Exception;
	
	public String register(User user) throws Exception;

	public boolean changePassword(String username, String oldPassword, String newPassword) throws Exception;
	
	public String addGif(String username, String url, String tags) throws Exception;
	
	public boolean deleteGif(String username, String url) throws Exception;
	
	public List<Gif> getUserGifs(String username) throws Exception;

}
