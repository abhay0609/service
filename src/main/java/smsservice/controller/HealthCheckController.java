package smsservice.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
  private Boolean serverUp = false;

  @RequestMapping(value = "/health/status", method = RequestMethod.GET)
  public ResponseEntity healthStatus(HttpServletRequest httpRequest) {
    if (!serverUp) return new ResponseEntity(HttpStatus.SERVICE_UNAVAILABLE);
    else {
      return new ResponseEntity(HttpStatus.OK);
    }
  }

  @RequestMapping(value = "/health/markUp", method = RequestMethod.POST)
  public ResponseEntity markUp(HttpServletRequest httpRequest) {
    serverUp = true;
    return new ResponseEntity(HttpStatus.OK);
  }


  @RequestMapping(value = "/health/markDown", method = RequestMethod.POST)
  public ResponseEntity markDown(HttpServletRequest httpRequest) {
    serverUp = false;
    return new ResponseEntity(HttpStatus.OK);
  }
}
