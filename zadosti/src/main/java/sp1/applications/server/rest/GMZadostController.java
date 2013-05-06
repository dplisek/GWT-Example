package sp1.applications.server.rest;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import sp1.applications.server.common.BadRequestException;
import sp1.applications.server.common.ForbiddenException;
import sp1.applications.server.entity.GMZadost;
import sp1.applications.server.service.GMZadostService;
import sp1.applications.server.service.SecurityService;

/**
 *
 * @author JakubPetr
 */
@Controller
@RequestMapping("/gmzadost")
public class GMZadostController {

    @Autowired
    private GMZadostService zadostService;
    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public @ResponseBody
    GMZadost get(@RequestHeader(value = "secret", defaultValue = "XXX") String secret, @PathVariable Integer id) throws ForbiddenException {
        securityService.getAccessRights(secret);

        return zadostService.get(id);
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    public @ResponseBody
    List<GMZadost> filter(@RequestHeader(value = "secret", defaultValue = "XXX") String secret,
            @RequestParam(value = "jednaciCislo", required = false) String jednaciCislo,
            @RequestParam(value = "jednaciCisloZadatele", required = false) String jednaciCisloZadatele,
            @RequestParam(value = "datumDoruceniOd", required = false) String datumDoruceniOdStr,
            @RequestParam(value = "datumDoruceniDo", required = false) String datumDoruceniDoStr) throws ForbiddenException, BadRequestException {
        securityService.getAccessRights(secret);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        Date datumDoruceniOd = null;
        Date datumDoruceniDo = null;
        
        try{
            if(datumDoruceniOdStr != null){
                datumDoruceniOd = new Date( dateFormat.parse(datumDoruceniOdStr).getTime() );
            }
            
            if(datumDoruceniDoStr != null){
                datumDoruceniDo = new Date( dateFormat.parse(datumDoruceniDoStr).getTime() );
            }
        } catch(ParseException e){
            throw new BadRequestException();
        }
        
        return zadostService.filter(jednaciCislo, jednaciCisloZadatele, datumDoruceniOd, datumDoruceniDo);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "create", method = RequestMethod.POST, headers = "Accept=application/json")
    public void create(@RequestHeader(value = "secret", defaultValue = "XXX") String secret, @RequestBody GMZadost entity) throws ForbiddenException, BadRequestException {
        HashMap<String, String> accessRights = securityService.getAccessRights(secret);

        zadostService.fillEntity(new GMZadost(), entity, accessRights);
        try {
            zadostService.create(entity);
        } catch (Exception e) {
            throw new BadRequestException();
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "update", method = RequestMethod.POST, headers = "Accept=application/json")
    public void update(@RequestHeader(value = "secret", defaultValue = "XXX") String secret, @RequestBody GMZadost entity) throws ForbiddenException, BadRequestException {
        HashMap<String, String> accessRights = securityService.getAccessRights(secret);

        GMZadost actual = zadostService.get(entity.getZadostId());
        if (actual != null) {
            zadostService.fillEntity(actual, entity, accessRights);
            try {
                zadostService.update(entity);
            } catch (Exception e) {
                throw new BadRequestException();
            }
        } else {
            throw new BadRequestException();
        }
    }

    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void forbiddenAccessException() {
        System.out.println("Forbidden access.");
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void badRequestException() {
        System.out.println("Bad request.");
    }
}
