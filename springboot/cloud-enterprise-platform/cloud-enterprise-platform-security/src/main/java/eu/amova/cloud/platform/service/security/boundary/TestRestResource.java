package eu.amova.cloud.platform.service.security.boundary;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: vuru
 * Date: 26.04.2017
 * Time: 11:07
 */
@RestController
@RequestMapping(value = "/test",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
public class TestRestResource {


    @RequestMapping(value = "/greeting",method = RequestMethod.GET)
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
      return "Hello "+name;
    }
}
