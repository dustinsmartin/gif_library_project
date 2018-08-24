package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.UserLoginDAO;
import model.Gif;
import model.User;

@Service
@Transactional(readOnly=true)
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private UserLoginDAO UserLoginDAO;
	
	@Override
	public User authenticate(String username, String password) throws Exception {
		
		User user = UserLoginDAO.authenticate(username, password);
		
		if(user == null) {
			throw new Exception("UserLoginService.BAD_AUTHENTICATE");
		}
		
		return user;
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)
	public String register(User user) throws Exception {
		String username = null;
		try {
			username = UserLoginDAO.register(user);
		} catch (Exception e) {
			throw new Exception("UserLoginService.BAD_REGISTER");
		}
			return username;
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)
	public boolean changePassword(String username, String oldPassword, String newPassword) throws Exception {
		boolean success = false;
		try {
			success = UserLoginDAO.changePassword(username, oldPassword, newPassword);
		} catch (Exception e) {
			throw new Exception("UserLoginService.BAD_CHANGE_PASSWORD");
		}
		return success;
	}
	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)
	public String addGif(String username, String url, String tags) throws Exception {
		String status = null;
		try {
			status = UserLoginDAO.addGif(username, url, tags);
		} catch (Exception e) {
			throw new Exception("UserLoginService.BAD_ADD_GIF");
		}
		return status;
	}
	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)
	public boolean deleteGif(String username, String url) throws Exception {
		boolean success = false;
		try {
			success = UserLoginDAO.deleteGif(username, url);
		} catch (Exception e) {
			throw new Exception("UserLoginService.BAD_DELETE_GIF");
		}
		return success;
	}
	
	@Override
	public List<Gif> getUserGifs(String username) throws Exception {
		List<Gif> gifList = null;
		try {
			gifList = UserLoginDAO.getUserGifs(username);
			
		} catch (Exception e ) {
			throw new Exception("UserLoginService.BAD_GET_GIFS");
		}
		return gifList;
	}
	
}
