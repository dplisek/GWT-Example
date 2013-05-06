package sp1.applications.server.service;

import java.util.HashMap;
import org.springframework.stereotype.Service;
import sp1.applications.server.common.ForbiddenException;

/**
 * Service to authenticate user and retrieve his access rights.
 * 
 * @TODO Just stub version. Connection to WS should be here.
 * @author JakubPetr
 */
@Service
public class SecurityService {
        
    /**
     * Generates secret - creates user session.
     * 
     * @param username
     * @param password
     * @return 
     */
    public String login(String username, String password){
        if("readonly".equals(username) && "readonly".equals(password)){
            return "READONLY";
        } else if("full".equals(username) && "full".equals(password)){
            return "FULL";
        } else {
            return null;
        }
    }
    
    /**
     * Access rights for whole application.
     * W - for write
     * R - for read-only
     * 
     * @param secret - from login method
     * @return 
     */
    public HashMap<String, String> getAccessRights(String secret) throws ForbiddenException{
        HashMap<String, String> rights = new HashMap<String, String>(10);

        rights.put("field_datumDoruceni", "W");
        rights.put("field_datumOdeslani", "W");

        rights.put("field_keDni", "W");
        rights.put("field_lhuta", "W");
        rights.put("field_vyrizujeOsoba", "W");
        rights.put("field_jednaciCislo", "W");
        rights.put("field_jednaciCisloZadatele", "W");
        rights.put("field_poznamka", "W");
        
        if("FULL".equals(secret)){
            return rights;
        } else if("READONLY".equals(secret)){
            rights.put("field_datumDoruceni", "R");
            rights.put("field_datumOdeslani", "R");

            rights.put("field_keDni", "R");
            rights.put("field_lhuta", "R");
            rights.put("field_vyrizujeOsoba", "R");
            rights.put("field_jednaciCislo", "R");
            rights.put("field_jednaciCisloZadatele", "R");
            rights.put("field_poznamka", "R");
        
            return rights;
        } else {
            throw new ForbiddenException();
        }
    }
    
}
