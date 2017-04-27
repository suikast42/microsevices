package eu.amova.cloud.platform.service.security.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: vuru
 * Date: 26.04.2017
 * Time: 11:07
 */
@RestController
@RequestMapping(value = "/test",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
public class TestRestResource {

   @Autowired
   private HttpServletRequest request;

    @RequestMapping(value = "/greeting",method = RequestMethod.GET)
    public ResponseEntity greeting(@RequestParam(value="name", defaultValue="World") String name) {
      return   ResponseEntity.status(HttpStatus.OK).body("Hello "+ request.getRemoteUser() +" "+request.getRemoteAddr());
    }
}
