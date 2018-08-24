package api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Gif;
import model.User;
import service.UserLoginService;
import service.UserLoginServiceImpl;
import utility.ContextFactory;

@RestController
@CrossOrigin
@RequestMapping(value ="GifAPI")
public class GifAPI {
	
	private UserLoginService userLoginService;
	
	@RequestMapping(method = RequestMethod.POST, value = "authenticate")
	public ResponseEntity<User> authenticate(@RequestBody User user) {
		System.out.println(user.getUsername());
		//Environment environment = ContextFactory.getContext().getEnvironment();
		System.out.println("fewfwef");
		userLoginService = (UserLoginService) ContextFactory.getContext().getBean(
				"userLoginService");
		ResponseEntity<User> responseEntity = null;
		User newUser = new User();
		try {
			newUser = userLoginService.authenticate(user.getUsername(), user.getPassword());
			System.out.println(newUser.getUsername());
			responseEntity = new ResponseEntity<User>(newUser,
					HttpStatus.OK);

		}

		catch (Exception exception) {
			/*String errorMessage = environment.getProperty(exception
					.getMessage());*/
			User fb = new User();
			responseEntity = new ResponseEntity<User>(fb,
					HttpStatus.BAD_REQUEST);

		}

		return responseEntity;
	}
 /*
	@RequestMapping(value="getAllCars",method = RequestMethod.GET)
	public ResponseEntity<List<Car>> getAllCars() {
		ResponseEntity<List<Car>> responseEntity = null;
		try {
			infyCarsService = (InfyCarsService) ContextFactory.getContext().getBean(InfyCarsServiceImpl.class);
			List<Car> cars = infyCarsService.getAllCars();
			responseEntity = new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
		} catch (Exception exception) {
			List<Car> cars = new ArrayList<Car>();
			
			responseEntity = new ResponseEntity<List<Car>>(cars, HttpStatus.BAD_REQUEST);
		}
		return responseEntity;

	}
*/	
	

}
