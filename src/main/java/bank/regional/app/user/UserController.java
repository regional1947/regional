package bank.regional.app.user;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/user")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@RequestMapping("/user/{accountNumber}")
	public Optional<User> getUser(@PathVariable String accountNumber) {
		return userService.getUserByAccountNumber(accountNumber);
	}
	
	@RequestMapping("/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{accountNumber}/delete")
	public void deleteUser(@PathVariable String accountNumber) {
		userService.deleteUser(accountNumber);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/user")
	public User updateUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/signin")
	public User signIn(@RequestBody User user,  HttpServletRequest request) {
		String clientIp = getClientIp(request);
		user.setIp(clientIp);
		return userService.signIn(user);
	}
	
	private String getClientIp(HttpServletRequest request) {
	    String ip = request.getHeader("X-Forwarded-For");
	    if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getRemoteAddr();
	    }
	    if (ip != null && ip.contains(",")) {
	        ip = ip.split(",")[0].trim();
	    }
	    return ip;
	}
}
