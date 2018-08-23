package dao;

import model.User;
import model.Gif;

import java.util.List;

public interface UserLoginDAO {
	
	public User authenticate(String username, String password) throws Exception;
	
	public String register(User user) throws Exception;

	public String changePassword(String username, String oldPassword, String newPassword) throws Exception;
	
	public String addGif(String username, String url, String tags) throws Exception;
	
	public boolean deleteGif(String username, String url) throws Exception;
	
	public List<Gif> getUserGifs(String username) throws Exception;
}
