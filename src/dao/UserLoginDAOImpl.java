package dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.UserEntity;
import entity.GifEntity;

import model.User;
import model.Gif;

import java.util.ArrayList;
import java.util.List;

@Repository(value = "userLoginDAO")
public class UserLoginDAOImpl implements UserLoginDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public User authenticate(String username, String password) throws Exception {
		Session session = null;
		List<Gif> gifs  = null;
		User user = null;
		
		System.out.println(username +" "+ password);
		session = sessionFactory.getCurrentSession();	
		
		// get the username associated user details out of the database
		UserEntity userEntity = (UserEntity) session.get(UserEntity.class, username);
		
		//TODO I am actually not sure we need to make a new user
		// if we found any, AND the passwd is correct, make a new user object
		if (userEntity != null && userEntity.getPassword().equals(password)) {
			user = new User();
			user.setUsername(userEntity.getUsername());
			user.setEmail(userEntity.getEmail());
			user.setPassword(userEntity.getPassword());
			
			// Use criteria builder to get all the Gifs that are associated with this username
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<GifEntity> criteriaQuery = builder.createQuery(GifEntity.class);
			Root<GifEntity> root = criteriaQuery.from(GifEntity.class);
			criteriaQuery.select(root);
			
			criteriaQuery.where(builder.equal(root.get("user"), username));
			List<GifEntity> gifEntityList = session.createQuery(criteriaQuery).list();
			
			// if there are gifEntities in the list, make new gifs from them, and
			// attach that list to the user we made
			if (gifEntityList.size() != 0) {
				gifs = new ArrayList<>();
				for (GifEntity ge : gifEntityList) {
					Gif gif = new Gif();
					gif.setUrl(ge.getUrl());
					gif.setTags(ge.getTags());
					gifs.add(gif);
				}
			}
			user.setGifs(gifs);
		}
		return user;
	}
	
	@Override
	public boolean changePassword(String username, String oldPassword, String newPassword) throws Exception {
		/*
		 * check that oldPassword is correct
		 * update new password
		 * 
		 */
		Session session = null;
		
		session = sessionFactory.getCurrentSession();	
		
		// get the username associated user details out of the database
		UserEntity userEntity = (UserEntity) session.get(UserEntity.class, username);
		
		// if we found any, check the password and update if correct
		if (userEntity != null && userEntity.getPassword().equals(oldPassword)) {
			// it should auto persist!
			userEntity.setPassword(newPassword);
			return true;
		}
		//TODO we may want to return the circumstances surrounding the failure
		return false;
	}

	@Override
	public String register(User user) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		
		UserEntity ue = new UserEntity();
		//TODO Do we need to check for uniqueness
		ue.setEmail(user.getEmail());
		ue.setUsername(user.getUsername());
		ue.setPassword(user.getPassword());
		
		String value = (String) session.save(ue);

		return value;
	}
	
	@Override
	public String addGif(String username, String url, String tags) throws Exception {
		Session session = sessionFactory.getCurrentSession();		
		UserEntity userEntity = (UserEntity) session.get(UserEntity.class, username);
		
		// if we found any, check the password and update if correct
		if (userEntity != null) {
			// it should auto persist!
			GifEntity ge = new GifEntity();
			ge.setUrl(url);
			ge.setTags(url);
			ge.setUsername(userEntity); // Not sure how this will work, I think it still works
			return "Success";
		}
		//TODO we may want to return the circumstances surrounding the failure
		return null;
	}

	@Override
	public boolean deleteGif(String username, String url) throws Exception {
		Session session = sessionFactory.getCurrentSession();		
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<GifEntity> criteriaQuery = builder.createQuery(GifEntity.class);
		Root<GifEntity> root = criteriaQuery.from(GifEntity.class);
		
		criteriaQuery.select(root);
		criteriaQuery.where(builder.and(
								builder.equal(root.get("username"), username),
								builder.equal(root.get("url"), url)
								)
							);
		
		GifEntity ge = session.createQuery(criteriaQuery).getSingleResult();
		if (ge != null) {
			session.delete(ge);
			return true;
		}
		return false;
	}
	
	@Override
	public List<Gif> getUserGifs(String username) throws Exception {
		Session session = sessionFactory.getCurrentSession();		
		List<Gif> gifs = null;
				
		// Use criteria builder to get all the Gifs that are associated with this username
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<GifEntity> criteriaQuery = builder.createQuery(GifEntity.class);
		Root<GifEntity> root = criteriaQuery.from(GifEntity.class);
		criteriaQuery.select(root);
		
		criteriaQuery.where(builder.equal(root.get("username"), username));
		List<GifEntity> gifEntityList = session.createQuery(criteriaQuery).list();
		
		// if there are gifEntities in the list, make new gifs from them, and
		if (gifEntityList.size() != 0) {
			gifs = new ArrayList<>();
			for (GifEntity ge : gifEntityList) {
				Gif gif = new Gif();
				gif.setUrl(ge.getUrl());
				gif.setTags(ge.getTags());
				gifs.add(gif);
			}
		}
		return gifs;
	}
}
