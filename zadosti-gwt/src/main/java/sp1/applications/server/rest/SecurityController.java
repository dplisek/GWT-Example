package sp1.applications.server.rest;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import sp1.applications.server.service.SecurityService;
import sp1.applications.shared.common.ForbiddenException;

/**
 *
 * @author JakubPetr
 */
@Controller
@RequestMapping("/security")
public class SecurityController {

    @Autowired
    private SecurityService securityService;
    
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public @ResponseBody String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return securityService.login(username, password);
    }

    @RequestMapping(value = "rights", method = RequestMethod.GET)
    public @ResponseBody HashMap<String, String> listRights(@RequestHeader(value="secret", defaultValue="XXX") String secret) throws ForbiddenException {
        return securityService.getAccessRights(secret);
    }
        
    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void forbiddenAccessException() {
        System.out.println("Forbidden access.");
    }
}
